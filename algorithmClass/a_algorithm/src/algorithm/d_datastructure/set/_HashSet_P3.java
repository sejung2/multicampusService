package algorithm.d_datastructure.set;

import algorithm.d_datastructure.list.Node;
import algorithm.d_datastructure.list._LinkedList;

import java.util.Arrays;
import java.util.Iterator;

// _LinkedList를 사용해서 HashSet 구현
@SuppressWarnings("unchecked")
public class _HashSet_P3<E> implements Iterable<E> {

    private Object[] table; // 해시 테이블
    private int arraySize = 6; // 최대 배열 크기
    private int size = 0; // 현재 크기

    public _HashSet_P3() {
        this.table = new Object[arraySize];
    }

    public _HashSet_P3(int initialCapacity) {
        this.table = new Object[initialCapacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    private int hash(Object e) {
        int hashCode = Math.abs(e.hashCode());
        return hashCode % arraySize;
    }

    public boolean add(E e) {
        if (size == arraySize - 1) {
            resize();
        }
        if (!addNode(e)) return false;
        size++;
        return true;
    }

    private boolean addNode(E e) {
        int index = hash(e);
        _LinkedList<E> row = (_LinkedList<E>) table[index];

        if (row == null) {
            _LinkedList<E> newRow = new _LinkedList<>();
            newRow.add(e);
            table[index] = newRow;
            return true;
        }

        if (row.contains(e)) return false;
        row.add(e);
        return true;
    }

    private void resize() {
        Object[] temp = Arrays.copyOf(table, arraySize);
        arraySize *= 2;
        table = new Object[arraySize];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) continue;
            _LinkedList<E> row = (_LinkedList<E>) temp[i];

            for (E e : row) {
                addNode(e);
            }
        }
    }

    public boolean remove(E data) {
        int index = hash(data);
        _LinkedList<E> row = (_LinkedList<E>) table[index];
        if (row == null) return false;
        if(!row.contains(data)) return false;
        row.remove(row.indexOf(data));
        size--;
        if(row.isEmpty()) table[index] = null; // 만약 해당 row가 비어있다면 null로 설정
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            _LinkedList<E> row = (_LinkedList<E>) table[i];
            for (E e : row) {
                sb.append(e).append(", ");
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {

            private int cnt = 0;
            private int rowPointer = -1;
            private _LinkedList<E> row = new _LinkedList<E>(); // 복습 포인트, 기본적인 형태의 캐싱?
            private Iterator<E> rowIterator = row.iterator(); // 현재 탐색 중인 row의 iterator

            @Override
            public boolean hasNext() {
                return cnt < size;
            }

            @Override
            public E next() {
                if (rowIterator.hasNext()) {
                    cnt++;
                    return rowIterator.next();
                }

                do {
                    rowPointer++;
                } while(table[rowPointer] == null);

                row = (_LinkedList<E>) table[rowPointer];
                rowIterator = row.iterator();
                cnt++;
                return rowIterator.next();
            }
        };
    }

//    public _HashSet_P3() { // 기본 생성자
//        this.table = new Object[arraySize];
//    }
//
//    public _HashSet_P3(int initialCapacity) { // 초기 사이즈가 있는 생성자
//        this.table = new Object[initialCapacity];
//    }
//
//    public boolean isEmpty() { // 해시 테이블이 비어있는지 확인
//        return size == 0;
//    }
//
//    public int size() { // 현재 해시 테이블의 크기를 반환
//        return this.size;
//    }
//
//    private int hash(E e) { // 해시 함수를 사용하여 인덱스를 계산
//        int hashCode = Math.abs(e.hashCode());
//        return hashCode % arraySize;
//    }
//
//    public boolean add(E e) { // 해시 테이블에 요소를 추가
//        if (size == arraySize - 1) {
//            resize();
//        }
//        if (!addList(e)) return false;
//        size++;
//        return true;
//    }
//
//    private boolean addList(E e) { // 해시 테이블에 linkedList를 추가하는 내부 메소드
//        int index = hash(e);
//        _LinkedList<E> list = (_LinkedList<E>) table[index];
//        if (list == null) {
//            list = new _LinkedList<>();
//            list.add(e);
//            table[index] = list;
//            return true;
//        }
//        // 이미 존재한다면
//        if (list.contains(e)) return false; // 중복된 요소가 있으면 추가하지 않음
//        list.add(e); // 중복되지 않으면 추가
//        return true;
//    }
//
//    private void resize() {
//        Object[] temp = Arrays.copyOf(table, arraySize);
//        arraySize *= 2;
//        table = new Object[arraySize];
//        for (Object o : temp) {
//            if (o == null) continue;
//            _LinkedList<E> link = (_LinkedList<E>) o;
//            for (E item : link) {
//                addList(item); // 기존의 노드들을 새로 해시 테이블에 추가
//            }
//        }
//    }
//
//    public boolean remove(E e) {
//        int index = hash(e); // 지울 요소의 인덱스를 계산
//        _LinkedList<E> list = (_LinkedList<E>) table[index]; // 지울 요소가 존재하는 리스트를 가져옴 (지울 요소가 없을 경우 null)
//
//        if (list == null) return false; // 리스트가 null이면 요소가 존재하지 않음
//        int i = list.indexOf(e);// 리스트에서 요소의 인덱스를 찾음
//        if (i == -1) return false; // 요소가 리스트에 없으면 false 반환
//        list.remove(i); // 해당 인덱스의 요소를 제거
//        if (list.isEmpty()) { // 리스트가 비어있으면 해당 인덱스를 null로 설정 *
//            table[index] = null;
//        }
//        size--; // 해시 테이블의 크기를 감소
//        return true; // 요소 제거 성공
//    }
//
//    @Override
//    public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append("[");
//
//        for (int i = 0; i < table.length; i++) {
//            if (table[i] == null) continue;
//            _LinkedList<E> list = (_LinkedList<E>) table[i];
//            for (E e : list) {
//                sb.append(e);
//                sb.append(", ");
//            }
//        }
//        sb.deleteCharAt(sb.lastIndexOf(","));
//        sb.append("]");
//        return sb.toString();
//    }
//
//    @Override
//    public Iterator<E> iterator() {
//        return new Iterator<E>() {
//
//            private int rowPointer = -1; // 현재 탐색 중인 테이블의 인덱스
//            private _LinkedList<E> currentList = null; // 현재 탐색 중인 리스트
//
//            @Override
//            public boolean hasNext() {
//                return rowPointer < size - 1; // 현재 인덱스가 테이블의 크기보다 작으면 다음 요소가 있음
//            }
//
//            @Override
//            public E next() {
//                if (currentList != null) {
//                    return currentList.iterator().next();
//                }
//
//                do {
//                    rowPointer++;
//                } while (table[rowPointer] == null);
//                currentList = (_LinkedList<E>) table[rowPointer];
//                return currentList.iterator().next();
//            }
//        };
//    }
}
