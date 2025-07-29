package array;

import java.util.*;

public class ArrayExer3 {
    public static void main(String[] args) {
        int[] lottoNum = new int[6]; // 로또 번호를 저장할 배열 생성
        int[] checkNum = new int[45]; // 1부터 45까지의 번호를 체크할 배열 생성

        for (int i = 0; i < lottoNum.length; i++) {
            int inputNum = (int)(Math.random() * 45) + 1; // 1부터 45까지의 난수 생성
            if(checkNum[inputNum - 1] == 0) { // 해당 번호가 아직 선택되지 않았다면
                lottoNum[i] = inputNum;
                checkNum[inputNum - 1] = 1; //배열에 해당 번호를 선택했음을 표시
            } else {
                i--; // 이미 선택된 번호라면 다시 시도
            }
        }
        // 로또 번호 출력
        System.out.println("로또 번호: " + Arrays.toString(lottoNum));
    }
}
