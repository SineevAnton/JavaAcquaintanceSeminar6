import Queue.*;
import BinaryTree.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Работа с бинарным деревом.");
        // Задача 1. Работа с бинарным деревом

        Tree tree = new Tree();
        tree.insertNode(6);
        tree.insertNode(8);
        tree.insertNode(5);
        tree.insertNode(8);
        tree.insertNode(2);
        tree.insertNode(9);
        tree.insertNode(7);
        tree.insertNode(4);
        tree.insertNode(10);
        tree.insertNode(3);
        tree.insertNode(1);
        tree.printTree();

        // удаляем один узел и выводим оставшееся дерево в консоли
        tree.deleteNode(5);
        tree.printTree();

        // находим узел по значению и выводим его в консоли
        Node foundNode = tree.findNodeByValue(7);
        foundNode.printNode();

        System.out.println("\nЦентрированный обход");
        tree.iterativeInorder(tree.getRootNode());

        System.out.println("\nПрямой обход");
        tree.iterativePreorder(tree.getRootNode());

        System.out.println("\nОбратный обход");
        tree.iterativePostorder(tree.getRootNode());


        System.out.println("\n\n\nЗадача два. Работа с очередью.");
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