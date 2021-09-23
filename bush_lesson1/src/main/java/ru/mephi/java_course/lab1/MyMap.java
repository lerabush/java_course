package ru.mephi.java_course.lab1;

import java.util.Objects;

public class MyMap {
    private MyList list;

    public static class MapEntry {
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
        public boolean equals(Object obj) {
            return this.key == ((MapEntry) obj).key && this.value == ((MapEntry) obj).value;
        }

        @Override
        public String toString() {
            return "[ " + this.key + ": " + this.value + " ]";
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }


    public MyMap(MyMap map) {
        this.list = map.list;
    }

    public MyMap(MapEntry[] mapEntries) {
        this.list = new MyList(mapEntries);
    }

    public MyMap() {
        this.list = new MyList();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object keyItem : list.getItems()) {
            builder.append(((MapEntry) keyItem).toString() + "\n");
        }
        return builder.toString();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    //получить все ключи
    public MyList getKeys() {
        MyList keysList = new MyList();
        for (Object keyItem : list.getItems()) {
            if (keyItem instanceof MapEntry) {
                keysList.add(((MapEntry) keyItem).getKey());
            }
        }
        return keysList;
    }

    //получить все значения
    public MyList getValues() {
        MyList valuesList = new MyList();
        for (Object valueItem : this.list.getItems()) {
            if (((MapEntry) valueItem).getValue() != null) {
                valuesList.add(((MapEntry) valueItem).getValue());
            }
        }
        return valuesList;
    }

    //получить все вхождения в мапу
    public MyList getEntries() {
        return list;
    }

    //существует ли ключ
    public boolean keyContains(Object key) {
        return getKeys().contains(key);
    }

    //получение по ключу
    public Object get(Object key) {
        if (keyContains(key)) {
            int indexOfValue = getKeys().indexOf(key);
            return getValues().get(indexOfValue);
        }
        return null;
    }

    //кладем новое значение или переписываем существующее
    public void put(Object key, Object value) {
        if (keyContains(key)) {
            int indexOfValue = getKeys().indexOf(key);
            ((MapEntry) list.get(indexOfValue)).setValue(value);
        } else {
            MapEntry newEntry = new MapEntry(key, value);
            list.add(newEntry);
        }
    }

    //удаляем существующее значение
    public Object remove(Object key) {
        if (keyContains(key)) {
            int indexOfValue = getKeys().indexOf(key);
            Object deletedItem = get(key);
            list.remove(indexOfValue);
            return deletedItem;
        }
        return null;
    }

    //получаем существующее значение. если null - то кладем и возвращаем дефолтное значение
    public Object get(Object key, Object byDefault) {
        if (get(key) != null) return get(key);

        put(key, byDefault);
        return byDefault;
    }


}
