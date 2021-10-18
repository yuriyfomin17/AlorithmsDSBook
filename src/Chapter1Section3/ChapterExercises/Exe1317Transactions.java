package Chapter1Section3.ChapterExercises;

import Chapter1Section2.ChapterExercises.Exe211SmartDate;
import Chapter1Section2.ChapterExercises.Exe213Transaction;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;

public class Exe1317Transactions {
    private static final String  fileName = "/Users/icom/Desktop/AlorithmsDSBook/src/Chapter1Section3/ChapterExercises/Transactions.txt";
    static class Queue{
        private int N = 0;
        private int first = 0;
        private int last = 0;
        private Exe213Transaction[] a = new Exe213Transaction[3];

        public void enqueue(Exe213Transaction transaction){
            if (N == a.length) resize(2 * a.length);

            a[last++] = transaction;
            N++;
        }

        public Exe213Transaction dequeue(){
            if (N == a.length / 4) resize(a.length / 2);
            N--;
            return a[first++];
        }

        public int size(){return N;}

        public boolean isEmpty(){
            return  N == 0;
        }

        public void resize(int size){
            Exe213Transaction[] newArr = new Exe213Transaction[size];
            int count = 0;
            for (int i = 0; i < N; i++) newArr[count++] = a[i];

            first = 0;
            last = N;
            a = newArr;
        }
    }
    public static Exe213Transaction[] readAllTransactions(){
        In in = new In(fileName);
        Queue queue = new Queue();
        int count = 0;
        String name = null;
        String dateString = null;
        String amount = null;
        while (!in.isEmpty()) {
            String info = in.readString();
            System.out.println(info);
            if (count == 0) name = info;
            if (count == 1) dateString = info;
            if (count == 2) amount = info;
            count++;
            if (count == 3){
                Exe211SmartDate date = new Exe211SmartDate(dateString);
                queue.enqueue(new Exe213Transaction(name, date, Double.parseDouble(amount)));
                count = 0;
            }
        }
        Exe213Transaction[] transactionsArr = new Exe213Transaction[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) transactionsArr[index++] = queue.dequeue();

        return transactionsArr;
    }
    public static void main(String[] args) {
        Exe213Transaction[] transactions = readAllTransactions();
        for (Exe213Transaction transaction: transactions) System.out.println(transaction);
    }
}
