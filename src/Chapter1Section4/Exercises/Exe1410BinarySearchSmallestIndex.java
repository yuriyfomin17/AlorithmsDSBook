package Chapter1Section4.Exercises;

public class Exe1410BinarySearchSmallestIndex {


    static public int binarySearchBiggestIndex(int key, int[] arr){
        int high = arr.length - 1;
        int low  = 0;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) high = mid - 1;
            else if (arr[mid] <= key)  low = mid + 1;
        }
        if (arr[low] == key) return low;
        else if (arr[low - 1] == key) return low - 1;
        return -1;
    }
    static public int binarySearchLowestIndex(int key, int[] arr){
        int high = arr.length - 1;
        int low = 0;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (arr[mid] >= key) high = mid - 1;
            else if (arr[mid] < key) low = mid + 1;
        }
        if (arr[high] == key) return high;
        else if (arr[high + 1] == key)return high + 1;
        return -1;
    }

    static public int binarySearchLowestIndexRecursion(int target, int[] arr, int low, int high){
        int mid = low + (high - low) / 2;
        if (low > high) return -1;
        else if (target > arr[mid]) return binarySearchLowestIndexRecursion(target, arr, mid + 1, high);
        else if (target < arr[mid]) return binarySearchLowestIndexRecursion(target, arr, low, mid - 1);
        else {
            int indexLow = binarySearchLowestIndexRecursion(target, arr, low, mid - 1);
            if (indexLow != -1) return indexLow;
            else return mid;
        }
    }

    static public int binarySearchHighestIndexRecursion(int target, int[] arr, int low, int high){
        int mid = low + (high - low) / 2;
        if (low > high) return -1;
        else if (target > arr[mid]) return binarySearchHighestIndexRecursion(target, arr, mid + 1, high);
        else if (target < arr[mid]) return binarySearchHighestIndexRecursion(target, arr, low, mid - 1);
        else {
            int indexHigh = binarySearchHighestIndexRecursion(target, arr, mid + 1, high);
            if (indexHigh != -1) return indexHigh;
            else return mid;
        }
    }

    public static void main(String[] args) {
        int[] testArray1 = {3, 4, 4, 4, 4, 5, 6, 6, 6, 6, 10, 15, 20, 20, 20, 20, 21};
        int elementToSearch1 = 4;
        int elementToSearch2 = 20;
        System.out.println("Binary Search Lowest Index: " + binarySearchLowestIndex( elementToSearch1, testArray1) + " Expected: 1");
        System.out.println("Binary Search Biggest Index: " + binarySearchBiggestIndex( elementToSearch1, testArray1) + " Expected: 4");
        System.out.println();
        System.out.println("Binary Search Lowest Index Recursion: " + binarySearchLowestIndexRecursion( elementToSearch1, testArray1, 0, testArray1.length - 1) + " Expected: 1");
        System.out.println("Binary Search Lowest Index Recursion: " + binarySearchLowestIndexRecursion( elementToSearch2, testArray1, 0, testArray1.length - 1) + " Expected: 12");
        System.out.println();
        System.out.println("Binary Search Highest Index Recursion: " + binarySearchHighestIndexRecursion(elementToSearch1, testArray1, 0, testArray1.length - 1) + " Expected: 4");
        System.out.println("Binary Search Highest Index Recursion: " + binarySearchHighestIndexRecursion(elementToSearch2, testArray1, 0, testArray1.length - 1) + " Expected: 15");
        System.out.println();
        System.out.println("Binary Search Lowest Index: " + binarySearchLowestIndex( elementToSearch2, testArray1) + " Expected: 12");
        System.out.println("Binary Search Biggest Index: " + binarySearchBiggestIndex(elementToSearch2, testArray1) + " Expected: 15" );
    }

}
