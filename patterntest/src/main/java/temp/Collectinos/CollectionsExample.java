package temp.Collectinos;

import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {
        List<Integer> integerArrayListist = new ArrayList<Integer>();
        integerArrayListist.add(1);
        integerArrayListist.add(3);
        integerArrayListist.add(5);
        for (Object o : integerArrayListist) {
            System.out.println(o);
        }

        //"Returns an immutable list containing only the specified object.
        // The returned list is serializable."
        //Use it when code expects a read-only list,
        // but you only want to pass one element in it.
        // singletonList is (thread-)safe and fast.
        List<Object> singletonList = Collections.singletonList(new ArrayList<Integer>());
        //singletonList.addAll(integerArrayListist);
        //throws UnsupportedOperationException
        System.out.println(singletonList);

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(4);
        queue.add(9);
        System.out.println(queue.peek());
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll());
        }

        Queue<Object> linkedQueue = new LinkedList<Object>();
        linkedQueue.add(1);
        linkedQueue.add(3);

        for (Object o : linkedQueue) {
            System.out.println(o.toString());
        }

    }


}
