package Chapter1Section2.ChapterNotes;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class VisualAccumulator extends Accumulator {
    public double total;
    public int N;
    public VisualAccumulator(int trials, double max)
    {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }
    public void addDataValue(double val)
    {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, total/N);
    }
    public static void main(String[] args)
    {
        int trials = 500;
        VisualAccumulator a = new VisualAccumulator(trials, 1.0);
        for (int t = 0; t < trials; t++){
            double ranVal = StdRandom.random();
            a.addDataValue(ranVal);
        }

        System.out.println(a.total);
        System.out.println(a.N);
    }
}
