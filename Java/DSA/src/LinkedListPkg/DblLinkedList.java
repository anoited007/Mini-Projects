package LinkedListPkg;

public class DblLinkedList<T> implements IDblLinkedList<T> {
    private DblNode<T> head, next, prev, tail;
    private int size;

    public DblLinkedList(){
        head = null;
        next = null;
        prev = null;
        tail = null;
        size = 0;
    }

    public DblLinkedList(DblNode<T> head){
        this.head = head;
        next = null;
        prev = null;
        tail = null;
        size = 1;
    }

    public DblNode<T> getHead() {
        return head;
    }

    public void setHead(DblNode<T> head) {
        this.head = head;
    }

    public DblNode<T> getTail() {
        return tail;
    }

    public void setTail(DblNode<T> tail) {
        this.tail = tail;
    }

    public DblNode<T> getNext() {
        return next;
    }

    public void setNext(DblNode<T> next) {
        this.next = next;
    }

    public DblNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DblNode<T> prev) {
        this.prev = prev;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void addFirst(DblNode<T> node) {
        if(head == null){
            this.head = node;
            size++;
        }

        else {
            DblNode<T> temp = head;
            head = node;
            head.setNext(temp);
            temp.setPrev(node);
            node.setPrev(null);
            size++;
        }

    }

    @Override
    public void addAtPos(DblNode<T> node, int position) throws IndexOutOfBoundsException {
        // setting counter to 1 because the first node is taken care of as a special scenario.
        int counter = 1;

        //Separating the error messages to provide a more meaningful error messages.

        if (position < 0) {
            throw new IndexOutOfBoundsException("The position entered is less than 0. Enter a value between 0 and " + size + ".");

        } else if (position > size) {
            throw new IndexOutOfBoundsException("The position specified is more than the size of the list. " + "Enter a value between 0 and " + size + ".");
        } else {
            if (position == 0) {
                addFirst(node); //add first already increases the size of the list so no need to increase it again.

            }

            /*
            * If position is equal to size plus one, it means we are trying to add to the end of the list so we just
            * call addLast method.
             */
            else if( position == size + 1) {
                addLast(node);

            }

            else {
                // A temporary node keep track of the nodes
                DblNode<T> temp = head.getNext();
                DblNode<T> prev = head;
                while ((temp.hasNext())) {
                    if (counter == position) {
                        prev.setNext(node);
                        node.setPrev(prev);
                        node.setNext(temp);
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
    public void addLast(DblNode<T> node) {
        DblNode<T> temp = tail;
        temp.setNext(node);
        tail = node;
        tail.setPrev(temp);
        size++;
    }

    @Override
    public DblNode<T> removeFirst() {
        DblNode<T> removedNode = head;
        DblNode<T> newHead = head.getNext();
        head = null;
        this.head = newHead;
        newHead.setPrev(null);
        size--;
        return removedNode;
    }

    @Override
    public DblNode<T> removeAtPos(int position) {
        int counter = 1;
        DblNode<T> removedNode = null;

        if (position < 0) {
            throw new IndexOutOfBoundsException("The position entered is less than 0. Enter a value between 0 and " + size + ".");

        } else if (position > size) {
            throw new IndexOutOfBoundsException("The position specified is more than the size of the list. " + "Enter a value between 0 and " + size + ".");
        }

        else {
            if (position == 0) {
                removeFirst();
                size--;
            }

            else if(position == size -1) removeLast();


            else {
                // A temporary node keep track of the nodes
                DblNode<T> temp = head.getNext();

                DblNode<T> prev = head.getPrev();


                while ((temp.hasNext())) {

                    if (counter == position) {
                        prev.setNext(temp.getNext());
                        removedNode = temp;
                        temp = null;
                        size--;
                    }
                }

            }

            return removedNode;
        }
    }

    @Override
    public DblNode<T> removeLast() {
        DblNode<T> temp = tail;
        DblNode<T> removedNode = null;
        DblNode<T> prev = temp.getPrev();
        removedNode = tail; //assign the old tail to the removed node object.
        tail = prev; //assign the prev of old tail as the new tail
        tail.setNext(null);  //assign the next of the new tail to null to remvoe reference to the old tail.
        temp = null; // remove the previous tail
        size--;
        return removedNode;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public DblNode<T>[] empty() {
        DblNode<T> temp = head;
        DblNode<T>[] removedNodes = (DblNode<T>[]) new Object[size];
        //setting a counter to fill the array of removed nodes
        int counter = 0;

        if(this.size == 0)
            System.out.println("The list is already empty");

        else if(this.size == 1) {
            removedNodes[counter] = head;
            head = null;
        }

        else{
            while(temp.hasNext()){
                DblNode<T> next;
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
