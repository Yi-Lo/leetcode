package solution.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yi-Lo
 * 2020/11/10 16:17
 * @version 1.0
 * @topics Greedy
 * @urllink https://leetcode-cn.com/problems/walking-robot-simulation/
 */
public class P874_Walking_Robot_Simulation {

    public static int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        Set<String> obstacle = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            int[] pos = obstacles[i];
            obstacle.add(getPosStr(pos[0], pos[1]));
        }
        int ans = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                // turn left
                di = (di + 3) % 4;
            } else if (cmd == -1) {
                // turn right
                di = (di + 1) % 4;
            } else {
                for (int j = 0; j < cmd; j++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    String pos = getPosStr(nx, ny);
                    if (!obstacle.contains(pos)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }

    public static String getPosStr(int x, int y) {
        return x + "-" + y;
    }

    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{0, 2}};
        System.out.println(robotSim(commands, obstacles));
    }
}
