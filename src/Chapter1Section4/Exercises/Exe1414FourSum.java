package Chapter1Section4.Exercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exe1414FourSum {
    public static void main(String[] args) {
////         Method 1
        StdOut.println("Array1");
        int[] array1 = {-5, -2, -2, 2, 5};
        StdOut.println("4 sum: " + countFourSumFasterMore(array1));
        StdOut.println("Expected: 2\n");

        StdOut.println("Array2");
        int[] array2 = {-6, -5, -4, -1, 1, 2, 2, 3, 4, 4};
        StdOut.println("4 sum: " + countFourSumFasterMore(array2));
        StdOut.println("Expected: 13");


        //
        // -2 , -1, 0, 0, 1, 2
    }

    // O(N^4) slow
    public static int countFourSum(int[] arr) {
        int N = arr.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == 0) {
                            cnt++;
                        }

                    }
                }
            }

        }
        return cnt;
    }

    // O( lgN * N^3)
    public static int countFourSumFaster(int[] arr) {
        int N = arr.length;
        int cnt = 0;
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int key = -(arr[i] + arr[j] + arr[k]);
                    int highestIndex = binarySearchHighestIndex(arr, key, k + 1);
                    int lowestIndex = binarySearchLowestIndex(arr, key, k + 1);
                    if (highestIndex != -1 && lowestIndex != -1) {

                        if (highestIndex > k && lowestIndex == k) cnt += 1;
                        else if (highestIndex > k && lowestIndex > k) cnt += (highestIndex - lowestIndex + 1);
                    }
                }
            }

        }
        return cnt;
    }

    public static int binarySearchLowestIndex(int[] arr, int target, int startIndex) {
        int low = startIndex;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target <= arr[mid]) high = mid - 1;
            else if (target > arr[mid]) low = mid + 1;
        }
        if (high >= arr.length || high < 0) return -1;
        if (arr[high] == target) return high;
        else if (high + 1 < arr.length && arr[high + 1] == target) return high + 1;
        return -1;
    }

    public static int binarySearchHighestIndex(int[] arr, int target, int startIndex) {
        int low = startIndex;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < arr[mid]) high = mid - 1;
            else if (target >= arr[mid]) low = mid + 1;
        }

        if (low < arr.length && arr[low] == target) return low;
        else if (low - 1 < arr.length && low - 1 > 0 && arr[low - 1] == target) return low - 1;
        return -1;
    }

    // O(N^3)
    public static int countFourSumFasterMore(int[] arr) {
        int cnt = 0;
        int N = arr.length;
        HashMap<Integer, Integer> hashNumCount = new HashMap<>();
        HashMap<Integer, Integer> hashNumIndex = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            if (!hashNumCount.containsKey(arr[i])) hashNumCount.put(arr[i], 1);
            else hashNumCount.put(arr[i], hashNumCount.get(arr[i]) + 1);

            if (!hashNumIndex.containsKey(arr[i])) hashNumIndex.put(arr[i], i);

        }
        for (Map.Entry<Integer, Integer> entry1 : hashNumIndex.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : hashNumIndex.entrySet()) {
                for (Map.Entry<Integer, Integer> entry3 : hashNumIndex.entrySet()) {
                    int num1 = entry1.getKey();
                    int num2 = entry2.getKey();
                    int num3 = entry3.getKey();
                    int key = -(num1 + num2 + num3);
//                    if (num1 == -1 && num2 == -1 && num3 == 1) {
//                        System.out.println("hello");
//
//                    }
                    int entry1Index = entry1.getValue();
                    int entry2Index = entry2.getValue();
                    int entry3Index = entry3.getValue();
                    if (entry1Index < entry2Index && entry2Index < entry3Index && hashNumIndex.containsKey(key)) {
                        int keyIndex = hashNumIndex.get(key);
                        int count = hashNumCount.get(key);
                        if (entry3Index < keyIndex || keyIndex < entry1Index) {
//                            System.out.printf("%d %d %d %d\n", entry1.getKey(), entry2.getKey(), entry3.getKey(), key);
                            cnt += count;
                        }
                    }

                }
            }
        }
        return cnt;
    }
}
