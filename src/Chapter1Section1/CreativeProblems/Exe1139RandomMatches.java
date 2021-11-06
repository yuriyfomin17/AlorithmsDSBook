package Chapter1Section1.CreativeProblems;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exe1139RandomMatches {
    public static void main(String[] args) {
        int T = 6;
        int[] arrN = {1000, 10000, 100000, 1000000};
        double[] frequency = {0, 0, 0, 0};
        int count = 0;
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < arrN.length; j++) {
                int[] arr1 = new int[arrN[j]];
                int[] arr2 = new int[arrN[j]];
                initializeArr(arr1, arr2);
                for (int k = 0; k < arr1.length; k++) {
                    if (i > 0 && arr1[i] == arr1[i - 1]) {
                        count += 1;
                        continue;
                    }
                    int target = arr1[k];
                    if (binarySearch(arr2, target) != -1) frequency[j] += 1;
                }
            }
        }
        System.out.println(count);
        System.out.println("Array Size       AVG number of values in both arrays");
        System.out.printf("10^3                %.2f\n", frequency[0] / T);
        System.out.printf("10^4                %.2f\n", frequency[1] / T);
        System.out.printf("10^5                %.2f\n", frequency[2] / T);
        System.out.printf("10^6                %.2f\n", frequency[3] / T);
    }
    public static int binarySearch(int [] arr, int target){
        if (arr == null) throw new IllegalArgumentException();
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (target < arr[mid]) high = mid - 1;
            else if(target > arr[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static void initializeArr(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = StdRandom.uniform(100000, 1000000);
            arr2[i] = StdRandom.uniform(100000, 1000000);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
