package ru.mephi.javacourse.lab1;

/**
 * Класс словаря, основанный на разработанном списке MyList
 */
public class MyMap {
    private MyList list;


    /**
     * Инициализация существующей мапой
     * @param map
     */
    public MyMap(MyMap map) {
        this.list = map.list;
    }

    /**
     * Инициализация массивом пар "ключ-значение"
     * @param mapEntries
     */
    public MyMap(MapEntry[] mapEntries) {
        this.list = new MyList(mapEntries);
    }

    /**
     * дефолтный конструктор
     */
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

    /**
     * Проверка, пуст ли список
     * @return true, если список пуст
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Получение размера списка - количество пар "ключ-значение"
     * @return true, если лист пустой
     */
    public int size() {
        return list.size();
    }

    /**
     * Получение всех ключей
     * @return ключи словаря
     */
    public MyList getKeys() {
        MyList keysList = new MyList();
        for (Object keyItem : list.getItems()) {
            if (keyItem instanceof MapEntry) {
                keysList.add(((MapEntry) keyItem).getKey());
            }
        }
        return keysList;
    }

    /**
     * Получение всех значений
     * @return значения словаря
     */
    public MyList getValues() {
        MyList valuesList = new MyList();
        for (Object valueItem : this.list.getItems()) {
            if (valueItem instanceof MapEntry) {
                valuesList.add(((MapEntry) valueItem).getValue());
            }
        }
        return valuesList;
    }

    /**
     * Получение всех пар "ключ-значение"
     * @return пара "ключ-значение"
     */
    public MyList getEntries() {
        return list;
    }

    /**
     * Проверка, существует ли значение в словаре по данному ключу
     * @param key указанный ключ
     * @return true, если есть значение по данному ключу
     */
    public boolean keyContains(Object key) {
        return getKeys().contains(key);
    }

    /**
     * Получение соответсвующего значения по ключу
     * @param key ключ
     * @return найденное значение или null, если нет такого ключа в словаре
     */
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

    /**
     * Удаление пары "ключ-значение" по ключу. Если такого ключа нет, то ничего не удаляется.
     * @param key ключ удаляемой пары
     * @return удаляемое значение, если такая пара есть, или null
     */
    public Object remove(Object key) {
        if (keyContains(key)) {
            int indexOfValue = getKeys().indexOf(key);
            Object deletedItem = get(key);
            list.remove(indexOfValue);
            return deletedItem;
        }
        return null;
    }

    /**
     * Получение значение, соответствующее ключу.
     * Если такого ключа нет в словаре, то возвращается значение по умолчанию, оно же кладется в словарь по данному ключу.
     * @param key искомый ключ
     * @param byDefault значение по умолчанию
     * @return найденное значение (если есть такой ключ в словаре) или дефолтное значение
     */
    public Object get(Object key,
                      Object byDefault) {
        if (get(key) != null) return get(key);

        put(key, byDefault);
        return byDefault;
    }


}
