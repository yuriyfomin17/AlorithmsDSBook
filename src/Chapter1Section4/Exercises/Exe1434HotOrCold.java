package Chapter1Section4.Exercises;

public class Exe1434HotOrCold {
    public static int binarySearchHotOrCold(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        boolean firstGuess = true;
        while (low <= high){
            int guess = low + (high - low) / 2;
            int secondGuess = guess + 1;

            if (firstGuess && target < arr[secondGuess]) {
                high = guess - 1;
                firstGuess = false;
            } else if (firstGuess && target > arr[secondGuess]){
                low = guess + 1;
                firstGuess = false;
            } else if (target < arr[guess]) high = guess - 1;
            else if (target > arr[guess]) low = guess + 1;
        }
        return -1;
    }
}
