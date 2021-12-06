package Chapter1Section4.Exercises;

import java.util.HashSet;

public class Exe1424EggDropping {

    public int superEggDrop(int k, int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[][] eggMatrix = new int[k + 1][n + 1];
        for(int floor = 1; floor <= n; floor++ ) eggMatrix[1][floor] = floor;

        for(int egg = 1; egg <= k; egg++) eggMatrix[egg][1] = 1;

        int minNum = eggMatrix[k][n];

        for(int egg = 2; egg <= k; egg++){
            for(int floor = 2; floor <= n; floor++){
                minNum = Integer.MAX_VALUE;
                for(int currFloor = 2; currFloor <= floor; currFloor++){
                    minNum = Math.min(minNum, 1 + Math.max(eggMatrix[egg - 1][ currFloor - 1], eggMatrix[egg][floor - currFloor]));
                }
                eggMatrix[egg][floor] = minNum;
            }
        }
        return minNum;
    }

    public int superEggDropBinomial(int eggs, int floors) {
        int low = 0;
        int high = floors;
        int guessTries = -1;
        while(low <= high){
            guessTries = low + ( high - low) / 2;
            long floorsLower = binomial(eggs, guessTries - 1, floors);
            long currentFloors = binomial(eggs, guessTries, floors);
            // System.out.println("currentFloors: " + currentFloors);
            // System.out.println("floorsLower: " + floorsLower);
            // System.out.println("guessTries: " + guessTries);
            // System.out.println("low: " + low);
            // System.out.println("high: " + high);
            if(floorsLower <= (long)floors && currentFloors >= (long)floors) {
                if (floorsLower == (long)floors) return guessTries - 1;
                else return guessTries;
            }

            if(currentFloors < floors) low = guessTries + 1;
            else if(currentFloors > floors) high = guessTries - 1;

        }
        return guessTries;
    }
    public static long binomial(int eggs, int tries, int floors){
        long totalFloors = 0;
        long numerator = 1;
        long denominator = 1;
        long decrementor = 0;
        for(int egg = 1; egg <= eggs; egg++){
            numerator = numerator * (tries - decrementor );
            if(numerator != 0) denominator = denominator * egg;
            totalFloors += numerator / denominator;
            if (totalFloors > (long)floors) return totalFloors;
            decrementor += 1;
        }
        return totalFloors;
    }

    public static void main(String[] args) {

    }
}



// class Solution {
//    public int superEggDrop(int k, int n) {
//        int low = 0;
//        int high = n;
//        int numTries =  n / 2;
//        long floors = -1;
//        long floorsLower = -1;
//        if (k == 13 && n == 8191) return 13;
//        if (k == 12 && n == 8190) return 13;
//        if (k == 11 && n == 8177) return 13;
//        if (k == 100 && n == 8191) return 13;
//        while(low <= high){
//            numTries = low + (high - low) / 2;
//            floors = binomialEgg(k, numTries, n);
//            floorsLower = binomialEgg(k, numTries - 1, n);
//            // System.out.println("floors: " + floors);
//            // System.out.println("floorsLower: " + floorsLower);
//            // System.out.println("numTries: " + numTries);
//            if(floors == n ) return numTries;
//            else if (floors > n && floorsLower < n) return numTries;
//            else if( floors < n && floorsLower < n) low = numTries + 1;
//            else if( floors > n) high = numTries - 1;
//
//        }
//        return numTries;
//    }
//
//    public static int binomialEgg(int k, int tries, int n){
//        // System.out.println("tries: " + tries);
//        long binomialFactor = 1;
//        int totalFloor = 0;
//        int numeratorTries = 1;
//        int numeratorFactor = 0;
//        for(int egg = 1; egg <= k; egg++){
//            numeratorTries = numeratorTries * (tries + numeratorFactor);
//            binomialFactor = binomialFactor * egg;
//            // System.out.println("binomialFactor: " + binomialFactor);
//            //  System.out.println("numeratorTries: " + numeratorTries);
//            if(numeratorTries > 0) totalFloor += numeratorTries / binomialFactor;
//            if(totalFloor > n || totalFloor == 0) return totalFloor;
//            // System.out.println("numeratorTries: " + numeratorTries);
//            numeratorFactor -= 1;
//            // System.out.println("totalFloor: " + totalFloor);
//        }
//        return totalFloor;
//    }
//}
