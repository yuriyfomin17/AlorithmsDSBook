package Chapter1Section2.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

// here we calculate sample standard deviation which means our N is not fixed,
// it depends on the sample and it has greater variability. it is statistics

// Simple standard deviation of the sample is a paramter, which is a fixed value calculated from every
// individual in the population
public class Exe218VarianceAccumulator {
    private double m;
    private double s;
    private int N;

    public void addDataValue(double x){
        N++;
        // running sample standard deviation  formula
        s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
        m = m + (x - m) / N;
    }

    public double mean(){
        return m;
    }
    public double var(){
        return  s / (N - 1);
    }
    public double stddev(){
        return Math.sqrt(this.var());
    }

    public static void main(String[] args) {
        Exe218VarianceAccumulator exe218VarianceAccumulator = new Exe218VarianceAccumulator();
        int[] valuesSet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < valuesSet.length; i++) {
            exe218VarianceAccumulator.addDataValue(valuesSet[i]);
        }
        System.out.println(exe218VarianceAccumulator.mean() + ": expected mean 5.5");
        System.out.println(exe218VarianceAccumulator.var() + ": expected variance 9.166666666666666");
        System.out.println(exe218VarianceAccumulator.stddev() + ": expected standard deviation 3.0276503540975");

        //Code validation
        Exe218VarianceAccumulator validation = new Exe218VarianceAccumulator();
        validation.addDataValue(2);
        validation.addDataValue(4);
        validation.addDataValue(5);

        StdOut.println("Mean: " + validation.mean() + " Expected: 3.6666666666666665");
        StdOut.println("Variance: " + validation.var() + " Expected:  2.333333333333333");
        StdOut.println("Standard Deviation: " + validation.stddev() + " Expected: 1.5275252316519465");
    }
}
