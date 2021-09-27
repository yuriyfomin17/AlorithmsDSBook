package Chapter1.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe116 {
    public static void main(String[] args) {
        exe116();
    }

    static public void exe116() { //  ✅ checked -> fibonacci sequence
        long f = 0;
        long g = 1;
        for (int i = 0; i < 100; i++) {
            StdOut.println(i + " " + f);
            f = f + g;
            g = f - g;
        }
    }
}
