package kr.seing.practice.sec02;

public class Rect {

    private int width;
    private int height;

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    // 핵심기능 : 사각형의 넓이을 구해서 출력
    public void showRectResult() {
        System.out.println("넓이 : " +  (width * height));
        System.out.println("둘레 : " +  (2*(width + height)));
    }
}
