package Chapter1Section2.ChapterExercises;

import edu.princeton.cs.algs4.Counter;

public class Exe129BinarySearchWithCounter {
    public static void main(String[] args) {
        int[] array = {1 , 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        Counter counter = new Counter("operations");
        int index = binarySearch(array, target, counter);
        System.out.printf("index %d\n", index);
        System.out.println(counter);
    }
    public static int binarySearch(int[] arr, int target, Counter counter){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            counter.increment();
            if (target > arr[mid]) low = mid + 1;
            else if (target < arr[mid]) high = mid - 1;
            else return mid;
        }
        return -1;
    }
}
