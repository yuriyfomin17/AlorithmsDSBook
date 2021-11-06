package Chapter1Section1.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe1119Fibonacci {
    public static void main(String[] args) {
    }

    public static void exe1119() { // ✅ checked
        // largest n for which it takes less then hour to compute fibonacci is 49
        // enhanced with memoization
        class Fibonacci {
            public static long F(int N, long[] info) {
                if (N == 0) return 0;
                if (N == 1) return 1;
                if (info[N-1] != 0) return info[N-1];
                long result =  F(N - 1, info) + F(N - 2, info);
                info[N-1] = result;
                return result;
            }
        }
        for (int N = 0; N < 100; N++){
            long result = Fibonacci.F(N, new long[N]);
            StdOut.println(N + " " + result);
        }

    }
}
