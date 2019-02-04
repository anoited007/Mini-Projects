package Stackpkg;

public class ArrStack<T> implements IStack<T> {
    //the length property specifies the length of the array
    private int length;

    //the size property gives the number of elements in the stack
    private int size ;
    private T[] data;
    private boolean empty;
    private int topIndex;

    public ArrStack(){
        length = 30;
        empty = true;

        // the topIndex is incremented by 1 anytime an object is added so starting at -1 will make it possible to start
        // counting at 0 when an object is added.
        topIndex = -1;
        data = (T[]) new Object[length];
        size = 0;
    }

    public ArrStack(int length) {
        this.length = length;
        empty = true;
        size = 0;
        topIndex = -1;
        data = (T[]) new Object[length];
    }

    public int getLength() {
        return length;
    }

    public int getSize() {
        return size;
    }

    public int getTopIndex() {
        return topIndex;
    }

    public void setTopIndex(int topIndex) {
        this.topIndex = topIndex;
    }

    @Override
    public T pop() {
        if(isEmpty()) return null;

        else{
            T popped = data[topIndex];
            data[topIndex] = null;
            topIndex--;
            size--;
            empty = size == 0; //always check if after popping, size is not 0 so that empty can be updated.
            return popped;
        }
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;

        else return data[topIndex];
    }

    @Override
    public T push(T element) {
        if(isFull()) return null;

        else{
            data[topIndex+1] = element;
            topIndex++;
            //ensure empty is false after adding to stack. @Stephen is it necessary?
            empty = false;
            size++;
        }
        return element;
    }

    private boolean isFull(){
       return size == data.length;
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }

}