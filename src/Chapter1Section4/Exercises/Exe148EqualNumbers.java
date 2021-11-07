package Chapter1Section4.Exercises;

import java.util.Arrays;

public class Exe148EqualNumbers {

    //Quantity of numbers : Quantity of equal pairs
    //        2                      1
    //        3                      3
    //        4                      6
    //        5                      10
    // When choosing the first number there are N possibilities
    // When choosing second number there are N - 1 possibilities
    //
    // if the order of number would matter then number of different pairs that could be chosen would be  (N - 1) * N
    // However, order doesn't matter hence number of different paris that could be chosen is ((N - 1) * N) / 2! => ((N - 1) * N) / 2
    // Hence, The quantity of equal pairs is equal to: ((N - 1) * N) / 2
    /** TODO Prove by Induction
     * By induction:
     * lets consider number of pairs that can be chosen to be P(N) = ((N - 1) * N) / 2
     * Consider base cases:
     * P(1) = ((1 - 1) * 1) / 2 = 0
     * P(2) = ((2 - 1) * 2) / 2 = 1
     *
     * Now if we assume that number of pairs that could be chosen from N is ((N - 1) * N) / 2
     * and we prove that P(N + 1) = (N * (N + 1)) / 2
     * then P(N) holds for any arbitrary N
     *
     * P(N + 1) = P(N) + (number of new pairs that contain the newly inserted N + 1)
     * There are exactly "N choose K" new paris that contain N + 1 so
     * P(N + 1) = P(N) + !N / 1! (N - 1)!
     * P(N + 1) = P(N) + N
     * P(N + 1) = ((N - 1) * N) / 2 + 2 * N / 2 = (N * (N + 1)) / 2
     * therefore it is proved
     */

    public static int equalNumbers(int[] arr){
        int cnt = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (binarySearch(arr[i], arr) != -1) cnt++;
        }
        return cnt;
    }

    public static int binarySearch(int key, int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (key < arr[mid]) high = mid - 1;
            else if (key > arr[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}
