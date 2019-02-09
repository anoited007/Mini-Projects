package Stackpkg;

import LinkedListPkg.LinkedList;
import LinkedListPkg.Node;

/* Stack implementation using singly linked list */

public class LinkedListStack<T> implements IStack<T> {
    private LinkedList<T> data;


    public LinkedListStack(){
        data = new LinkedList<>();

    }

    public LinkedListStack(T element){
        Node<T> node = new Node<>(element);
        data = new LinkedList<>(node);

    }

    @Override
    public T pop() {
        //check if the size of the stack is 0 return null or return the data in the node after calling remove last method
        return data.size() == 0 ? null : data.removeLast().getData();
    }

    @Override
    public T peek() {
        T topElement = null;
        if(data.size() == 0) return topElement;

        else {
            Node<T> temp = data.getHead();
            while(temp.hasNext()){
                temp = temp.getNext();
                if(temp.getNext() == null) topElement = temp.getData();
            }
        }

        return topElement;
    }

    @Override
    public T push(T element) {
        Node<T> node = new Node<>(element);
        data.addFirst(node);
        return element;
    }

    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }
}
