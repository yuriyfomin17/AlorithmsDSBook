package Chapter1Section4.Exercises;

import java.util.Arrays;
import java.util.HashSet;

public class Exe1421BinarySearchDistinctNumbers {
    public static void main(String[] args) {
        int[] array = {99, 8, 8, 1, 2, 4, 1, -3};
        System.out.println("Contains Element 4: " + distinctValueBinarySearch(array, 4) + " Expected: true");
        System.out.println("Contains Element -3: " + distinctValueBinarySearch(array, -3) + " Expected: true");
        System.out.println("Contains Element 99: " + distinctValueBinarySearch(array, 99) + " Expected: true");
        System.out.println("Contains Element 0: " + distinctValueBinarySearch(array, 0) + " Expected: false");
    }
    public static boolean distinctValueBinarySearch(int[] arr, int target){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num: arr) hashSet.add(num);

        int[] distinctArrNums = new int[hashSet.size()];
        int idx = 0;
        for (int num: hashSet) distinctArrNums[idx++] = num;
        Arrays.sort(distinctArrNums);
        return binarySearch(distinctArrNums, target);

    }
    public static boolean binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            else if (target > arr[mid]) low = mid + 1;
            else if (target < arr[mid]) high = mid - 1;
        }
        return false;
    }
}
