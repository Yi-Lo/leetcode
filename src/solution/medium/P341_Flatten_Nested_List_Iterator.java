package solution.medium;

import design.NestedInteger;
import design.NestedIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/2/2 10:04
 * @version 1.0
 * @topics Stack、Design
 * @urllink https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 */
public class P341_Flatten_Nested_List_Iterator {

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        NestedIterator it = new NestedIterator(list);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
