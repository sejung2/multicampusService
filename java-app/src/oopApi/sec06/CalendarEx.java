package oopApi.sec06;

import java.time.LocalDateTime;
import java.util.Calendar;

public class CalendarEx {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR); // 현재 연도
        int month = now.get(Calendar.MONTH) + 1; // 현재 월 (0부터 시작하므로 +1)
        int date = now.get(Calendar.DATE); // 현재 일
        int day = now.get(Calendar.DAY_OF_MONTH); // 현재 일 (1부터 시작)
        int week = now.get(Calendar.DAY_OF_WEEK); // 현재 요일 (1: 일

        String strWeek = null;

        switch (week) {
            case Calendar.MONDAY:
                strWeek = "월";
                break;
            case Calendar.TUESDAY:
                strWeek = "화";
                break;
            case Calendar.WEDNESDAY:
                strWeek = "수";
                break;
            case Calendar.THURSDAY:
                strWeek = "목";
                break;
            case Calendar.FRIDAY:
                strWeek = "금";
                break;
            case Calendar.SATURDAY:
                strWeek = "토";
                break;
            case Calendar.SUNDAY:
                strWeek = "일";
                break;
            default:
                strWeek = "알 수 없음";
        }

        int amPm = now.get(Calendar.AM_PM); // 오전/오후 (0: AM, 1: PM)
        String strAmPm = (amPm == Calendar.AM) ? "오전" : "오후";

        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE); // 현재 분
        int second = now.get(Calendar.SECOND); // 현재 초

        System.out.println(year + "년 ");
        System.out.println(month + "월 ");
        System.out.println(date + "일 ");
        System.out.println(strWeek + "요일 ");
        System.out.println(strAmPm + " ");
        System.out.println(hour + "시 ");
        System.out.println(minute + "분 ");
        System.out.println(second + "초 ");

        LocalDateTime n = LocalDateTime.now();
        System.out.println(n.getYear() + "년 " + n.getMonthValue() + "월 " + n.getDayOfMonth() + "일 ");
        System.out.println("내일은 " + n.plusDays(1) + "일 입니다.");
        System.out.println("한 시간 이전 시간은 " + n.minusHours(1) + "시 입니다.");
        System.out.println("일주일 후는 " + n.plusWeeks(1) + "입니다.");
        System.out.println("올해는 " + n.getDayOfYear() + "일 지나갑니다");
    }
}
