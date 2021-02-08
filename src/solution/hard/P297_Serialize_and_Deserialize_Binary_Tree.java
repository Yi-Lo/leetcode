package solution.hard;

import design.Codec;
import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2020/11/2 18:10
 * @version 1.0
 * @topics Tree、Design
 * @urllink https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class P297_Serialize_and_Deserialize_Binary_Tree {

    public static void main(String[] args) {
        String data = "1!2!#!#!3!4!#!#!5!#!#!";
        TreeNode root = Codec.deserialize(data);
        System.out.println(Codec.serialize(root));
    }
}
