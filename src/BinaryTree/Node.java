package BinaryTree;

public class Node {
    private int value; // ключ узла
    private Node leftChild, rightChild; // левый и правый потомки

    /**
     * Method for print node's value
     */
    public void printNode() {
        System.out.println("Current node value is: " + value);
    }

    /**
     * Value getter
     * @return
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Value setter
     * @param value
     */
    public void setValue(final int value) {
        this.value = value;
    }

    /**
     * Left child getter
     * @return
     */
    public Node getLeftChild() {
        return this.leftChild;
    }

    /**
     * Right child getter
     */
    public Node getRightChild() {
        return this.rightChild;
    }

    /**
     * Left child setter
     * @param leftChild
     */
    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Right child setter
     * @param rightChild
     */
    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
