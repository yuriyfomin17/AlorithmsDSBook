package Chapter1Section2.ChapterExercises;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;

public class Exe122Interval1DIntersect {
    public static void main(String[] args) {
        int N = 50;
        Interval1D[] array = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            if (x < y) array[i] = new Interval1D(x, y);
            else if (y < x) array[i] = new Interval1D(y, x);
        }
        // if interval intersect print it out
        for (int i = 0; i < array.length; i++) {
            Interval1D currInterval = array[i];
            for (int j = 0; j < array.length; j++) {
                if (currInterval.intersects(array[j])){
                    System.out.println("First interval" + array[j]);
                    System.out.println("Second interval" + array[i]);
                }
            }
        }
    }
}
