package LinkedListPkg;

public interface IDblLinkedList<T> {
    // add a node to the beginning of the LinkedListPkg
    void addFirst(DblNode<T> node);

    // add a node to a position in the LinkedListPkg
    void addAtPos(DblNode<T> node, int position) throws IndexOutOfBoundsException;

    // add a node to the end of the Linked List
    void addLast(DblNode<T> node);

    // remove a node from the beginning
    DblNode<T> removeFirst();

    //remove a node from a position
    DblNode<T> removeAtPos(int position);

    // remove a node from the end
    DblNode<T> removeLast();

    //get size of the LinkedList
    int size();

    //empty the linked list
    DblNode<T>[] empty();
}
