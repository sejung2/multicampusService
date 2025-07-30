package oopClass.sec17;

public class Car {
    private int speed;
    private boolean stop;

    public void setSpeed(int speed) {
        this.speed = Math.max(speed, 0);
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if (stop) this.speed = 0;
    }
}
