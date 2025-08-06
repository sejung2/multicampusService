package game_project.info;

public class AppInfo {
    // 제목
    private String title = "seing Game";
    // 제작자
    private String developer = "seing";
    // 내용
    private String content = "가위 바위 보, 숫자 맞추기 게임";

    @Override
    public String toString() {
        return "제목: " + title + "\n" +
                "-----------------------------\n" +
                "제작자: " + developer + "\n" +
                "내용 : " + content + "\n" +
                "********************************" + "\n";
    }
}
