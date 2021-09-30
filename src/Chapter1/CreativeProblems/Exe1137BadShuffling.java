package Chapter1.CreativeProblems;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exe1137BadShuffling {
    // Parameters example: 200000 5
    public static void main(String[] args) {
        int n = 200000;
        int m = 5;

        int[][] positions = new int[m][m];

        double[] array = new double[m];

        for (int i = 0; i < n; i++) {
            initializeArray(array);
            badShuffle(array);

            for (int j = 0; j < array.length; j++) {
                positions[(int) array[j]][j]++;
            }
        }

        printTable(positions);
    }

    private static void initializeArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static void badShuffle(double[] array) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int randomIndex =  StdRandom.uniform(n);


            double temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    private static void printTable(int[][] positions) {
        StdOut.println("TABLE");

        for (int i = 0; i < positions.length; i++) {
            StdOut.printf("%3d  ", i);

            for (int j = 0; j < positions[0].length; j++) {
                StdOut.printf("%4d ", positions[i][j]);
            }
            StdOut.println();
        }
    }
}
