package kr.seing.practice.com.spring_aop_xml2;

public class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 원의 면적
    public void area() {
        System.out.println("원의 면적: " + Math.PI * this.radius * this.radius);
    }
    // 원의 둘레
    public void round() {
        System.out.println("원의 둘레: " + 2 * Math.PI * this.radius);
    }
}
