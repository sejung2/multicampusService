package oop.g_factory;

public class DaumMail implements SMTPConnector {

    private EmailConfig config;

    public DaumMail(EmailConfig config) {
        this.config = config;
    }

    @Override
    public void connect() {
        System.out.println(config.url);
        System.out.println("다음 메일서버에 연결되었습니다");
    }
}
