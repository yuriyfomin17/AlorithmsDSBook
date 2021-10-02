package Chapter1.CreativeProblems;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exe1127BinomialDist {
    static int count = 0;
    static double[][] result = new double[101][51];
    public static void main(String[] args) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = -1;
            }
        }
        System.out.println(binomial(10, 6, 0.5));
        System.out.println(count);

    }
    public static double binomial(int N, int k, double p){
        if ((N == 0) && (k == 0)) return 1.0;
        if ((N < 0) || (k < 0)) return 0.0;
        count+=1;
        if (result[N][k] == -1) result[N][k]  = (1.0 - p) * binomial(N - 1, k, p)  + p * binomial(N-1, k-1, p);
        return result[N][k];
    }
    public static double binomial2(int N, int k, double p) {
        count++;

        if ((N == 0) && (k == 0)) return 1.0;
        if ((N < 0) || (k < 0)) return 0.0;
        return (1 - p) * binomial2(N - 1, k, p) + p * binomial2(N - 1, k - 1, p);
    }
}
