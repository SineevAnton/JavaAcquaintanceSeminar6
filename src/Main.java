import Queue.*;

public class Main {
    public static void main(String[] args) {
        // Задача 2. Работа с очередью

        Queue myQueue = new Queue(5);

        myQueue.printQueue();

        myQueue.insert(10);
        myQueue.insert(20);
        myQueue.insert(30);
        myQueue.insert(40);
        myQueue.insert(50);

        myQueue.remove();
        myQueue.remove();
        myQueue.remove();

        myQueue.insert(60);

        myQueue.printQueue();
        myQueue.printQueue();
    }
}