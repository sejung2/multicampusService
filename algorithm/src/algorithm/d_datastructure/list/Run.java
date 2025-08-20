package algorithm.d_datastructure.list;

import algorithm.d_datastructure.dto.School;

import java.util.*;

public class Run {
    public static void main(String[] args) {
        System.out.println(init());
        //testGet();
        //testRemove();
        //testSet();
        testForEach();
        //testSort();
        testContains();
        testIndexOf();
    }

    private static void testIndexOf() {
        _LinkedList<Integer> list = init();
        System.out.println(list.indexOf(5));
    }

    private static void testContains() {
        _LinkedList<Integer> list = init();
        System.out.println(list.contains(11));
    }

    private static void testSort() {
        School seoulUniv = new School("서울대", "관악구", "대학교");
        School yeonsaeUniv = new School("연세대", "서울", "대학교");
        School minsa = new School("민사고", "대전", "고등학교");
        School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");

        ArrayList<School> schools = new ArrayList<>();
        schools.add(seoulUniv);
        schools.add(yeonsaeUniv);
        schools.add(minsa);
        schools.add(multicampus);

        // 레벨을 기준으로 오름차순, 대학이 같다면 이름으로 내림차순 정렬
        Collections.sort(schools);
        Collections.sort(schools, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(schools);
    }

    private static void testForEach() {
        // 제어반전 IOC
        _LinkedList<Integer> list = init();
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    private static void testSet() {
        _LinkedList<Integer> list = init();
        System.out.println(list.set(0, 10));
        System.out.println(list);
    }

    private static void testRemove() {
        _LinkedList<Integer> list = init();
        for (int i = 5; i < 8; i++) {
            list.remove(i);
        }
        System.out.println(list);
    }

    private static void testGet() {
        _LinkedList<Integer> list = init();
        for (int i = 5; i < 8; i++) {
            System.out.println(list.get(i));
        }
    }

    private static _LinkedList<Integer> init() {
        _LinkedList<Integer> list = new _LinkedList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        return list;
    }
}
