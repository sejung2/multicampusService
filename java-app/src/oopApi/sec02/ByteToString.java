package oopApi.sec02;

public class ByteToString {
    public static void main(String[] args) {
        byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97}; // "Hello Java" in ASCII values

        String str = new String(bytes); // Convert byte array to String
        System.out.println("Converted String: " + str); // Output: Hello Java
    }
}
