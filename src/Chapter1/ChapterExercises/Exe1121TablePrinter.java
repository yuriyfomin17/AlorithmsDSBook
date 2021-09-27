package Chapter1.ChapterExercises;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Exe1121TablePrinter {
    public static void main(String[] args) {
    }
    public static void exe1121(){ // ✅ checked
        // simple printer program
        // each line contain- ing a name and two integers and then uses printf() to print a table with a column of the names, the integers, and the result of dividing the first by the second, accurate to three decimal places.
        // You could use a program like this to tabulate batting averages for baseball players or grades for students.
        ArrayList<String> info = new ArrayList<>();
        while (!StdIn.isEmpty()){
            String string = StdIn.readLine();
            info.add(string.trim());
        }
        for (String s: info) {
            String[] args = s.split(",");
            String name = args[0];
            Integer num1 = Integer.parseInt(args[1]);
            Integer num2 = Integer.parseInt(args[2]);
            Double num3 = ((double) num1) / ((double) num2);
            System.out.println("----------------------------");
            StdOut.printf("| %s | %d | %d | %f |\n", name, num1, num2 , num3 );
        }
        System.out.println("----------------------------");
    }
}
