package Chapter1Section1.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe117 {
    public static void main(String[] args) {
        exe117();
    }

    static public void exe117() { //  ✅ checked
        //  Newtonian method to find square root of number => 3.00009
        double sqrtNum = 9.0;
        double c = sqrtNum;
        while (Math.abs(sqrtNum - c / sqrtNum) > 0.001) {
            sqrtNum = (sqrtNum + c / sqrtNum) * 0.5;
        }
        StdOut.printf("%.5f\n", sqrtNum);

        // b
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum); // 499500

        int N = 10;
        int sum2 = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < N; j++)
                sum2++;
        StdOut.println(sum2); // 100
    }
}
