package Chapter1Section4.ChapterNotes;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class ThreeSum {
    public static int count(int[] a){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) count++;
                }
            }
        }
        return count;
    }
    public static int countFast(int[] a){
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++){
            for (int j = i + 1; j < a.length; j++) {
                if (binarySearch(-a[i] - a[j], a) != -1) count++;
            }
        }
        return count;
    }
    static int binarySearch(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (key < a[mid]) high = mid - 1;
            else if (key > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 1000000;
        for (int i = 100; i <= n ; i*=2) executionAnalysis(i);
    }
    /**
     * Doubling ratio experiment is really useful technique to determine the order of growth.
     * So, double the input size every time and look at the time of execution. Run until ratio
     * approaches 2^b limit.
     *
     * E.g.running sum of three for doubling input, I have noticed that
     * each time time of execution increases but not by constant multiple. However, when reaching
     * N of 4000 and 8000 and so on, we reach the limit and the time execution each time multiplies by
     * 8.
     *
     * As a rule of thumb if you double the input size of data. then time of execution will multiply
     * each time by 2^b
     *
     *
     * Proposition if for fast three sum T(N) = a*N^b * lg(N) then T(2N)/ T(N) => 2^b
     * since T(2N) / T(N) = a * (2N)^b * lg(2N) / (a*N^b * lg(N)) = 2^b * (lg(2N) / lg(N))
     * = 2^b * (1 + lg(2)/lg(N))  = approx 2^b
     */

    public static void executionAnalysis(int n ){
        int max = 1000000;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = StdRandom.uniform(-max, max);
        StopWatch stopWatch = new StopWatch();
        System.out.println("Three Sum count: " + countFast(numbers));
        System.out.printf("Elapsed Time: %5.6f seconds\n", stopWatch.elapsedTime());
        System.out.println("N: " + n);
    }
}
