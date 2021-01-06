package solution.medium;

/**
 * @author Yi-Lo
 * 2021/1/6 14:26
 * @version 1.0
 * @topics Stack、Depth-first Search
 * @urllink https://leetcode-cn.com/problems/decode-string/
 */
public class P394_Decode_String {

    public static String decodeString(String s) {
        char[] chs = s.toCharArray();
        return dfs(chs, 0, chs.length - 1, new StringBuilder());
    }

    public static String dfs(char[] chs, int start, int end, StringBuilder builder) {
        while (start <= end && Character.isLetter(chs[start])) {
            builder.append(chs[start++]);
        }
        int digital = 0;
        while (start <= end && Character.isDigit(chs[start])) {
            int num = chs[start++] - '0';
            digital = 10 * digital + num;
        }
        if (start >= end) return builder.toString();
        if (digital > 0) {
            String ss = dfs(chs, start, end, new StringBuilder());
            start += ss.length() + 1;
            if (ss.contains("[")) {
                ss = dfs(ss.toCharArray(), 0, ss.length() - 1, new StringBuilder());
            }
            for (int i = 0; i < digital; i++) {
                builder.append(ss);
            }
        }
        if (chs[start] == '[') {
            int count = 1;
            for (int i = start + 1; i < end; i++) {
                builder.append(chs[i]);
                if (chs[i] == '[') count++;
                if (chs[i + 1] == ']') count--;
                if (count == 0) return builder.toString();
            }
        }
        return dfs(chs, start + 1, end, builder);
    }

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("abc3[cd]xyz"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
