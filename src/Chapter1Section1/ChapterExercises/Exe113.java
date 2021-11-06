package Chapter1Section1.ChapterExercises;

public class Exe113 {
    public static void main(String[] args) {
        exe113(args);
    }

    static public void exe113(String[] args) { // ✅ checked
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        if (num3 == num2 && num2 == num1) System.out.println("equal");
        else System.out.println("not equal");
    }
}
