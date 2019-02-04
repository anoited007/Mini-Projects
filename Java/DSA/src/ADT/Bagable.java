package ADT;

public interface Bagable<T> {
    //Open the bag
    void open();

    //Add item to the bag
    void add(T t);

    //Remove item from the bag
    T remove(T t);

    //Empty the bag
    T[] empty();

    //Check if bag is empty
    boolean isEmpty();

    //Check if bag is full (since we will use Arrays to store data)
    boolean isFull();
}

