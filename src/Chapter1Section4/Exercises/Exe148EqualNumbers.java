package Chapter1Section4.Exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    // O(N lg(N)) solution
    public static int countPairs(int[] arr){
        Arrays.sort(arr);
        int sameNumbersCount = 0;
        int cntNumPairs = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i] && sameNumbersCount == 0) sameNumbersCount = 2;
            else if (arr[i - 1] == arr[i] && sameNumbersCount != 0) sameNumbersCount += 1;
            else if (arr[i - 1] != arr[i] && sameNumbersCount != 0){
                cntNumPairs += ((sameNumbersCount - 1) * sameNumbersCount) / 2;
                sameNumbersCount = 0;
            }
        }
        if (sameNumbersCount != 0) cntNumPairs += ((sameNumbersCount - 1) * sameNumbersCount) / 2;
        return cntNumPairs;
    }
    // O(N) solution
    public static int countPairsFaster(int [] arr){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(arr[i])) hashMap.put(arr[i], 1);
            else if (hashMap.containsKey(arr[i])) hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
        }
        int cntNumPairs = 0;
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()){
            int N = entry.getValue();
            cntNumPairs += (N - 1) * N / 2;
        }
        return cntNumPairs;
    }


    public static void main(String[] args) {
        // Tests
        int[] values1 = {1, 2, 4, 1, 2, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2 ,5, 6, 7, 7, 8, 2, 1, 2, 4, 5};

        System.out.println("Equal pairs: " + countPairsFaster(values1) + " expected: 49");
        int[] values2 = {1, 1, 1};
        System.out.println("Equal pairs: " + countPairsFaster(values2) + " expected: 3");
    }

}
