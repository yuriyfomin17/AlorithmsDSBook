package Chapter1Section2.ChapterNotes;

import edu.princeton.cs.algs4.StdRandom;

public class Accumulator {
    private int N = 0;
    private double total = 0;

    public Accumulator(){

    }

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean(){
        return  total / N;
    }

    public String toString(){
        return "Mean (" + N + " values): " + String.format("%7.5f", mean());
    }

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        for (int i = 0; i < 500000; i++) {
            accumulator.addDataValue(StdRandom.uniform(0, 500));
        }
        System.out.println(accumulator);
    }
}
