package LinkedListPkg;

public class LinkedList<T> implements ILinkedList<T> {

    private Node<T> head;
    private int size = 0;

    public LinkedList(Node<T> head) {
        this.head = head;
        size++;
    }

    public LinkedList() {
        head = null;
    }

    public Node<T> getHead() {
        if(size > 0)
            return head;
        else
            return null;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int size() {
        return this.size;
    }

    @Override
    public void addFirst(Node<T> node) {
        if(head == null) this.head = node;

        else {
            Node<T> temp = head;
            head = node;
            head.setNext(temp);
            size++;
        }

    }

    @Override
    public void addAtPos(Node<T> node, int position) throws IndexOutOfBoundsException {
        // setting counter to 1 because the first node is taken care of as a special scenario.
        int counter = 1;
        //Separating the error messages to provide a more meaningful error messages.
        if (position < 0) {
            throw new IndexOutOfBoundsException("The position entered is less than 0. Enter a value between 0 and " + size + ".");

        } else if (position > size) {
            throw new IndexOutOfBoundsException("The position specified is more than the size of the list. " + "Enter a value between 0 and " + size + ".");
        } else {
            if (position == 0) {
                addFirst(node); //addFirst does the size increment as well.

            } else {
                // A temporary node keep track of the nodes
                Node<T> temp = head.getNext();

                /* using temporary variable temp to track previous nodes since this is a singly linked list.
                 *  another approach could be to manipulate the counter.*/
                Node<T> prev = head;
                while ((temp.hasNext())) {
                    if (counter == position) {
                        prev.setNext(node);
                    }
                    counter++;
                    prev = temp;
                    temp = temp.getNext();
                }
                size++;
            }

        }

    }

    @Override
    public void addLast(Node<T> node) {
        Node<T> temp = head;

        if(this.size() == 0){
            this.setHead(node);
            size++;
        }

        else {
            while (temp.hasNext()) {
                temp = temp.getNext();

                if (!temp.hasNext()) {
                    temp.setNext(node);
                    size++;
                }
            }
        }

    }

    @Override
    public Node<T> removeFirst() {
        Node<T> removedNode = head;
        Node<T> newHead = head.getNext();
        head = null;
        this.head = newHead;
        size--;
        return removedNode;
    }

    @Override
    public Node<T> removeAtPos(int position) {
        int counter = 1;
        Node<T> removedNode = null;

        if (position < 0) {
            throw new IndexOutOfBoundsException("The position entered is less than 0. Enter a value between 0 and " + size + ".");

        } else if (position > size) {
            throw new IndexOutOfBoundsException("The position specified is more than the size of the list. " + "Enter a value between 0 and " + size + ".");
        } else {
            if (position == 0) {
                removeFirst();
                size--;
            } else {
                // A temporary node keep track of the nodes
                Node<T> temp = head.getNext();

                /* using temporary variable temp to track previous nodes since this is a singly linked list.
                 *  another approach could be to manipulate the counter.*/
                Node<T> prev = head;


                while ((temp.hasNext())) {

                    if (counter == position) {
                        prev.setNext(temp.getNext());
                        removedNode = temp ;
                        temp = null;
                        size--;
                    }
                }

            }

            return removedNode;
        }
    }

    @Override
    public Node<T> removeLast() {
        Node<T> temp = head;
        Node<T> removedNode = null;

        while (temp.hasNext()) {
            temp = temp.getNext();

            if (!temp.hasNext()) {
                removedNode = temp;
                temp = null;
                size--;
            }
        }

        return removedNode;
    }

    @Override
    public Node<T>[] empty() {
        Node<T> temp = head;
        Node<T>[] removedNodes = (Node<T>[]) new Object[size];
        //setting a counter to fill the array of removed nodes
        int counter = 0;

        if(this.size == 0)
            System.out.println("The list is already empty");

        else if(this.size == 1) {
            removedNodes[counter] = head;
            head = null;

        }

        else{
            Node<T> next;
           while(temp.hasNext()){
               removedNodes[counter] = temp;

               /*assigning the next node to next variable before assigning to temp to avoid losing access to the next node.
                * after setting temp to null.
                */
               next = temp.getNext();
               temp = null;
               temp = next;
               counter++;
           }
        }
        this.size = 0;

        return removedNodes;
    }
}
