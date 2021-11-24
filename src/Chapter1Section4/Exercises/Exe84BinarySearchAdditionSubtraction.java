package Chapter1Section4.Exercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe84BinarySearchAdditionSubtraction {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println("Target 9: " + fibonacciSearch(arr, 9) + " Expected 8");
        System.out.println("Target 6: " + fibonacciSearch(arr, 6) + " Expected 5");
        System.out.println("Target 7: " + fibonacciSearch(arr, 7) + " Expected 6");

        System.out.println("Target 11: " + fibonacciSearch(arr, 11) + " Expected 10");
        System.out.println("Target 14: " + fibonacciSearch(arr, 14) + " Expected 13");
        System.out.println();


        int[] array = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};


        int index1 = fibonacciSearch(array, 2);
        int index2 = fibonacciSearch(array, 9);
        int index3 = fibonacciSearch(array, -3);
        int index4 = fibonacciSearch(array, 7);
        int index5 = fibonacciSearch(array, -2);

        StdOut.println("Is element in the array: " + (index1 != -1) + " Expected: true");
        StdOut.println("Is element in the array: " + (index2 != -1) + " Expected: false");
        StdOut.println("Is element in the array: " + (index3 != -1) + " Expected: false");
        StdOut.println("Is element in the array: " + (index4 != -1) + " Expected: true");
        StdOut.println("Is element in the array: " + (index5 != -1) + " Expected: true");
    }

    public static int fibonacciSeries(int higherBound) {

        int sum = 1;
        int g = 0;
        if (higherBound == 1) return 1;
        else if (higherBound == 0) return 0;
        while (sum + g <= higherBound) {
            sum = sum + g;
            g = sum - g;
        }
        return sum;
    }

    public static int fibonacciSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            System.out.println("low: " + low);
            System.out.println("high: " + high);
            int indexToCHeck = low + fibonacciSeries(high - low);
            System.out.println("indexToCHeck: " + indexToCHeck);
            System.out.println();
            if (target > arr[indexToCHeck]) low = indexToCHeck + 1;
            else if (target < arr[indexToCHeck]) high = indexToCHeck - 1;
            else return indexToCHeck;
        }
        return -1;
    }
}
