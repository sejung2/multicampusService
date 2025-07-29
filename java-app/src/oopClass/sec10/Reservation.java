package oopClass.sec10;

public class Reservation {

    private String airline; // 항공기
    private String name; // 예약자
    private String from; // 출발지
    private String to; // 도착지
    private int price; // 금액
    private String seatNumber; // 좌석 번호

    public Reservation() {
        this.airline = "";
        this.name = "";
        this.from = "";
        this.to = "";
        this.price = 0;
        this.seatNumber = "";
    }

    public Reservation(String airline, String name, String from, String to, int price, String seatNumber) {
        this.airline = airline;
        this.name = name;
        this.from = from;
        this.to = to;
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public void showRsvInfo() {
        System.out.println("**항공권 예약 정보**");
        System.out.println("항공기 : " + airline);
        System.out.println("예약자 : " + name);
        System.out.println("출발지 : " + from);
        System.out.println("도착지 : " + to);
        System.out.println("금액 : " + price);
        System.out.println("좌석번호 : " + seatNumber);
    }

}
