package Chapter1.CreativeProblems;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exe1126SortingThreeNumbers {
    public static void main(String[] args) {
        int a = 99;
        int b = 5;
        int c = 10;
        int t = 0;

        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }

        StdOut.println("a: " + a);
        StdOut.println("b: " + b);
        StdOut.println("c: " + c);
    }

}
