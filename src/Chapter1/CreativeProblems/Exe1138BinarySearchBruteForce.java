package Chapter1.CreativeProblems;

public class Exe1138BinarySearchBruteForce {

    public static int bruteForceSearch(int key, int []a){
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }
    public static int binarySearch(int key, int[]a){
        int low = 0;
        int high = a.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (key < a[mid]) high = mid - 1;
            else if (key > a[mid]) low = mid + 1;
            else if (key == a[mid]) return mid;
        }
        return -1;
    }
}
