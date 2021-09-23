package ru.mephi.java_course.lab1;

public class MyList {
    private Object[] items;

    public Object[] getItems() {
        return items;
    }

    public void setItems(Object[] items) {
        this.items = items;
    }


    public MyList(Object[] newItems) {
        this.items = newItems;
    }

    public MyList(int size) {
        if(!checkIfLessThanZero(size)) {
            this.items = new Object[size];
        }
    }

    public MyList(MyList list) {
        this.items = list.items;
    }

    public MyList() {
        this.items = new Object[0];
    }

    //checks
    public boolean checkIfLessThanZero(int index) {
        return index < 0;
    }

    public boolean checkIfOutOfRange(int index) {
        return index < 0 || index >= items.length;
    }

    public boolean checkValueIfNull(Object obj) {
        return obj == null;
    }

    public void makeBigger() {
        int newSize = items.length + 1;
        Object[] newItems = new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, newItems.length - 1);
        items = newItems;
    }

    //adding new item
    public void add(Object value){
        makeBigger();
        items[items.length - 1] = value;
    }

    //adding new item by value
    public void add(Object value, int index)  {
        if(!checkIfLessThanZero(index)) {
            makeBigger();
            System.arraycopy(items, index, items, index + 1, size() - index - 1);
            items[index] = value;
        }
        else System.out.println("index can't be less than zero");
    }

    //get item by index
    public Object get(int index)  {
        if(checkIfOutOfRange(index)) return null;
        return this.items[index];
    }

    //get index of item: if list contains it, return index of its first occurrence in list
    public int indexOf(Object value) {
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] == value) return i;
        }
        return -1;
    }

    //get list size
    public int size() {
        return this.items.length;
    }

    //check if list is empty
    public boolean isEmpty() {
        return this.items.length==0;
    }

    //check if list contains the value
    public boolean contains(Object value)  {
        return indexOf(value) != -1;
    }

    //update the existing value
    public Object set(Object value, int index) {
        Object oldObject = null;
        if(!checkIfOutOfRange(index)) {
            oldObject = items[index];
            items[index] = value;
        }
        else{
            System.out.println("index is out of bounds!");
        }
        return oldObject;
    }

    //remove item from list
    public Object remove(int index) {
        Object toDelete = null;
        if(!checkIfOutOfRange(index)) {
            toDelete = get(index);
            int move = size() - index - 1;
            if (move > 0) {
                System.arraycopy(items, index + 1, items, index, move);
            }
            int tmpIndex = size() - 1;
            items[tmpIndex] = null;
            Object[] newItems = new Object[items.length - 1];
            System.arraycopy(items, 0, newItems, 0, newItems.length);
            items = newItems;
        }
        else{
            System.out.println("Can't remove not existing element!");
        }
        return toDelete;
    }

    public Object remove(Object value)  {
        if (indexOf(value) == -1){
            System.out.println("Can't remove not existing element!");
            return null;
        }
        return remove(indexOf(value));
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            builder.append(items[i] + "\n");
        }
        return builder.toString();
    }
}
