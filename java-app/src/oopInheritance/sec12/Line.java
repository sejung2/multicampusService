package oopInheritance.sec12;

public class Line extends DrawingObject {
    public Line(){
        penColor = "red";
    }

    @Override
    public void draw() {
        System.out.println(penColor + "색상으로 선 그리기");
    }
}
