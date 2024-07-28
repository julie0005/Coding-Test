package programmers.basic;

public class Jadentialize {
    public static void main(String[] args) {
        String test = "     ";
        String[] testArr = test.trim().split(" +");
        System.out.println(testArr.length);
        for (int i=0; i<testArr.length; i++) {
            System.out.println(testArr[i]);
            System.out.println(testArr[i].equals(""));
        }
    }
}
