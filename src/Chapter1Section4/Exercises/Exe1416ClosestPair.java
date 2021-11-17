package Chapter1Section4.Exercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exe1416ClosestPair {
    public static void main(String[] args) {
        double[] array1 = {-5.2, 9.4, 20, -10, 21.1, 40, 50, -20};
        double[] array2 = {-4, -3, 0, 10, 20};
        double[] array3 = {-10, -3, 0, 2, 4, 20};

        double[] closestPair1 = closestPair(array1);
        double[] closestPair2 = closestPair(array2);
        double[] closestPair3 = closestPair(array3);

        StdOut.println("Closest pair: " + closestPair1[0] + " " + closestPair1[1] + " Expected: 20.0 21.1");
        StdOut.println("Closest pair: " + closestPair2[0] + " " + closestPair2[1] + " Expected: -4.0 -3.0");
        StdOut.println("Closest pair: " + closestPair3[0] + " " + closestPair3[1] + " Expected: 0.0 2.0");
    }
    public static double[] closestPair(double[] arr){
        double[] result = new double[2];
        Arrays.sort(arr);
        double closestDistance = Double.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (closestDistance > Math.abs(arr[i] - arr[i - 1])){
                result[0] = arr[i - 1];
                result[1] = arr[i];
                closestDistance = Math.abs(arr[i] - arr[i - 1]);
            }
        }
        return result;
    }
}
