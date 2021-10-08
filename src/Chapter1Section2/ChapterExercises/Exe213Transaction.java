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

    @Override public boolean equals(Object aTransaction){
        if (aTransaction == this) return true;
        if (aTransaction == null) return false;

        if (getClass() != aTransaction.getClass()){
            return false;
        }
        Exe213Transaction exe213Transaction = (Exe213Transaction) aTransaction;
        return this.who.equals(exe213Transaction.who) && this.amount == exe213Transaction.amount && this.when.equals(exe213Transaction.when);
    }

    @Override public final int hashCode(){
        int result = 17;
        return (int) (31 * result + this.who.hashCode() + this.amount);

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
        Exe213Transaction transaction1 = new Exe213Transaction("Rene", date, 500);
        System.out.println(transaction.equals(transaction1));
        System.out.println(transaction.hashCode());
        System.out.println(transaction1.hashCode());
        StdOut.println(transaction);
        StdOut.println("Expected: Rene spent 500.0 on 8/3/2016");
    }
}
