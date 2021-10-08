package Chapter1Section2.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe213Transaction {
    private final String who;
    private final Exe211SmartDate when;
    private final double amount;

    public Exe213Transaction(String who, Exe211SmartDate when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String who() {
        return who;
    }

    public Exe211SmartDate when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    public String toString() {
        return who() + " spent " + amount() + " on " + when();
    }

    public static void main (String[] args) {
        Exe211SmartDate date = new Exe211SmartDate(8, 3, 2016);
        System.out.println(Exe211SmartDate.getDayOfWeek(date));
        Exe213Transaction transaction = new Exe213Transaction ("Rene", date, 500);
        StdOut.println(transaction);
        StdOut.println("Expected: Rene spent 500.0 on 8/3/2016");
    }
}
