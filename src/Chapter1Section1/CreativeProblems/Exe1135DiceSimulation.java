package Chapter1Section1.CreativeProblems;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exe1135DiceSimulation {
    public static void main(String[] args) {
        double[] distExact = simulateDice();
        double[] distExperiment = experimentDice();
        StdOut.println("Exact:");
        for (int i = 2; i < distExact.length; i++) {
            StdOut.printf("%5.3f ", distExact[i]);
        }
        StdOut.println();

        StdOut.println("Experiment:");
        for (int i = 2; i < distExperiment.length; i++) {
            StdOut.printf("%5.3f ", distExperiment[i]);
        }
    }
    //N has to be 6.000.000 before my empirical results match the exact results to three decimal places.

    public static double[] simulateDice(){
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++){
                dist[i+j] += 1.0;
            }
        }
        for (int k = 2; k <= 2 * SIDES; k++){
            dist[k] /= 36.0;
        }
        return dist;
    }
    public static double[] experimentDice(){
        int SIDES = 6;
        int n = 6000000;
        double[] result = new double[2 * SIDES +1];
        for (int i = 1; i < n ; i++) {
            int num1 = StdRandom.uniform(1,7);
            int num2 = StdRandom.uniform(1, 7);
            result[num1 + num2] += 1;
        }
        for (int k = 2; k <= 2 * SIDES; k++) {
            result[k] /= n;
        }
        return result;
    }
}
