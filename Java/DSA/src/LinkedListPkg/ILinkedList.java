package LinkedListPkg;

 public interface ILinkedList<T> {
    // add a node to the beginning of the LinkedListPkg
     void addFirst(Node<T> node);

     // add a node to a position in the LinkedListPkg
     void addAtPos(Node<T> node, int position) throws IndexOutOfBoundsException;

     // add a node to the end of the Linked List
     void addLast(Node<T> node);

     // remove a node from the beginning
     Node<T> removeFirst();

     //remove a node from a position
     Node<T> removeAtPos(int position);

     // remove a node from the end
     Node<T> removeLast();

     //get size of the LinkedList
     int size();

     //empty the linked list
    Node<T>[] empty();

}
