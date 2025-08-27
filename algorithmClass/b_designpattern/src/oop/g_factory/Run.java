package oop.g_factory;

public class Run {

    public static void main(String[] args) {
        SMTPConnector connector = ConnectorFatory.create(EmailConfig.NAVER);
        connector.connect();
    }
}
