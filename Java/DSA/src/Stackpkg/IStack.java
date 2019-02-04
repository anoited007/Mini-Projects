package Stackpkg;

// Interface for Dynamic implementation of Stack
public interface IStack<T> {
    // remove an object from the top of the stack and return the removed object
    T pop();

    //return the object at the top of the stack but do not remove the object
    T peek();

    //add object to the top of the stack
    T push(T object);

    //return true if stack is empty or false if otherwise
    boolean isEmpty();

}
