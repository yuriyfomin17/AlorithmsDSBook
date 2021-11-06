package Chapter1Section1.ChapterExercises;

public class Exe1118 {
    public static void main(String[] args) {
    }

    // a, b - 2, 25 => 50; a,b - 3, 11 => 33
    // given pos integers exe1118 multiplies a * b
    // mystery two computes A^B
    public static int exe1118(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return exe1118(a + a, b / 2);
        return exe1118(a + a, b / 2) + a;
    }
}
