package ru.mephi.java_course.lab1;

/*
 * Класс списка
 */
public class MyList {
    private Object[] items;

    public Object[] getItems() {
        return items;
    }

    public void setItems(Object[] items) {
        this.items = items;
    }

    /**
     * @param newItems массив элементов
     */


    public MyList(Object[] newItems) {
        this.items = newItems;
    }

    /**
     * @param size размер создаваемого списка
     */

    public MyList(int size) {
        if (!checkIfLessThanZero(size)) {
            this.items = new Object[size];
        }
    }

    /**
     * @param list инициализация созданным списком
     */

    public MyList(MyList list) {
        this.items = list.items;
    }

    /**
     * дефолтный конструктор
     */

    public MyList() {
        this.items = new Object[0];
    }

    /**
     * Проверяет, меньше ли нуля поданный индекс
     *
     * @param index
     * @return true, если меньше нуля
     */
    public boolean checkIfLessThanZero(int index) {
        return index < 0;
    }


    public boolean checkIfOutOfRange(int index) {
        return index < 0 || index >= items.length;
    }

    /**
     * Cлужебный метод для увеличения размера массива Object[]
     */

    public void makeBigger() {
        int newSize = items.length + 1;
        Object[] newItems = new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, newItems.length - 1);
        items = newItems;
    }

    /**
     * Добавление элемента в конец списка
     *
     * @param value
     */
    public void add(Object value) {
        makeBigger();
        items[items.length - 1] = value;
    }

    /**
     * Добавление элемента по индексу. Если индекс больше или равен размеру списка, то вставляем в конец.
     * Если меньше или равен нулю, то ставим в начало новый элементы
     *
     * @param value
     * @param index
     */
    public void add(Object value, int index) {
        makeBigger();
        if (checkIfLessThanZero(index) || index == 0) {
            System.arraycopy(items, 0, items, 1, size() - 1);
            items[0] = value;
        } else {
            System.arraycopy(items, index, items, index + 1, size() - index - 1);//cдвигаем элементы
            items[index] = value;
        }
    }

    /**
     * Получение элемента списка по индексу
     *
     * @param index индекс элемента
     * @return Если индекс выходит за границы списка, то возврашается null.
     */

    public Object get(int index) {
        if (checkIfOutOfRange(index)) return null;
        return this.items[index];
    }

    /**
     * Получение первого вхождения элемента в список
     *
     * @param value искомый объект
     * @return индекс первого встретившегося элемента, равного value.Если такой элемент не найден, возвращается -1
     */
    public int indexOf(Object value) {
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] == value) return i;
        }
        return -1;
    }

    /**
     * Получение размера списка
     *
     * @return размер списка
     */
    public int size() {
        return this.items.length;
    }

    /**
     * Проверка, пустой ли список
     *
     * @return true, если список пуст
     */
    public boolean isEmpty() {
        return this.items.length == 0;
    }

    /**
     * Проверка, содержит ли список данный элемент
     *
     * @param value искомый элемент
     * @return true, если искомый элемент есть в списке.
     */
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    /**
     * Обновление элемента на позиции index на новое значение value.
     * Если индекс выходит за границы списка, то вставляем как новый элемент списка.
     * @param value новое значение
     * @param index индекс обновляемого элемента
     * @return старое значение или null, если вставляли новый элемент
     */
    public Object set(Object value, int index) {
        Object oldObject = null;
        if (!checkIfOutOfRange(index)) {
            oldObject = items[index];
            items[index] = value;
        } else {
            add(value);
        }
        return oldObject;
    }

    /**
     * Удаление элемента по индексу.Если индекс выходит за границы списка, возвращается null.
     * Происходит сдвиг элементов влево
     * @param index индекс удаляемого значения
     * @return значение удаляемого элемента. Если индекс вне границ, то null.
     */
    public Object remove(int index) {
        Object toDelete = null;
        if (!checkIfOutOfRange(index)) {
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
        } else {
            System.out.println("Can't remove not existing element!");
        }
        return toDelete;
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
