package QueuePkg;

import LinkedListPkg.DblLinkedList;
import LinkedListPkg.DblNode;

public class Queue<T> implements IQueue<T> {
    //private int size;
    private DblLinkedList<T> data; //

    public Queue(){
        data = new DblLinkedList<>();
    }


    @Override
    public void enqueue(T element) {
        DblNode node = new DblNode(element);
        data.addLast(node);
    }

    @Override
    public T dequeue() {

        return data.removeFirst().getData();
    }

    @Override
    public T peek() {
        return data.getHead().getData();
    }

    @Override
    public boolean isEmpty() {
        return data.getSize() == 0;
    }

    @Override
    public int size() {
        return data.getSize();
    }
}
