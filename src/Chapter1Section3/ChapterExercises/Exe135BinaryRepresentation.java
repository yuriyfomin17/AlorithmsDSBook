package Chapter1Section3.ChapterExercises;

public class Exe135BinaryRepresentation {
    public static void main(String[] args) {
        int num = 50;
        String binaryString = "";
        for (int i = num; i > 0 ; i /= 2) {
            if (i % 2 != 0) binaryString = "1" + binaryString;
            else binaryString = "0" + binaryString;
        }
        System.out.println(binaryString);
    }


}
