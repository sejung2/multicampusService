package oopClass.sec10;

public class ReservationEx {
    public static void main(String[] args) {
        Reservation rs = new Reservation();
        Reservation myRs = new Reservation("KE1001", "James", "김포", "런던", 2000000, "A17");
        rs.showRsvInfo();
        myRs.showRsvInfo();
    }
}
