package algorithm.d_datastructure.set;

import algorithm.d_datastructure.dto.School;

import java.util.HashSet;

public class Run {
    public static void main(String[] args) {
        School seoulUniv = new School("서울대", "관악구", "대학교");
        School yeonsaeUniv = new School("연세대", "서울", "대학교");
        School minsa = new School("민사고", "대전", "고등학교");
        School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");
        _HashSet_P2<School> set = new _HashSet_P2<School>();
        set.add(seoulUniv);
        set.add(yeonsaeUniv);
        set.add(minsa);
        set.add(multicampus);

        //System.out.println(set);
        //set.remove(new School("서울대", "관악구", "대학교"));
        //System.out.println(set);
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
