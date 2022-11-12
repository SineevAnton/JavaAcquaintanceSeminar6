package BinaryTree;

import java.util.Stack;

public class Tree {
    private Node rootNode; // корневой узел

    public Tree() { // Пустое дерево
        rootNode = null;
    }

    public Node getRootNode() {
        return this.rootNode;
    }

    /**
     * Method to find node, using it's value
     * @param value to find node
     * @return found node or null, if node wasn,t found
     */
    public Node findNodeByValue(int value) {
        Node currentNode = rootNode;
        while(currentNode.getValue() != value) {
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    /**
     * Method for find place and insert new node by value
     * @param value of node to insert
     */
    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node currentNode = rootNode;
            Node parentNode;
            while(true) {
                parentNode = currentNode;
                if (value == currentNode.getValue()) {
                    return;
                } else if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }

    }

    public boolean deleteNode(int value)
    {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;
        while (currentNode.getValue() != value) {
            parentNode = currentNode;
            if (value < currentNode.getValue()) {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            }
            else {
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null)
                return false;
        }

        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (currentNode == rootNode)
                rootNode = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null);
            else
                parentNode.setRightChild(null);
        }
        else if (currentNode.getRightChild() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getLeftChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getLeftChild());
            else
                parentNode.setRightChild(currentNode.getLeftChild());
        }
        else if (currentNode.getLeftChild() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getRightChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getRightChild());
            else
                parentNode.setRightChild(currentNode.getRightChild());
        }
        else {
            Node heir = receiveHeir(currentNode);
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)
                parentNode.setLeftChild(heir);
            else
                parentNode.setRightChild(heir);
        }
        return true;
    }

    /**
     * Метод возвращает узел со следующим значением после передаваемого аргументом.
     * @param node
     * @return
     */
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild();
        while (currentNode != null)
        {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }

        if (heirNode != node.getRightChild())
        {
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;
    }

    /**
     * Метод для вывода дерева в консоль
     */
    public void printTree() {
        Stack globalStack = new Stack();
        globalStack.push(rootNode);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }

    /**
     * Центрированный обход
     * @param node
     */
    public void iterativeInorder(Node node){
        Stack<Node> stack = new Stack();
        //s ← empty stack
        while (!stack.isEmpty() || node != null)
        {
            if (node != null)
            {
                stack.push(node);
                node = node.getLeftChild();
                //node ← node.left
            } else {
                node = stack.pop();
                //node ← s.pop()
                System.out.println(node.toString());
                //visit(node)
                node = node.getRightChild();
                //node ← node.right
            }

        }

    }

    /**
     * Функция прямого обхода
     * @param node
     */
    public void iterativePreorder(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.toString());
            if (node.getRightChild() != null) stack.push(node.getRightChild());
            if (node.getLeftChild() != null) stack.push(node.getLeftChild());
        }

    }

    /**
     * Функция обратного обхода
     * @param node
     */
    public void iterativePostorder(Node node) {
        Stack<Node> stack = new Stack();
        Node lastNodeVisited = null;
        while (!stack.isEmpty() || node != null)
        {
            if (node != null) {
                stack.push(node);
                node = node.getLeftChild();
            } else {
                Node peekNode = stack.peek();
                // если правый потомок существует и обход пришёл из левого потомка, двигаемся вправо
                if (peekNode.getRightChild() != null && lastNodeVisited != peekNode.getRightChild()) {
                    node = peekNode.getRightChild();
                } else {
                    System.out.println(peekNode.toString());
                    lastNodeVisited = stack.pop();
                }
            }
        }
    }
}
