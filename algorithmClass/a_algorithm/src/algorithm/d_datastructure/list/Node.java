package algorithm.d_datastructure.list;

public class Node<E> {

    private Node<E> next;
    private E data;

    public Node() {}

    public Node(E data) {
        this.data = data;
    }

    public Node<E> next() {
        return next;
    }

    public void next(Node<E> next) {
        this.next = next;
    }

    public void data(E data) {
        this.data = data;
    }

    public  E data() {
        return this.data;
    }

    // iterator

    // contains

    // indexOf

    @Override
    public String toString() {
        return data.toString();
    }
}
