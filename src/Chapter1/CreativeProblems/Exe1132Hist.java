package Chapter1.CreativeProblems;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exe1132Hist {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        StdDraw.setXscale(l-1, r + 1);
        StdDraw.setYscale(0, N);
        formatHistogramGraph(l + ((r-l) / 2), N, l);
        ArrayList<Double> arrayList = new ArrayList<>();
        while (!StdIn.isEmpty()){
            double currValue = StdIn.readDouble();
            arrayList.add(currValue);
        }
        System.out.println(arrayList);
        for (double i = l; i <=r ; i += (r - l) / N) {
            double lowerBound = i;
            double higherBound = i + ((r - l) / N);
            System.out.printf("Lower Bounds %f\n", lowerBound);
            System.out.printf("Higher Bounds %f\n", higherBound);
            List copy = arrayList.stream().filter((aDouble -> aDouble >= lowerBound && aDouble <= higherBound)).collect(Collectors.toList());
            System.out.println(copy);
            int halfHeight = copy.size() / 2;
            StdDraw.filledRectangle(i, 0 , ((r - l) / N) - 0.1, halfHeight);
        }
    }
    public static void formatHistogramGraph(double middleX, double maxY, double minX){
        StdDraw.text(middleX, maxY - maxY * 0.1, "Numbers in intervals");
        StdDraw.text(minX + minX * 0.3, maxY / 2, "Numbers", 90);
    }
}
