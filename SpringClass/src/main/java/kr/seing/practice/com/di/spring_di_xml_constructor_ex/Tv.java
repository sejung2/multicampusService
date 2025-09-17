package kr.seing.practice.com.di.spring_di_xml_contructor_ex;

public class Tv {

    Speaker speaker;

    public Tv(Speaker speaker) {
        this.speaker = speaker;
    }

    public void volumeUp(){
        speaker.volumeUp();
    };

    public void volumeDown(){
        speaker.volumeDown();
    };
}
