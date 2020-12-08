package solution.medium;

import java.util.*;

/**
 * @author Yi-Lo
 * 2020/12/8 17:43
 * @version 1.0
 * @topics Sort、Design、Hash Table
 * @urllink https://leetcode-cn.com/problems/design-a-leaderboard/
 */
public class P1244_Design_A_Leaderboard {

    static class Leaderboard {

        private Map<Integer, Integer> map;

        public Leaderboard() {
            map = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            Integer cur = map.get(playerId);
            if (cur == null) cur = 0;
            map.put(playerId, cur + score);
        }

        public int top(int K) {
            int sum = 0;
            List<Integer> lst = new ArrayList<>();
            lst.addAll(map.values());
            Collections.sort(lst, (o1, o2) -> o2 - o1);
            for (int val : lst) {
                K--;
                sum += val;
                if (K == 0) break;
            }
            return sum;
        }

        public void reset(int playerId) {
            map.put(playerId, 0);
        }
    }

    public static void main(String[] args) {
        Leaderboard board = new Leaderboard();
        board.addScore(1, 73);
        board.addScore(2, 56);
        board.addScore(3, 39);
        board.addScore(4, 51);
        board.addScore(5, 4);
        System.out.println(board.top(1));
        board.reset(1);
        board.reset(2);
        board.addScore(2, 51);
        System.out.println(board.top(3));
    }
}