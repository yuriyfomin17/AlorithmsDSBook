package Chapter1Section4.Exercises;

import edu.princeton.cs.algs4.StdOut;


public class Exe1423BinarySearchDuplicates {
    public static void main(String[] args) {
        int num = Integer.MAX_VALUE;
        int[] array = {-4, -1, 1, 2, 2, 2, 2, 2, 2, 2, 4, 5};
        //First rank tests
        int firstRankElement1 = binarySearchFirstIndex(array, -4);
        int firstRankElement2 = binarySearchFirstIndex(array, -8);
        int firstRankElement3 = binarySearchFirstIndex(array, 5);
        int firstRankElement4 = binarySearchFirstIndex(array, 2);

        StdOut.println("First index of element -4: " + firstRankElement1 + " Expected: 0");
        StdOut.println("First index of element -8: " + firstRankElement2 + " Expected: -1");
        StdOut.println("First index of element 5: " + firstRankElement3 + " Expected: 11");
        StdOut.println("First index of element 2: " + firstRankElement4 + " Expected: 3");
        System.out.println();
        StdOut.println("First index of element -4: " + binarySearchFirstIndexRecursionFasterFirstIndex(array, 0, array.length - 1, -4) + " Expected: 0");
        StdOut.println("First index of element -8: " + binarySearchFirstIndexRecursionFasterFirstIndex(array, 0, array.length - 1, -8) + " Expected: -1");
        StdOut.println("First index of element 5: " + binarySearchFirstIndexRecursionFasterFirstIndex(array, 0, array.length - 1, 5) + " Expected: 11");
        StdOut.println("First index of element 2: " + binarySearchFirstIndexRecursionFasterFirstIndex(array, 0, array.length - 1, 2) + " Expected: 3");
        System.out.println();
        StdOut.println("First index of element -4: " + binarySearchIndexRecursionFasterLastIndex(array, 0, array.length - 1, -4) + " Expected: 0");
        StdOut.println("First index of element -8: " + binarySearchIndexRecursionFasterLastIndex(array, 0, array.length - 1, -8) + " Expected: -1");
        StdOut.println("First index of element 5: "  + binarySearchIndexRecursionFasterLastIndex(array, 0, array.length - 1, 5) + " Expected: 11");
        StdOut.println("First index of element 2: "  + binarySearchIndexRecursionFasterLastIndex(array, 0, array.length - 1, 2) + " Expected: 9");

    }

    // It is O(log N) however, if there would be a large number of same numbers then it
    // would be O(K) where K iterations which is equal to frequency of numbers which are same and equal to our target
    public static int binarySearchFirstIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prevNum = mid - 1 >= 0 ? arr[mid - 1] : -Integer.MAX_VALUE;
//            System.out.println("prevNum:" + prevNum);
            if (target > arr[mid]) low = mid + 1;
            else if (target < arr[mid] || prevNum == target) high = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static int binarySearchFirstIndexRecursionFasterFirstIndex(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (target > arr[mid]) return binarySearchFirstIndexRecursionFasterFirstIndex(arr, mid + 1, high, target);
        else if (target < arr[mid]) return binarySearchFirstIndexRecursionFasterFirstIndex(arr, low, mid - 1, target);
        else {
            int lowestIndex = binarySearchFirstIndexRecursionFasterFirstIndex(arr, low, mid - 1, target);
            if (lowestIndex != -1) return lowestIndex;
            else return mid;
        }
    }

    public static int binarySearchIndexRecursionFasterLastIndex(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (target > arr[mid]) return binarySearchIndexRecursionFasterLastIndex(arr, mid + 1, high, target);
        else if (target < arr[mid]) return binarySearchIndexRecursionFasterLastIndex(arr, low, mid - 1, target);
        else {
            int highestIndex = binarySearchIndexRecursionFasterLastIndex(arr, mid + 1, high, target);
            if (highestIndex != -1) return highestIndex;
            else return mid;
        }
    }
}
