package solution.medium;

/**
 * @author Yi-Lo
 * 2021/1/21 19:26
 * @version 1.0
 * @topics Greedy
 * @urllink https://leetcode-cn.com/problems/gas-station/
 */
public class P134_Gas_Station {

    public static int canCompleteCircuit_s1(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) continue;
            int tank = gas[i] - cost[i];
            for (int j = 1; j <= gas.length; j++) {
                int station = (i + j) % gas.length;
                tank += gas[station];
                if (i == station) return i;
                if (tank >= cost[station]) {
                    tank -= cost[station];
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static int canCompleteCircuit_s2(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }
        boolean find = true;
        int tank = 0, next = 0;
        while (next < gas.length) {
            for (int j = 0; j < gas.length; j++) {
                tank += gas[(next + j) % gas.length];
                if (tank < 0) {
                    find = false;
                    next += j + 1;
                    break;
                }
            }
            if (find) {
                return next;
            } else {
                tank = 0;
                find = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit_s1(gas, cost));
        System.out.println(canCompleteCircuit_s2(gas, cost));
    }
}
