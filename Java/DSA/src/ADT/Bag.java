package ADT;

import java.util.Random;

public class Bag<MAndM> implements Bagable<MAndM> {
    private boolean empty;
    private boolean full;
    private boolean isOpen;
    private boolean isClosed;
    private MAndM[] items;
    private int counter;

    public Bag(int capacity) {
        items = (MAndM[]) new Object[capacity];
        empty = true;
        full = false;
        isClosed = false;
        counter = 0;
    }

    public Bag(){
        items = (MAndM[]) new Object[50];
        empty = true;
        isClosed = false;
        full = false;
        counter = 0;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public MAndM[] getItems() {
        return items;
    }

    public void setItems(MAndM[] items) {
        this.items = items;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean closed) {
        isClosed = closed;
    }

    public void open(){
        if(getIsClosed()){
            setIsOpen(true);
            setIsClosed(false);
            System.out.println("The bag is opened");
        }

        else
            System.out.println("The bag is already opened");
    }

    public void add(MAndM item){
        if(counter < items.length -1){
            items[counter] = item;
            counter++;
        }

    }


    public MAndM remove(MAndM item){
        MAndM removed = null;
        if(isEmpty()){
            System.out.println("The bag is empty");
        }

        else{
            Random random = new Random();
            int number = random.nextInt(items.length);
             removed = items[number];
            items[number] = null; //Problem is how to fill it after removing from the array. Not catered for.
        }


        return removed;
    }

    public MAndM[] empty(){
        MAndM[] temp = items; // Setting array to return after clearing array.
        if(isEmpty()) {
            System.out.println("The bag is already empty");
        }

        else{
            items = null;
        }
        return temp;
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isFull(){
        return full;
    }


}

