package design;

import structure.TreeNode;

import java.util.LinkedList;

/**
 * @author Yi-Lo
 * 2021/2/8 15:38
 * @version 1.0
 */
public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] values = data.split("!");
        LinkedList<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.add(value);
        }
        return rebuildTree(queue);
    }

    public static TreeNode rebuildTree(LinkedList<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = rebuildTree(queue);
        root.right = rebuildTree(queue);
        return root;
    }
}
