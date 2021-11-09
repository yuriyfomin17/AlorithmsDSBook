package Chapter1Section4.Exercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exe1411StaticsSETofInts {
    public static void main(String[] args) {
        int[] array = {2, 4, 8, 16, 16, 16, 32, 64, 128, 128};
        StaticSETofInts staticSETofInts = new StaticSETofInts(array);


        StdOut.println("How many 2: "  + staticSETofInts.howMany(2) + " Expected: 1");
        StdOut.println("How many 16: "  + staticSETofInts.howMany(16) + " Expected: 3");
        StdOut.println("How many 128: "  + staticSETofInts.howMany(128) + " Expected: 2");
        StdOut.println("How many -99: "  + staticSETofInts.howMany(-99) + " Expected: 0");
    }
}

class StaticSETofInts {
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i]; // defensive copy
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {  // Binary search.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {  // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int howMany(int key) {
        int lowestIndex = -1;
        int highestIndex = -1;
        int low = 0;
        int high = a.length - 1;
        // find lowest index
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key <= a[mid]) high = mid - 1;
            else if (key > a[mid]) low = mid + 1;
        }
        if (a[high] == key) lowestIndex = high;
        else if (a[high + 1] == key) lowestIndex = high + 1;

        low = 0;
        high = a.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key >= a[mid]) low = mid + 1;
            else if (key < a[mid]) high = mid - 1;
        }
        if (a[low] == key) highestIndex = low;
        else if (low != 0 && a[low - 1] == key) highestIndex = low - 1;

        if (highestIndex == -1 || lowestIndex == -1) return 0;
        else return (highestIndex - lowestIndex + 1);
    }
}
