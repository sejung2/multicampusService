package algorithm.d_datastructure.queue;

import algorithm.d_datastructure.list.Node;

public class _Queue<E> {

    private Node<E> top;
    private int size;
    private Node<E> lastNode = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) { // must to do : 속도 향상 시키기
        Node<E> newNode = new Node<>();
        if (size == 0) {
            top = newNode;
            lastNode = newNode;
            size++;
            newNode.data(e);
            return;
        }

        lastNode.next(newNode);
        lastNode = newNode;
        newNode.data(e);
        size++;
    }

    public E dequeue() {
        if(top == null) return null;
        E res = top.data();
        top = top.next();
        size--;
        if (top == null) {
            lastNode = null; // 큐가 비어있을 때 lastNode도 null로 설정
        }
        return res;
    }

    @Override
    public String toString() {
        Node<E> link = top;
        if(link == null) return "[]";

        StringBuffer sb = new StringBuffer();
        sb.append("[");

        while(link != null) {
            sb.append(link.data()).append(", ");
            link = link.next();
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }
}
