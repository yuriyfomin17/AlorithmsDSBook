package Chapter1.CreativeProblems;

public class Ex1129EqualKeys {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10};
        int target = 67;
        int numElementsSmallerTarget = numElementsBiggerThenTarget(target, arr, 0, arr.length -1);
        int count = numOfSameElements(target, arr);
        System.out.println(numElementsSmallerTarget);
        System.out.println(count);
    }
    public static int numElementsSmallerThenTarget(int target, int[]arr, int low, int high){
        if (low <= high){
            int mid = low + (high - low) / 2;
            if (target > arr[mid]) return numElementsSmallerThenTarget(target, arr, mid + 1, high);
            else return numElementsSmallerThenTarget(target, arr, low, mid - 1);
        }
        return low;
    }

    public static int numElementsBiggerThenTarget(int target, int[] arr, int low, int high){
        if (low <= high){
            int mid = low + (high - low) / 2;
            if (target < arr[mid]) return numElementsBiggerThenTarget(target, arr, low, mid -1);
            else return numElementsBiggerThenTarget(target, arr, mid + 1, high);
        }
        return arr.length - high - 1 ;
    }
    public static int numOfSameElements(int target, int[] arr){
        int numElemSmaller = numElementsSmallerThenTarget(target, arr, 0, arr.length -1);
        int numElemBigger = numElementsBiggerThenTarget(target, arr, 0, arr.length - 1);
        return arr.length - numElemSmaller - numElemBigger;
    }
    
}
