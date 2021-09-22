package ru.mephi.java_course.lab1;

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
        public String toString() {
            return "[ " + this.key + ": " + this.value + " ]";
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
        for(Object keyItem:list.getItems()){
            builder.append(((MapEntry)keyItem).toString()+"\n");
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
    public MyList getKeys() throws Exception {
        MyList keysList = new MyList(0);
        for (Object keyItem : list.getItems()) {
            if (keyItem instanceof MapEntry) {
                keysList.add(((MapEntry) keyItem).getKey());
            }
        }
        return keysList;
    }

    //получить все значения
    public MyList getValues() throws Exception {
        MyList valuesList = new MyList(0);
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
    public boolean keyContains(Object key) throws Exception {
        return getKeys().contains(key);
    }
    //получение по ключу
    public Object get(Object key) throws Exception {
        if (keyContains(key)) {
            int indexOfValue = getKeys().getIndexOf(key);
            return getValues().getByIndex(indexOfValue);
        }
        return null;
    }
    //кладем новое значение или переписываем существующее
    public void put(Object key, Object value) throws Exception {
        if (keyContains(key)) {
            int indexOfValue = getKeys().getIndexOf(key);
            ((MapEntry) list.getByIndex(indexOfValue)).setValue(value);
        } else {
            MapEntry newEntry = new MapEntry(key, value);
            list.add(newEntry);
        }
    }
    //удаляем существующее значение
    public Object remove(Object key) throws Exception {
        if (keyContains(key)) {
            int indexOfValue = getKeys().getIndexOf(key);
            Object deletedItem = get(key);
            list.remove(indexOfValue);
            return deletedItem;
        }
        return null;
    }
    //получаем существующее значение. если null - то кладем и возвращаем дефолтное значение
    public Object get(Object key, Object byDefault) throws Exception {
        if (get(key) != null) return get(key);

        put(key, byDefault);
        return byDefault;

    }


}
