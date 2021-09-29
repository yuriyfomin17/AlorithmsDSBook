package Chapter1.CreativeProblems;

import edu.princeton.cs.algs4.StdIn;

import java.util.*;

public class Exe1134Filtering {
    public static void main(String[] args) {

    }
//  Print the maximum and minimum numbers -> Could be implemented as a filter
    public static void maxMin(){
        double minNum = Double.MAX_VALUE;
        double maxNum = Double.MIN_VALUE;
        while (!StdIn.isEmpty()){
            double number = StdIn.readDouble();
            if (number > maxNum) maxNum = number;
            if (number < minNum) minNum = number;
        }
        System.out.printf("Maximum Number is %f", maxNum);
        System.out.printf("Minimum Number is %f", minNum);
    }
//    Print the median of the numbers -> Requires saving all values
    public static void medianNumber(int N){
        ArrayList<Double> arrayList = new ArrayList<>();
        while (!StdIn.isEmpty()){
            double num = StdIn.readDouble();
            arrayList.add(num);
        }
        arrayList.sort(Double::compareTo);
        if (arrayList.size() % 2 == 0) {
            int low = (arrayList.size() / 2) - 1;
            int high = (arrayList.size() / 2) + 1;
            double result = (arrayList.get(low - 1) + arrayList.get(high -1)) / 2;
            System.out.printf("Median is %f", result);
        }
        if (arrayList.size() % 2 != 0){
            int mid = (arrayList.size() / 2) - 1;
            double result = arrayList.get(mid +1);
            System.out.printf("Median is %f", result);
        }
    }
//    Print the Kth smallest value, for K less than 100 -> Could be implemented as a filter with an array of size K
    public static void findKSmallerThen100(int K){
        double[] result = new double[K];
        result[0] = Double.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            while (!StdIn.isEmpty()){
                double num = StdIn.readDouble();
                if (result[i] > num){
                    result[i] = num;
                }
            }
        }
        System.out.printf("Kth smallest values is %f", result[result.length -1]);

    }
 //    Print the sum of the squares of the numbers -> Could be implemented as a filter
    public static void sumOfSquares(){
        double sumOfSquare = 0;
        while (!StdIn.isEmpty()){
            double number = StdIn.readDouble();
            sumOfSquare += number * number;
        }
        System.out.printf("Sum of squares %f", sumOfSquare);
    }
 // Print the average of the N numbers -> Could be implemented as a filter
    public static double averageNumbers(int N){
        double averageNum = 0;
        while (!StdIn.isEmpty()){
            double number = StdIn.readDouble();
            averageNum += number;
        }
        averageNum /= N;
        System.out.printf("Average of N numbers %f", averageNum);
        return averageNum;
    }
//    Print the percentage of numbers greater than the average -> can be made as a filter
    public static void percentGreaterThenAverage(int N){
        double avg = averageNumbers(N);
        double count = 0;
        while (!StdIn.isEmpty()){
            double number = StdIn.readDouble();
            if (number > avg) count += 1;
        }
        double percent = count / N;
        System.out.printf("Percent of Numbers Greater then Average %.2f", percent);
    }
    // Print the N numbers in increasing order -> Requires saving all values
    public static void numbersAsc(int N){
        double[] result = new double[N];
        int count = 0;
        while (!StdIn.isEmpty()){
            double number = StdIn.readDouble();
            result[count] = number;
        }
        Arrays.sort(result);
        for (double num : result){
            System.out.println(num);
        }
    }
    // Print the N numbers in random order -> Requires saving all values
    public static void numbersRandomly(int N){
        Double[] result = new Double[N];
        int count = 0;
        while (!StdIn.isEmpty()){
            double number = StdIn.readDouble();
            result[count] = number;
        }
        Comparator<Double> comparator = (o1, o2) -> {
            double result1 = Math.random();
            return Double.compare(result1, 0.5);
        };
        Arrays.sort(result, comparator);
        for (Double num: result){
            System.out.println(num);
        }
    }
}
