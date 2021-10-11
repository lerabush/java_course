/**
 * Класс узла списка
 */
public class MyNode<T extends Comparable<T>>  {

    private T value;
    private MyNode<T> next;

    /**
     * новый узел, пока присваиваем ему значение - идет в конец либо потом прикрепляем потомка
     * @param value
     */
    MyNode(T value){
        this.value = value;
        this.next = null;
    }

    /**
     * дефолтный конструктор
     */


    /**
     * Getter
     * @return значение узла списка
     */
    public T getValue(){
        return this.value;
    }

    /**
     * Setter
     * @param val значение, на которое хотим поменять значение списка
     *
     */
    public void setValue(T val){
        this.value = val;
    }

    /**
     * Getter
     * @return следующий узел списка
     */
    public MyNode<T> getNext(){
        return this.next;
    }

    /**Setter
     * Добавляем или изменяем ссылку на новый узел
     * @param nextNode ссылка на узел, который хотим сделать следующим
     */
    public void setNext(MyNode<T> nextNode){
        this.next = nextNode;
    }

    /**
     * override toString
     * @return string with node value
     */
    @Override
    public String toString(){
        return "[ "+"value: "+this.value+" ]";
    }

    public int compareTo(MyNode<T> tMyNode) {
        return this.getValue().compareTo(tMyNode.getValue());
    }
}
