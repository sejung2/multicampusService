package oopClass.sec02;

public class Rectangle {
    private int width;
    private int height;

    public void setRectangleInfo(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void showRectangleInfo() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + (width * height));
    }
}
