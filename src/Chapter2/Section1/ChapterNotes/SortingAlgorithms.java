package Chapter2.Section1.ChapterNotes;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class SortingAlgorithms {
    public static void sort(Comparable[] a) {
        SelectionSort.sort(a);
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
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
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
     *<p>
     * Insertion sort is quicker then Selection sort by 1.6 times
     */

    static class InsertionSort {
        public static void sort(Comparable[] a) {
            int N = a.length;

            for (int i = 1; i < N; i++) {
                for (int j = i; j > 0 && less(a[j], a[j - 1]); j++) {
                    exch(a, j, j - 1);
                }
            }
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
            while (h < N / 3) h = 3 * h + 1;
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

}
