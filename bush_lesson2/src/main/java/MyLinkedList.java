/**
 * Класс односвязного списка
 */

public class MyLinkedList<T extends Comparable<T>> {
    /**
     * начало списка
     */
    private MyNode<T> head;
    /**
     * длина списка (количество элементов в нем)
     */
    private int length;

    /**
     * Get head
     *
     * @return начало списка
     */
    public MyNode<T> getHead() {
        return this.head;
    }

    /**
     * Изменяем начало списка
     *
     * @param newHead ссылка на узел, который хотим сделать началом
     */
    public void setHead(MyNode<T> newHead) {
        this.head = newHead;
    }

    /**
     * @return количество элементов в списке
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Изменяет длину списка
     *
     * @param length новая длина списка
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * default constructor
     */
    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * copy list
     *
     * @param prevList previous list which we want to copy
     */
    public MyLinkedList(MyLinkedList<T> prevList) {
        this.head = prevList.head;
        this.length = prevList.length;
    }

    /**
     * @return количество элементов в списке
     */
    public int size() {
        return this.length;
    }

    /**
     * Поиск индекса элемента
     *
     * @param value искомый элемент
     * @return индекс элемента в списке или -1, если его в списке нет или список пуст
     */
    public int indexOf(T value) {
        if (this.head != null) {
            int index = 0;
            MyNode<T> curr = head;
            while (curr != null) {
                if (curr.getValue() == value) break;
                index++;
                curr = curr.getNext();
            }
            if (curr != null) return index;
        }
        return -1;
    }

    /**
     * @param value проверяемое значение
     * @return true, если значение есть в списке, и false, если нет
     */
    public boolean contains(T value) {
        return indexOf(value) > 0;
    }

    /**
     * получение элемента по индексу
     *
     * @param index индекс искомого элемента
     * @return null, если элемент не найден или значение искомого элемента в случае успеха
     */
    public MyNode<T> get(int index) {
        if (this.head != null) {
            if (!isOutOfRange(index)) {
                MyNode<T> curr = this.head;
                for (int i = 0; i < index; i++) {
                    curr = curr.getNext();
                }
                return curr;
            }
        }
        return null;
    }

    /**
     * проверка, пустой ли список
     *
     * @return true, если список пуст, false если нет
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Добавить в конец списка новый элемент
     *
     * @param value добавляемое значение
     */
    public void add(T value) {
        MyNode<T> node = new MyNode<>(value);
        if (this.head == null) {
            this.head = node;
        } else {
            MyNode<T> curr = this.head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(node);
        }
        this.length += 1;
    }

    /**
     * Изменение значения узла списка
     *
     * @param value новое значение
     * @param index индекс переназначаемого элемента
     * @return старое значение или null, если индекс меньше нуля или больше длины списка
     */
    public MyNode<T> set(T value, int index) {
        MyNode<T> old = null;
        if (!isOutOfRange(index)) {
            MyNode<T> node = new MyNode<>(value);
            if (index == 0) {
                node.setNext(this.head.getNext());
                old = this.head;
                head = node;
            } else {
                MyNode<T> curr = this.head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.getNext();
                }
                old = curr.getNext();
                node.setNext(curr.getNext().getNext());
                curr.setNext(node);

            }

        }
        return old;
    }

    /**
     * Удаление элемента по индексу
     *
     * @param index индекс удаляемого элемента
     * @return удаляемое значение или null, если элемента с таким индексом нет
     */
    public MyNode<T> remove(int index) {
        MyNode<T> toDelete = null;
        if (!isOutOfRange(index)) {
            if (index == 0) {
                toDelete = this.head;
                this.head = this.head.getNext();
            } else {
                MyNode<T> curr = this.head;
                int i = 0;
                while (i < index - 1) {
                    curr = curr.getNext();
                    i++;
                }
                toDelete = curr.getNext();
                curr.setNext(curr.getNext().getNext());
            }
            this.length -= 1;
        }
        return toDelete;
    }

    /**
     * Добавляем новое значение в список по индексу
     *
     * @param value добавляемое значение
     * @param index индекс, куда хотим добавить
     */
    public void add(T value, int index) {
        if (index > -1) {
            if (index > size()) {
                add(value);
            } else {
                MyNode<T> node = new MyNode<>(value);
                if (index == 0) {
                    node.setNext(this.head);
                    this.head = node;
                } else {
                    MyNode<T> curr = this.head;
                    int i = 0;
                    while (i < index - 1) {
                        curr = curr.getNext();
                        i++;
                    }
                    node.setNext(curr.getNext());
                    curr.setNext(node);
                }
            }
            this.length += 1;
        }
    }

    /**
     * Служебный метод на проверку выхода за диапазон
     *
     * @param index проверяемый на корректность индекс
     * @return true, если выходит за пределы (меньше нуля или больше  размера списка или равен ему
     */
    public boolean isOutOfRange(int index) {
        return (index < 0 || index >= size());
    }

    public MyLinkedList<T> merge(MyLinkedList<T> otherList) {
        MyLinkedList<T> newList = new MyLinkedList<>();
        int newLength = this.size()+otherList.size();
        while (otherList.size() > 0 || this.size() > 0) {
            if (otherList.size() > 0 && this.size() > 0) {
                if (this.get(0).compareTo(otherList.get(0)) > 0) {
                    newList.add(otherList.remove(0).getValue());
                } else newList.add(this.remove(0).getValue());
            } else if (this.size()!=0){
                newList.add(this.remove(0).getValue());
            } else if (otherList.size()!=0){
                newList.add(otherList.remove(0).getValue());
            }
        }
        newList.setLength(newLength);
        return newList;
    }


    public static void main(String[] args) {
        MyLinkedList<Integer> firstList = new MyLinkedList<>();
        MyLinkedList<Integer> secondList = new MyLinkedList<>();
        firstList.add(1);
        firstList.add(5);
        firstList.add(10);
        firstList.add(50);
        firstList.add(120);
        secondList.add(2);
        secondList.add(9);
        secondList.add(60);
        secondList.add(130);
        MyLinkedList<Integer> newList = firstList.merge(secondList);
        for(int i=0; i<newList.size();i++){
            System.out.println(newList.get(i));
        }
    }

}
