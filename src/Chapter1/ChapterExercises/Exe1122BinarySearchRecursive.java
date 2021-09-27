package Chapter1.ChapterExercises;

public class Exe1122BinarySearchRecursive {
    public static void main(String[] args) {
    }

    public static void exe1122(){ // ✅ checked
        int [] arr = {1, 2, 3, 4, 5, 6,7, 8, 9};
        class RecursiveBinarySearch{
            public static int search(int[]arr , int lo, int hi, int target, int depth){
                int mid = lo + (hi - lo) / 2;
                System.out.printf("lo %d, hi %d, depth %d\n", lo, hi, depth);
                depth+=1;
                if (arr[mid] == target) return mid;
                if (arr[mid] < target) return search(arr, mid + 1, hi, target, depth);
                if (arr[mid] > target) return search(arr, lo, mid - 1, target, depth);
                return -1;
            }
        }
        System.out.println(RecursiveBinarySearch.search(arr, 0, arr.length -1, 9, 0));
    }
}
