package algorithm.d_datastructure.list;

import java.util.Iterator;

public class _LinkedListPrac<E> implements Iterable<E> {
    // 연습용으로 직접 작성해본 링크드 리스트
    // 링크드 리스트는 어떤 것이 필요할까?
    // 기본적인 기능 : add, get, remove, update, size, isEmpty
    // 데이터를 저장할 변수

    private Node<E> head; // 첫 번째 노드를 가리키는 변수
    private int size; // 현재 노드의 개수

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
            size++;
            return true;
        }
        Node<E> link = head;
        while (link.next() != null) {
            link = link.next();
        }
        link.next(newNode);
        size++;
        return true;
    }

    public E get(int index) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Node<E> link = head;
        for (int i = 0; i < index; i++) {
            link = link.next();
        }
        return link.data();
    }

    public E set(int index, E element) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Node<E> link = head;
        for (int i = 0; i < index; i++) {
            link = link.next();
        }
        E removed = link.data();
        link.data(element);
        return removed;
    }

    public E remove(int index) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Node<E> link = head;
        Node<E> prev = null;
        for (int i = 0; i < index; i++) {
            prev = link;
            link = link.next();
        }
        E removed = link.data();
        size--;
        prev.next(link.next());
        return removed;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current.next() != null;
            }

            @Override
            public E next() {
                E res = current.data();
                current = current.next();
                return res;
            }
        };
    }
}
