package ru.mephi.java_course.lab1;

public class MyList {
    private Object[] items;

    public MyList(Object[] newItems) {
        this.items = newItems;
    }

    public MyList(int size) throws Exception {
        checkIndex(size);
        this.items = new Object[size];
    }

    public MyList(MyList list) {
        this.items = list.items;
    }

    public MyList() {
        this.items = new Object[10];
    }

    //checks
    public void checkIndex(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("The value is out of bounds!");
    }

    public void rangeCheck(int index) {
        if (index < 0 || index >= items.length) throw new ArrayIndexOutOfBoundsException("The value is out of bounds!");
    }

    public void checkValue(Object obj) {
        if (obj == null) throw new NullPointerException("Value can't be null!");
    }

    public void makeBigger() {
        int newSize = items.length + 1;
        Object[] newItems = new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, newItems.length - 1);
        items = newItems;
    }

    //adding new item
    public void add(Object value) throws Exception {
        checkValue(value);
        makeBigger();
        items[items.length - 1] = value;
    }

    //adding new item by value
    public void add(Object value, int index) throws Exception {
        checkValue(value);
        checkIndex(index);
        makeBigger();
        System.arraycopy(items, index, items, index + 1, size() - index - 1);
        items[index] = value;
    }

    //get item by index
    public Object getByIndex(int index) throws Exception {
        rangeCheck(index);
        return this.items[index];
    }

    //get index of item: if list contains it, return index of its first occurrence in list
    public int getIndexOf(Object value)  {

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
        for(int i=0;i<size();i++){
            if(items[i]!=null) return false;
        }
        return true;
    }

    //check if list contains the value
    public boolean contains(Object value) throws Exception {
        return getIndexOf(value) != -1;
    }

    //update the existing value
    public Object set(Object value, int index) throws Exception {
        rangeCheck(index);
        checkValue(value);
        Object oldObject = items[index];
        items[index] = value;
        return oldObject;
    }

    //remove item from list
    public Object remove(int index) throws Exception {
        rangeCheck(index);
        Object toDelete = getByIndex(index);
        int move = size() - index - 1;
        if (move > 0) {
            System.arraycopy(items, index + 1, items, index, move);
        }
        int tmpIndex = size() - 1;
        items[tmpIndex] = null;
        Object[] newItems = new Object[items.length - 1];
        System.arraycopy(items, 0, newItems, 0, newItems.length);
        items = newItems;
        return toDelete;
    }

    public Object remove(Object value) throws Exception {
        if (getIndexOf(value) == -1) throw new Exception("Can't delete not existing element!");
        return remove(getIndexOf(value));
    }


}
