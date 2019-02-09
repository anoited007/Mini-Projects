package QueuePkg;

public interface IQueue<T> {
    // Add an element to the tail of the queue
    void enqueue(T t);

    // remove an element from the front of the queue
    T dequeue();

    //return the element in the front element in the queue without removing it
    T peek();

    //return true if list is empty otherwise return false
    boolean isEmpty();

    //get the size of the queue
    int size();
}
