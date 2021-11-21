package Chapter1Section4.Exercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe1420BitonicSearch {
    public static void main(String[] args) {
        int[] arr = { -5, -6, 2, 3, 7, 9, 8, 6, 5, 1, 0 , -1, -3};

        int[] array1 = {1, 2, 3, 4, -1, -2, -3};
        int[] array2 = {1, 5, 4, 3, 2, 0};
        int[] array3 = {2, 4, 8, 16, 32, 1};
        int[] array4 = {2, 4, 8, 16, 32};
        int[] array5 = {2, 1};
        int[] array6 = {9};

        int indexOfElement = bitonicSearch(arr, 8);
        int indexOfElement1 = bitonicSearch(array1, -1);
        int indexOfElement2 = bitonicSearch(array2, 5);
        int indexOfElement3 = bitonicSearch(array3, 2);
        int indexOfElement4 = bitonicSearch(array3, 99);
        int indexOfElement5 = bitonicSearch(array4, 32);
        int indexOfElement6 = bitonicSearch(array5, 1);
        int indexOfElement7 = bitonicSearch(array6, 9);

        StdOut.println("Index of element: " + indexOfElement + " Expected: 6");
        StdOut.println("Index of element: " + indexOfElement1 + " Expected: 4");
        StdOut.println("Index of element: " + indexOfElement2 + " Expected: 1");
        StdOut.println("Index of element: " + indexOfElement3 + " Expected: 0");
        StdOut.println("Index of element: " + indexOfElement4 + " Expected: -1");
        StdOut.println("Index of element: " + indexOfElement5 + " Expected: 4");
        StdOut.println("Index of element: " + indexOfElement6 + " Expected: 1");
        StdOut.println("Index of element: " + indexOfElement7 + " Expected: 0");

    }
    public static int bitonicSearch(int[] arr, int target){
        int peakIndex = findPeakIndex(arr);
        // we already know that at peakIndex we have a maximum peak element
        // hence, if target is bigger then that return -1 straight away
        if (arr[peakIndex] < target) return -1;
        int targetIndex = binarySearch(arr, 0, peakIndex, target);
        if (targetIndex == -1) targetIndex = binarySearchInverse(arr, peakIndex, arr.length - 1, target);
        return targetIndex;

    }
    // find the peak index of break in log(N)
    public static int findPeakIndex(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int rightNum = mid + 1 < arr.length ? arr[mid + 1] : -Integer.MAX_VALUE;
            int leftNum = mid - 1 >= 0 ? arr[mid - 1]: -Integer.MAX_VALUE;
            if (arr[mid] < rightNum) low = mid + 1;
            else if (leftNum > arr[mid]) high = mid - 1;
            else if (arr[mid] > rightNum) return mid;
        }
        return -1;
    }
    // classic binary search in log(N)
    public static int binarySearch(int[] arr, int low, int high, int target){
        int mid = low + (high - low) / 2 ;
        if (arr[mid] == target) return mid;
        else if (low == high) return -1;
        else if (target < arr[mid]) return binarySearch(arr, low, mid - 1, target);
        else if (target > arr[mid]) return binarySearch(arr, mid + 1, high, target);
        return -1;
    }
    public static int binarySearchInverse(int[] arr, int low, int high, int target){
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) return mid;
        else if (target > arr[mid]) return binarySearchInverse(arr, low, mid - 1, target );
        else if (target < arr[mid]) return binarySearchInverse(arr, mid + 1, high, target);
        return -1;
    }
}
