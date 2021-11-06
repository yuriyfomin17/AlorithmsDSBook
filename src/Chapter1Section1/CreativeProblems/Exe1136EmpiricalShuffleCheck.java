package Chapter1Section1.CreativeProblems;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exe1136EmpiricalShuffleCheck {
    class Printer {
        public static void print(int[][] mat) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    StdOut.print(mat[i][j] + " ");
                }
                StdOut.println();
            }

        }
        public static void print(double[] mat) {
            for (int i = 0; i < mat.length; i++) {
                StdOut.print(mat[i] + " ");
                StdOut.println();
            }

        }
    }
    public static void main(String[] args) {
        int numShuffles = 100000;
        int M = 5;
        double[] arr = {0.0 , 1.0, 2.0, 3.0, 4.0};
        int[][] matrixResult = new int[M][M];
        for (int i = 0; i < numShuffles; i++) {
            shuffle(arr);
            for (int j = 0; j < arr.length; j++) {
                matrixResult[(int)arr[j]][j] += 1;
            }
        }
        Printer.print(matrixResult);
    }
    public static void shuffle(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {  // Exchange a[i] with random element in a[i..N-1]
            int r = i + StdRandom.uniform(N - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    public static void initializeArray(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

}
