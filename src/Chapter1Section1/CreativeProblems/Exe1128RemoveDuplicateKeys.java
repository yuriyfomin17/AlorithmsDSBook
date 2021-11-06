package Chapter1Section1.CreativeProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class Exe1128RemoveDuplicateKeys {
    public static void main(String[] args) {
        int[] whitelist = {1, 2, 3, 4, 5, 6, 6, 7, 7, 8};
        int[] keys = {1, 4 , 5, 9, 10};
        ArrayList<Integer> arrayList = new ArrayList<>();
        Arrays.sort(whitelist);
        removeDuplicates(whitelist, arrayList);
        System.out.println(arrayList);
    }
    public static int binarySearch(int target, int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (target < arr[mid]) high = mid - 1;
            else if (target > arr[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static ArrayList<Integer> removeDuplicates(int[] arr, ArrayList<Integer> arrayList){
        arrayList.add(arr[0]);
        for (int el : arr) {
            if (el != arrayList.get(arrayList.size() -1 )) {
                arrayList.add(el);
            }
        }
        return arrayList;
    }


}
