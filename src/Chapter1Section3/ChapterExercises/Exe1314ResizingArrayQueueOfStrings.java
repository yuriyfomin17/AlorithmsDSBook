package Chapter1Section3.ChapterExercises;

public class Exe1314ResizingArrayQueueOfStrings {

    static class Queue{
        private int N = 0;
        private int first = 0;
        private int last = 0;
        private String[] a;

        public Queue(){
            a = new String[3];
        }
        public void enqueue(String s){
            a[last++] = s;
            N++;
            if (N == a.length) resize(a.length * 2);
        }
        public String dequeue(){
            if (N == a.length / 4) resize( a.length / 2);
            if (isEmpty()) return "";
            N--;
            return a[first++];
        }

        public void resize(int newSize){
            String[] newArr = new String[newSize];
            int count = 0;
            for (int i = first; i < last; i++) newArr[count++] = a[i];
            this.first = 0;
            this.last = N;
            a = newArr;
        }
        public boolean isEmpty(){ return N == 0;}
        public int size(){ return N;}
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < numbers.length; i++) {
            queue.enqueue(numbers[i]);
        }
        while (!queue.isEmpty()) System.out.println(queue.dequeue());
    }

}
