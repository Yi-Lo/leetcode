package design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/2/2 11:12
 * @version 1.0
 */
public class NestedIterator implements Iterator<Integer> {

    public Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        LinkedList<Integer> queue = new LinkedList<>();
        initQueue(nestedList, queue);
        it = queue.iterator();
    }

    public void initQueue(List<NestedInteger> nestedList, LinkedList<Integer> queue) {
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                queue.addLast(element.getInteger());
            } else {
                initQueue(element.getList(), queue);
            }
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}
