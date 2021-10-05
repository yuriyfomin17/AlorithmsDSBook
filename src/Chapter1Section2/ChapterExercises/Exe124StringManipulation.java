package Chapter1Section2.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe124StringManipulation {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = new String(string1);
        string1 = new String("world");
        StdOut.println(string1  + ": world expected");
        StdOut.println(string2 + ": hello expected");
    }
}
