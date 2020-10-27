package structure;

import java.util.List;

/**
 * @author Yi-Lo
 * 2020/10/27 18:41
 * @version 1.0
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        val = val;
    }

    public Node(int val, List<Node> children) {
        val = val;
        children = children;
    }
}
