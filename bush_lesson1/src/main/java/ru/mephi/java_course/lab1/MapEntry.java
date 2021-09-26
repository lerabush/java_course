package ru.mephi.java_course.lab1;

public class MapEntry {
    /**
     * Класс пары "ключ-значение"
     */

    private Object key;
    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public MapEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[ " + this.key + ": " + this.value + " ]";
    }

}

