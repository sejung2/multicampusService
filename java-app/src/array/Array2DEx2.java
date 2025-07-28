package array;

import java.util.Scanner;

public class Array2DEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] quiz = {{"chair", "의자"}, {"computer", "컴퓨터"}, {"integer", "정수"}};

        for (int i = 0; i < quiz.length; i++) {
            System.out.print("Q" + (i + 1) + ". " + quiz[i][0] + "의 뜻은?: ");
            String answer = sc.nextLine();
            if (answer.equals(quiz[i][1])) {
                System.out.println("정답입니다.");
            } else {
                System.out.println("틀렸습니다. 정답은 " + quiz[i][1] + "입니다.");
            }
        }
        sc.close();
    }
}
