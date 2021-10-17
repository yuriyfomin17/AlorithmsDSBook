package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1315QueueCommandLine {
    static class Queue{
        private int N = 0;
        private String[] a = new String[3];
        private int first = 0;
        private int last = 0;


        public void enqueue(String s){
            a[last++] = s;
            N++;
            if (last == a.length) resize(2 * a.length);
        }
        public String dequeue(){
            if (isEmpty()) return "";
            N--;
            return a[first++];
        }
        public void resize(int newSize){
            String[] newArr = new String[newSize];
            for (int i = 0; i < N; i++) newArr[i] = a[i];
            first = 0;
            last = N;
            a = newArr;
        }
        public boolean isEmpty(){ return N == 0; }

        public int size(){ return N; }

        private class QueueIterator implements Iterator<String>{
            private int current = first;
            @Override
            public boolean hasNext() {
                return current != last;
            }

            @Override
            public String next() {
                return a[current++];
            }
        }
    }
    public static void printKthFromLastElement(){

    }

    public static void main(String[] args) {
        int K = 4;
        Queue queue  = new Queue();
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        Queue.QueueIterator queueIterator = queue.new QueueIterator();
        for (int i = 0; i < numbers.length; i++) {
            queue.enqueue(numbers[i]);
        }
        int count = 0;
        while (queueIterator.hasNext()){
            String s = queueIterator.next();
            if (count == queue.size() - K) System.out.println(s);
            count += 1;

        }
    }
}
