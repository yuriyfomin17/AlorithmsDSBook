package Chapter2.Section1.ChapterNotes;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Insertion;

import java.util.Arrays;
import java.util.function.Consumer;

public class SortingAlgorithms {


    private static void getAlgorithmTime(Consumer<Double[]> consumer, int N, int numExperiments, String algoName) {
        Double[] arr = new Double[N];
        double totalTime = 0;
        for (int k = 0; k < numExperiments; k++) {
            for (int i = 0; i < N; i++) {
                arr[i] = StdRandom.uniformDouble();
            }
            long startTime = System.currentTimeMillis();
            consumer.accept(arr);
            totalTime += System.currentTimeMillis() - startTime;
        }
        System.out.printf("%s average sorting time: %.4f millis \n", algoName, totalTime / numExperiments);

    }

    public static void sort(Comparable[] a) {
        MergeSort.sort(a);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 2, 4, 1, 2, 6, 10, -1};
        System.out.println("Before Sorting:" + Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
//        getAlgorithmTime(SelectionSort::sort,10000, 100, "SELECTION_SORT");
//        getAlgorithmTime(InsertionSort::sort,10000, 100, "INSERTION_SORT");
//        getAlgorithmTime(ShellSort::sort,10000, 100, "SHELL_SORT");

//        assert isSorted(a);
//        show(a);
    }

    /**
     * Selection Sort
     * Uses approx N^2 / 2 compares and N exchanges to sort and array of length N
     * <p>
     * <p>
     * properties
     * <p>
     * 1. Running time is insensitive to input - it takes to run sorted array as much time as
     * unsorted array
     * <p>
     * 2. Data movement is minimal - selection sort uses N exchanges -> number of array accesses is a linear function of
     * array size.
     */
    static class SelectionSort {
        public static void sort(Comparable[] a) {
            int N = a.length;

            for (int i = 0; i < N; i++) {
                int minIdx = i;
                for (int j = i + 1; j < N; j++) {
                    if (less(a[j], a[minIdx])) minIdx = j;
                }
                exch(a, i, minIdx);
            }
        }

        public static String getName() {
            return "SELECTION_SORT";
        }
    }

    /**
     * Insertion Sort
     * Uses approx N^2 / 4 and compare approx N^2/4 to sort a randomly ordered array of length N
     * with distinct keys, on the average.
     * <p>
     * <p>
     * The worst case is N^2 / 2 compares and N^2 / 2 exchanges and best case is N - 1 compares and 0 exchanges
     * <p>
     * properties
     * 1. It works well on the arrays that are already sorted or partially sorted. Each item is immediately determined to be in its
     * proper place in the array and the total running time is linear.
     * <p>
     * Partially sorted arrays are
     * <p>
     * 1. An array where each entry is not far from its final position
     * <p>
     * 2. A small array appended to a large sorted array
     * <p>
     * 3. An array with only a few entries that are not in place.
     *
     * <p>
     * Insertion sort is quicker then Selection sort by 1.6 times
     */

    static class InsertionSort {
        public static void sort(Comparable[] a) {
            int N = a.length;

            for (int i = 1; i < N; i++) {
                int idx = i;
                while (idx > 0 && less(a[idx], a[idx - 1])) {
                    exch(a, idx, idx - 1);
                    idx -= 1;
                }

            }
        }

        public static String getName() {
            return "SELECTION_SORT";
        }

    }

    /**
     * ShellSort is generally much faster then Insertion Sort and Selection sort. It uses approx N^3/2
     * <p>
     * ShellSort is quicker the InsertionSort by 600 times according to researches
     */

    static class ShellSort {
        public static void sort(Comparable[] a) {
            int N = a.length;
            int h = 1;

            while (h < N / 3) h = h * 3 + 1;
            while (h >= 1) {
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                        exch(a, j, j - h);
                    }

                }
                h = h / 3;
            }
        }
    }

    static class MergeSort{
        private static Comparable[] aux;
        public static void merge(Comparable[] a, int low, int mid, int high){
            int i = low, j = mid + 1;
            for (int k = low; k <= high ; k++) {
                aux[k] = a[k];
            }
            for (int k = low; k <= high ; k++) {
                if (i > mid) a[k] = aux[j ++];
                else if (j > high) a[k] = aux[i++];
                else if (less(aux[j], aux[i] )) a[k] = aux[j++];
                else a[k] = aux[i++];
            }

        }
        private static void sort(Comparable[] a){
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }
        private static void sort(Comparable[] a, int low, int high){
            if (high <= low) return;
            int mid = low  + (high - low) / 2;
            sort(a, low, mid);
            sort(a,mid + 1, high);
            merge(a, low, mid, high);
        }
    }

}
