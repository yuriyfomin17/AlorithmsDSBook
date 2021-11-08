package Chapter1Section4.Exercises;

public class Exe1410BinarySearchSmallestIndex {
    static public int binarySearch(int key, int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (key > arr[mid]) low = mid + 1;
            else if (key < arr[mid]) high = mid - 1;
            else return binarySearchLowestIndex(arr, mid);
        }
        return -1;
    }
    static public int binarySearchLowestIndex(int[] arr, int midIndex){
        int low = 0;
        while (low < midIndex){
            int mid = low + (midIndex - low) / 2;
            if ( arr[mid] < arr[midIndex]) low = mid;
            else return mid;
        }
        return midIndex;
    }
    static public int binarySearchLowestIndexFaster(int[] arr, int midIndex, int currentLow){
        int low = currentLow;
        while (low < midIndex){
            int mid = low + (midIndex - low) / 2;
            if ( arr[mid] < arr[midIndex]  ) low = mid;
            else return mid;
        }
        return midIndex;
    }

    public static void main(String[] args) {
        int[] testArray1 = {3, 4, 4, 4,  5, 6, 10, 15, 20, 20, 20, 20, 21};
        int elementToSearch1 = 4;
        int elementToSearch2 = 20;
        int elementToSearch3 = -5;
        System.out.println("Binary Search: " + binarySearch(elementToSearch1, testArray1) + " Expected: 1");
        System.out.println("Binary Search: " + binarySearch(elementToSearch2, testArray1) + " Expected: 8");
        System.out.println("Binary Search: " + binarySearch(elementToSearch3, testArray1) + " Expected: -1");
    }

}
