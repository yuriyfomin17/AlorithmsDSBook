package Chapter1.ChapterExercises;

public class Exe119 {
    public static void main(String[] args) {
        exe119();
    }
    static public void exe119() { // ✅ checked -> implementation of toBinaryString method
        int num = 9;
        System.out.println(Integer.toBinaryString(num));

        String binaryNum = "";
        for (int i = num; i > 0; i /= 2) {
            binaryNum = (i % 2) + binaryNum;
        }
        System.out.println(binaryNum);
    }
}
