package kr.seing.practice.com.spring_aop_xml2;

public class Evaluation {
    private int kor;
    private int eng;
    private int math;

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void total() {
        int total = this.kor + this.eng + this.math;
        System.out.println("총점: " + total);
    }

    public void average() {
        double avg = (this.kor + this.eng + this.math) / 3.0;
        System.out.println("평균: " + avg);
    }
}
