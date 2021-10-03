package Chapter1Section2.ChapterNotes;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class infoFromMultipleFiles {
    // This program will read info from files located in current directory and will put that info into the out.txt
    // if file doesn't exist then it will try to set up the web connection and will read out the info in web
    public static void main(String[] args)
    {  // Copy input files to out (last argument).
        Out out = new Out(args[args.length-1]);
        for (int i = 0; i < args.length - 1; i++)
        {  // Copy input file named on ith arg to out.
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }
}
