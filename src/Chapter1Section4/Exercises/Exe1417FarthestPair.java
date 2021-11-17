package Chapter1Section4.Exercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exe1417FarthestPair {
    public static void main(String[] args) {
        double[] array1 = {-5.2, 9.4, 20, -10, 21.1, 40, 50, -20};
        double[] array2 = {-4, -3, 0, 10, 20};
        double[] array3 = {-10, -3, 0, 2, 4, 20};

        double[] farthestPair1 = farthestPair(array1);
        double[] farthestPair2 = farthestPair(array2);
        double[] farthestPair3 = farthestPair(array3);

        StdOut.println("Farthest pair: " + farthestPair1[0] + " " + farthestPair1[1] + " Expected: -20.0 50.0");
        StdOut.println("Farthest pair: " + farthestPair2[0] + " " + farthestPair2[1] + " Expected: -4.0 20.0");
        StdOut.println("Farthest pair: " + farthestPair3[0] + " " + farthestPair3[1] + " Expected: -10.0 20.0");
    }
    public static double[] farthestPair(double[] arr){
        double[] result = new double[2];
        double minNum = Double.MAX_VALUE;
        double maxNum = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minNum = Math.min(minNum, arr[i]);
            maxNum = Math.max(maxNum, arr[i]);
        }
        result[0] = minNum;
        result[1] = maxNum;
        return result;
    }
}
