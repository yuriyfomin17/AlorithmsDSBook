package Chapter1.ChapterExercises;

public class Exe111 {
    public static void main(String[] args) {
        exe111();
    }

    static public void exe111() { // ✅ checked
        System.out.println((0 + 15) / 2); // a 7 since converts it to int which truncates values
        System.out.println((2e-6 * 100000000.1)); // b 200.0000002 float
        System.out.println(true && false || true && true); // c true boolean
    }
}
