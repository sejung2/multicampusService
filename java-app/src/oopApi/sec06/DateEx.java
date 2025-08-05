package oopApi.sec06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
    public static void main(String[] args) {
        Date now = new Date(); // 객체 생성 - 현재 날짜와 시간 정보를 담는 Date 객체
        System.out.println(now.toString());
        System.out.println(now.toLocaleString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String strNow2 = sdf.format(now); // 현재 날짜와 시간을 지정된 형식으로 문자열로 변환
        System.out.println(strNow2);
    }
}
