package algorithm.d_datastructure.set;

import algorithm.d_datastructure.list.Node;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class _HashSet_Practice<E> {
    Object[] table;
    int arraySize = 10;
    int size;

    public _HashSet_Practice() {
        table = new Object[arraySize];
    }

    public _HashSet_Practice(int initialCapacity) {
        table = new Object[initialCapacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int hash(E e) {
        return e.hashCode() & arraySize;
    }

    public boolean add(E e) {
        if (size == arraySize - 1) {
            resize();
        }
        if(!addNode(e)) return false;
        size++;
        return true;
    }

    private boolean addNode(E e) {
        int index = hash(e);
        Node<E> newNode = new Node<>(e);
        Node<E> current = (Node<E>) table[index];
        if (current == null) {
            table[index] = newNode;
            return true;
        }

        Node<E> link = current;
        while (link.next() != null) {
            if (link.data().equals(e)) return false;
            link = link.next();
        }
        if (link.data().equals(e)) return false;
        link.data(e);
        return true;
    }

    private void resize() {
        Object[] temp = Arrays.copyOf(table, arraySize);
        arraySize *= 2;
        table = new Object[arraySize];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) continue;
            Node<E> current = (Node<E>) temp[i];

            while (current != null) {
                add(current.data());
                current = current.next();
            }
        }
    }

    public boolean remove(E data) {
        int index = hash(data);
        Node<E> head = (Node<E>) table[index];
        if (head == null) return false;
        if (head.data().equals(data)) {
            table[index] = null;
            size--;
            return true;
        }

        Node<E> link = head.next();
        Node<E> prev = head;

        while (link != null) {
            if (link.data().equals(data)) {
                prev.next(link.next());
                size--;
                return true;
            }
            prev = link;
            link = link.next();
        }
        return false;
    }
}
