package solution.medium;

import structure.UnionFind;

/**
 * @author Yi-Lo
 * 2020/12/1 12:58
 * @version 1.0
 * @topics Depth-first Search、Union Find
 * @urllink https://leetcode-cn.com/problems/number-of-provinces/
 */
public class P547_Number_of_Provinces {

    public static int findCircleNum_s1(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }


    public static int findCircleNum_s2(int[][] M) {
        int count = 0;
        boolean[] isVisited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!isVisited[i]) {
                DFS(M, isVisited, i);
                count++;
            }
        }
        return count;
    }

    public static void DFS(int[][] M, boolean[] isVisited, int i) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && !isVisited[j]) {
                isVisited[j] = true;
                DFS(M, isVisited, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum_s2(M));
    }
}
