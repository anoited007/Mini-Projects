package LinkedListPkg;

public class DblNode<T> {
    private T data;
    private DblNode<T> next;
    private DblNode<T> prev;

    public DblNode() {
        data = null;
        next = null;
        prev = null;
    }

    public DblNode(T data) {
        this.data = data;
        next = null;
        prev = null;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    public boolean hasNext() {
       return this.next == null;
    }

    public boolean hasPrev(){
       return this.prev == null;
    }
}
