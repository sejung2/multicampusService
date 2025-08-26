package algorithm.d_datastructure.set;

import algorithm.d_datastructure.list.Node;

import java.util.Arrays;

public class _HashSet_Practice<E> {

    private Object[] table; // 해시 테이블
    private int arraySize = 6; // 초기 배열 크기
    private int size = 0; // 현재 크기

    public _HashSet_Practice() {
        this.table = new Object[arraySize];
    }

    public _HashSet_Practice(int initialCapacity) {
        this.table = new Object[initialCapacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public int hash(E e) {
        int index = Math.abs(e.hashCode()); // 해시 테이블에 적용할 인덱스 계산
        return index % arraySize; // 해시 함수
    }

    public boolean add(E e) {
        if (size == arraySize) { // 배열이 가득 찼다면 크기를 늘림
            resize();
        }
        if (!addNode(e)) return false; // 노드를 추가하고 성공 여부 반환
        size++;
        return true;
    }

    private void resize() {
        Object[] temp = Arrays.copyOf(table, arraySize);
        arraySize = arraySize * 2;
        table = new Object[arraySize];
        for (Object o : temp) {
            if (o == null) continue;
            Node<E> node = (Node<E>) o; // 기존 노드를 가져옴
            while(node != null) {
                addNode(node.data()); // 새 해시 테이블에 노드 추가
                node = node.next(); // 다음 노드로 이동
            }
        }
    }

    private boolean addNode(E e) {
        int index = hash(e); // 해시 값을 계산하여 인덱스 찾기
        Node<E> node = new Node<>(e); // 넣을 노드 생성
        Node<E> head = (Node<E>) table[index]; // 해당 인덱스의 노드 가져오기
        if (head == null) {
            table[index] = node;
            return true;
        }

        Node<E> link = head;
        while(link.next() != null) {
            if (link.data().equals(e)) return false;
            link = link.next();
        }
        if (link.data().equals(e)) return false;
        link.next(node);
        return true;
    }

    public boolean remove(E e) {
        int index = hash(e);
        Node<E> head = (Node<E>) table[index];
        if (head == null) return false;
        if (head.data().equals(e)) {
            table[index] = null;
            size--;
            return true;
        }
        Node<E> prev = head;
        Node<E> link = head.next();
        while (link.next() != null) {
            if (link.data().equals(e)) {
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
