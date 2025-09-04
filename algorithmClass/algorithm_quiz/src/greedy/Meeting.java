package greedy;

public class Meeting {
    private String name;
    private int startAt;
    private int endAt;

    public String getName() {
        return name;
    }

    public int getStartAt() {
        return startAt;
    }

    public int getEndAt() {
        return endAt;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "name='" + name + '\'' +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                '}';
    }


}

