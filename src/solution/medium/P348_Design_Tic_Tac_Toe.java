package solution.medium;

import design.TicTacToe;

/**
 * @author Yi-Lo
 * 2021/2/5 10:39
 * @version 1.0
 * @topics Design
 * @urllink https://leetcode-cn.com/problems/design-tic-tac-toe/
 */
public class P348_Design_Tic_Tac_Toe {

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);
        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
    }
}
