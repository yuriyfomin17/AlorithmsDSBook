package Chapter1Section4.Exercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe1418LocalMinimum {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 6, 5, 3, 7, 4};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        int[] array3 = {7, 6, 5, 4, 3, 2, 1};
        int[] array4 = {5, 5, 5, 5, 5, 5, 5};
        int[] array5 = {1, 2};

        int[] array6 = {10, -9, 20, 25, 21, 40, 50, -20};
        int[] array7 = {-4, -3, 9, 4, 10, 2, 20};
        int[] array8 = {5, -3, -5, -6, -7, -8};
        int[] array9 = {5};
        int[] array10 = {10, 20};
        int[] array11 = {7, 20, 30};

        System.out.println("<-------Local Maximum Test-------->");
        Object localMaximum1 = localMaximum(array1, 0, array1.length - 1);
        Object localMaximum2 = localMaximum(array2, 0, array2.length - 1);
        Object localMaximum3 = localMaximum(array3, 0, array3.length - 1);
        Object localMaximum4 = localMaximum(array4, 0, array4.length - 1);
        Object localMaximum5 = localMaximum(array5, 0, array5.length - 1);
        StdOut.println("Local Maximum: " + localMaximum1 + " Expected: 6 or 7");
        StdOut.println("Local Maximum: " + localMaximum2 + " Expected: 7");
        StdOut.println("Local Maximum: " + localMaximum3 + " Expected: 7");
        StdOut.println("Local Maximum: " + localMaximum4 + " Expected: null");
        StdOut.println("Local Maximum: " + localMaximum5 + " Expected: 2");
        System.out.println("<-------------------------------->\n");

        System.out.println("<-------Local Minimum Test-------->");
        Object localMinimum1 = localMinimum(array1, 0, array1.length - 1);
        Object localMinimum2 = localMinimum(array2, 0, array2.length - 1);
        Object localMinimum3 = localMinimum(array3, 0, array3.length - 1);
        Object localMinimum4 = localMinimum(array4, 0, array4.length - 1);
        Object localMinimum5 = localMinimum(array5, 0, array5.length - 1);
        Object localMinimum6 = localMinimum(array6, 0, array6.length - 1);
        Object localMinimum7 = localMinimum(array7, 0, array7.length - 1);
        Object localMinimum8 = localMinimum(array8, 0, array8.length - 1);
        Object localMinimum9 = localMinimum(array9, 0, array9.length - 1);
        Object localMinimum10 = localMinimum(array10, 0, array10.length - 1);
        Object localMinimum11 = localMinimum(array11, 0, array11.length - 1);
        StdOut.println("Local Minimum: " + localMinimum1 + " Expected: 1 or 3 or 4 ");
        StdOut.println("Local Minimum: " + localMinimum2 + " Expected: 1");
        StdOut.println("Local Minimum: " + localMinimum3 + " Expected: 1");
        StdOut.println("Local Minimum: " + localMinimum4 + " Expected: null");
        StdOut.println("Local Minimum: " + localMinimum5 + " Expected: 1");
        StdOut.println("Local Minimum: " + localMinimum6 + " Expected: -9 or - 20");
        StdOut.println("Local Minimum: " + localMinimum7 + " Expected: -4 or 2 or 4");
        StdOut.println("Local Minimum: " + localMinimum8 + " Expected: -8");
        StdOut.println("Local Minimum: " + localMinimum9 + " Expected: 5");
        StdOut.println("Local Minimum: " + localMinimum10 + " Expected: 10");
        StdOut.println("Local Minimum: " + localMinimum11 + " Expected: 7");
        System.out.println("<-------------------------------->");
    }

    // O(log(N)) also I assume that for (index >= arr.length and index < 0) out of bound we have -infinity
    public static Object localMaximum(int[] arr, int low, int high) {
        int N = arr.length;
        int mid = low + (high - low) / 2;
        int leftNum = mid - 1 >= 0 ? arr[mid - 1] : -Integer.MAX_VALUE;
        int rightNum = mid + 1 < arr.length ? arr[mid + 1]: -Integer.MAX_VALUE;
        if (N == 1 || (arr[mid] > leftNum && arr[mid] > rightNum)) {
            return arr[mid];
        } else if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) return localMaximum(arr, low, mid - 1);
        else if (mid + 1 <= N && arr[mid + 1] > arr[mid]) return localMaximum(arr, mid + 1, high);
        else return null;
    }

    // O(log(N)) also I assume that for (index >= arr.length and index < 0) out of bound we have infinity
    public static Object localMinimum(int[] arr, int low, int high) {
        int N = arr.length;
        int mid = low + (high - low) / 2;
        int leftNum = mid - 1 >= 0 ? arr[mid - 1] : Integer.MAX_VALUE;
        int rightNum = mid + 1 < arr.length ? arr[mid + 1]: Integer.MAX_VALUE;
//        System.out.println("leftNum: " + leftNum);
//        System.out.println("rightNum: " + rightNum);
//        System.out.println("Mid: " + arr[mid]);
        if (N == 1 || arr[mid] < leftNum && arr[mid] < rightNum) {
            return arr[mid];
        } else if ( mid - 1 >= 0 && arr[mid - 1] < arr[mid]) return localMinimum(arr, low, mid - 1);
        else if (mid + 1 <= N && arr[mid + 1] < arr[mid]) return localMinimum(arr, mid + 1, high);
        return null;
    }
}

