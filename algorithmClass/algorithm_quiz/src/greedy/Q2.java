package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        // Greedy Quiz
        //한 개의 회의실이 있다.
        //이를 사용하고자 하는 N개의 회의들에 대하여
        //회의실 사용표를 만들려고 한다.
        //각 회의 I에 대해 시작 시간과 끝나는 시간이 주어져 있고,
        //각 회의가 겹치지 않게 하면서
        //회의실을 사용할 수 있는 최대수의 회의를 찾아라.
        //단, 회의는 한번 시작하면 중간에 중단될 수 없으며
        //회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
        //회의 정보가 다음과 같이 입력될 때,
        //[
        //{'idx':1,  'start':1,  'end':10}
        //,{'idx':2,  'start':5,  'end':6}
        //,{'idx':3,  'start':13, 'end':15}
        //,{'idx':4,  'start':14, 'end':17}
        //,{'idx':5,  'start':8,   'end':14}
        //,{'idx':6,  'start':3,   'end':12}
        //]
        //2번 회의 - 5번 회의 - 4번 회의

        // 회의 정보를 담는 2차원 배열
        int[][] meetings = {{1, 1, 10}, {2, 5, 6}, {3, 13, 15}, {4, 14, 17}, {5, 8, 14}, {6, 3, 12}};
        q2(meetings);
    }

    private static void q2(int[][] meetings) {
        // 잘 모르겠습니다.
//        ArrayList<Integer> meet = new ArrayList<>();
//        for (int i = 0; i < meetings.length; i++) {
//            if (meetings[i][1] >= meetings[i + 1][2]) {
//
//            }
//        }
    }
}
