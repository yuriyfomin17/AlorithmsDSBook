package Chapter1Section1.ChapterExercises;

public class Exe1116 {
    public static void main(String[] args) {
    }

    public static String exe1116(int n) { // ✅ checked -> 311361142246
        if (n <= 0) {
            return "";
        }
        return exe1116(n - 3) + n + exe1116(n - 2) + n;
    }
}
