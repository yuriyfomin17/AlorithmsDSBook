package Chapter1.CreativeProblems;

import edu.princeton.cs.algs4.StdOut;

public class Exe1130ArrayExercise {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = isCoprime(i, j);
            }
        }
        printArray(arr);
    }
    public static boolean isCoprime(int num1 , int num2){
        if (num1 == num2 &&  num1 != 1){
            return false;
        }
//        The only integers which are coprime to zero are 1 and −1
        if (num1 == 0 || num2 == 0){
            return handleZero(num1, num2);
        }

        return euclidGreatestCommonFactor(num1, num2) == 1;
    }
    public static boolean handleZero(int num1 , int num2){
        return (num1 == 0 && num2 == 1) || (num1 == 0 && num2 == -1) || (num2 == 1 && num1 == 0) || (num2 == -1 && num1 == 0);
    }
    public static int euclidGreatestCommonFactor(int numerator, int denominator){
        if (numerator % denominator == 0) return denominator;
        int remainder = numerator % denominator;
        return euclidGreatestCommonFactor(denominator, remainder);
    }
    public static void printArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                StdOut.printf("%6b", array[i][j]);
            }
            StdOut.println();
        }
    }
}
