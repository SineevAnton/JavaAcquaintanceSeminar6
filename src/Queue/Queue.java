package Queue;

public class Queue {
    private int[] queue;
    private int maxSize, nElem, head, tail;

    /*
    maxSize - максимальный размер
    nElem - количество элементов в очереди
    head - индекс первого элемента
    tail - индекс последнего элемента
     */

    public Queue(int maxSize){
        this.maxSize = maxSize;
        queue = new int[maxSize];
        tail = -1;
        head = 0;
        nElem = 0;
    }

    /**
     * Метод вставки элемента в очередь (с использованием циклического переноса)
     * @param element значение элемента для вставки
     */
    public void insert(int element) {
        if (tail == maxSize - 1) tail = -1; // циклический перенос

        queue[++tail] = element;
        nElem ++;
    }

    /**
     * Метод удаления элемента из начала очереди (с использованием циклического переноса)
     * @return
     */
    public int remove() {
        int temp = queue[head++];
        if (head == maxSize) head = 0; // циклический перенос

        nElem --;
        return temp;
    }

    /**
     * Метод получения первого элемента очереди
     * @return
     */
    public int getHead() {
        return queue[head];
    }

    /**
     * Метод получения последнего элемента очереди
     * @return
     */
    public int getTail() {
        return queue[tail];
    }

    /**
     * Метод проверки очереди на переполнение
     * @return
     */
    public boolean isFull() {
        return (nElem == maxSize - 1);
    }

    /**
     * Метод проверки очереди на пустоту
     * @return
     */
    public boolean isEmpty() {
        return (nElem == 0);
    }

    /**
     * Метод получения количества элементов в очереди
     * @return
     */
    public int getSize() {
        return nElem;
    }

    /**
     * Метод вывода имеющейся очереди.
     * !Демонстрационный метод: при вызове существующая очередь очищается
     */
    public void printQueue(){
        if (this.isEmpty()) System.out.println("Очередь пуста!");
        else {
            while (!this.isEmpty()) {
                int n = this.remove();
                System.out.println("Elem: " + n);
            }
        }
    }
}
