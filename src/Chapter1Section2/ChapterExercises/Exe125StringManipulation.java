package Chapter1Section2.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe125StringManipulation {
    public static void main(String[] args) {
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s);
        System.out.println(s + ": Hello World expected");
        // string should be reassigned
    }
}
