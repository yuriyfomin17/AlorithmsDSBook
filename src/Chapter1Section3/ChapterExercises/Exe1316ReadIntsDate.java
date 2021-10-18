package Chapter1Section3.ChapterExercises;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;

import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;

public class Exe1316ReadIntsDate {
    private static final String  fileName = "/Users/icom/Desktop/AlorithmsDSBook/src/Chapter1Section3/ChapterExercises/Dates.txt";

    static class Queue{
        private int N = 0;
        private int first = 0;
        private int last = 0;
        private Date[] a = new Date[3];

        public void enqueue(Date item ){
            if (N == a.length) resize(a.length * 2);
            a[last++] = item;
            N++;
        }
        public Date dequeue(){
            if (N == a.length / 4) resize(a.length / 4);
            N--;
            return a[first++];
        }
        public void resize(int size){
            Date[] newArr = new Date[size];
            int count = 0;
            for (int i = first; i < last; i++) {
                newArr[count++] = a[i];
            }
            first = 0;
            last = N;
            a = newArr;
        }
        public boolean isEmpty(){ return N == 0;}
        public int size(){ return N;}
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        In in = new In(fileName);
        while (!in.isEmpty()){
            queue.enqueue(new Date(in.readString()));
        }
        Date[] datesArr = new Date[queue.size()];
        int index = 0;
        while (!queue.isEmpty()){
            datesArr[index++] = queue.dequeue();
        }
        for (Date currDate: datesArr) System.out.println(currDate);
    }

}

//    public static int[] readInts(String name)
//    {
//        In in = new In(name);
//        Queue<Integer> q = new Queue<Integer>();
//        while (!in.isEmpty())
//            q.enqueue(in.readInt());
//        int N = q.size();
//        int[] a = new int[N];
//        for (int i = 0; i < N; i++)
//            a[i] = q.dequeue();
//        return a;
//    }
