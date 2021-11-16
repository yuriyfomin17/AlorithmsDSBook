package Chapter1Section4.Exercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Exe1415Faster3Sum {
    public static void main(String[] args) {
        int[] array = {-10, -10, -5, 0, 5, 10, 10, 15, 20};
        int[] arrayTest1 = {-3, -2, 2, 3, 5, 99};
        int[] arrayTest2 = {-10, -10, -10, 10, 10};
        int[] arrayTest3 = {0, 0, 0, 0, 0};
        int[] arrayTest4 = {-2, -1, 0, 0, 0, 0, 0, 0, 1};

        StdOut.println("Two Sum!");
        StdOut.println("TwoSumFaster: " + twoSum(array, 0) + " Expected: 5");
        StdOut.println("TwoSumFaster: " + twoSum(arrayTest1, 0) + " Expected: 2");
        StdOut.println("TwoSumFaster: " + twoSum(arrayTest2, 0) + " Expected: 6");
        StdOut.println("TwoSumFaster: " + twoSum(arrayTest3, 0) + " Expected: 10");
        StdOut.println("TwoSumFaster: " + twoSum(arrayTest4, 0) + " Expected: 16");


//        int[] array = {-10, -10, -5, 0, 5, 10, 10, 15, 20};
//        int[] arrayTest1 = {-3, -2, 2, 3, 5, 99};
//        int[] arrayTest2 = {-10, -10, -10, 10};
//        int[] arrayTest3 = {0, 0, 0, 0, 0, 0, 0};
//        int[] arrayTest4 = {-2, -1, 0, 0, 0, 0, 0, 0, 3};
//
//        StdOut.println("Three Sum!");
//        StdOut.println("ThreeSumFaster: " + threeSum(array, 0) + " Expected: 8");
//        StdOut.println("ThreeSumFaster: " + threeSum(arrayTest1, 0) + " Expected: 1");
//        StdOut.println("ThreeSumFaster: " + threeSum(arrayTest2, 0) + " Expected: 0");
//        StdOut.println("ThreeSumFaster: " + threeSum(arrayTest3, 0) + " Expected: 35");
//        StdOut.println("ThreeSumFaster: " + threeSum(arrayTest4, 0) + " Expected: 21");

    }

    // O(n)
    public static int twoSum(int[] arr, int target) {
//        Arrays.sort(arr);
        HashMap<Integer, Integer> hashMapCount = new HashMap<>();
        HashMap<Integer, Integer> hashMapIndex = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!hashMapCount.containsKey(arr[i])) hashMapCount.put(arr[i], 1);
            else hashMapCount.put(arr[i], hashMapCount.get(arr[i]) + 1);

            if (!hashMapIndex.containsKey(arr[i])) hashMapIndex.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int key = target - arr[i];
            int keyIndex = hashMapIndex.getOrDefault(key, -1);
            int count = hashMapCount.getOrDefault(key, - 1);
            if (keyIndex != -1 && (i < keyIndex || i < keyIndex + count - 1)) {
                if (key == target && count != 1){
                    cnt += count * (count - 1) / 2;
                    hashMapCount.remove(key);
                    hashMapIndex.remove(key);
                }else {
                    cnt+= count;
                }

            }

        }
        return cnt;
    }

    public static int threeSum(int[] arr, int target) {
        HashMap<Integer, Integer> hashMapCount = new HashMap<>();
        HashMap<Integer, Integer> hashMapIndex = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!hashMapCount.containsKey(arr[i])) hashMapCount.put(arr[i], 1);
            else hashMapCount.put(arr[i], hashMapCount.get(arr[i]) + 1);
            if (!hashMapIndex.containsKey(arr[i])) hashMapIndex.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int key = target - (arr[i] + arr[j]);
                int keyIndex = hashMapIndex.getOrDefault(key, -1);
                int count = hashMapCount.getOrDefault(key, -1);
                if (keyIndex != -1  && (j < keyIndex || j < keyIndex + count - 1)) {
                    if (key == target && count != 1) {
                        cnt += count * (count - 1) * (count - 2) / 6;
                        hashMapIndex.remove(key);
                        hashMapCount.remove(key);
                    } else {
                        cnt += count;
                    }


                }
            }
        }
        return cnt;
    }
}
