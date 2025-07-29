package array;

public class ArrayIregular {
    public static void main(String[] args) {
        // 가변형 배열
        int[][] arr = new int[3][]; // 3행의 가변형 배열 선언
        arr[0] = new int[1];
        arr[1] = new int[2];
        arr[2] = new int[3];
        arr[3] = new int[4]; // 4행의 가변형 배열 선언

        char b[][] = {
            {'a', 'b', 'c'},
            {'d', 'e'},
            {'f', 'g', 'h', 'i'}
        };

        String[][] student = {
            {"홍길동", "서울"},
            {"김영희", "부산"},
            {"이철수", "대구"}
        };

        System.out.println(student[0][1]);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
