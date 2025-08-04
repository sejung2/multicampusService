package oopException.sec01;

public class NullPointerExceptionEx {
    public static void main(String[] args) {
        String data = null;
        int[] arr = {1, 2, 3};
        String data1 = "100";
        String data2 = "a100";
        System.out.println(data.toString());
        System.out.println(arr[5]);

        int value1 = Integer.parseInt(data1);
        int value2 = Integer.parseInt(data2); // 이 줄에서 NumberFormatException 발생 가능

        System.out.println(value1 + value2);

    }
}
