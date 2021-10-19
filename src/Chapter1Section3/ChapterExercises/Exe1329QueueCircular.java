package Chapter1Section3.ChapterExercises;

public class Exe1329QueueCircular {
    static class Queue{
        private int N = 0;
        private Node last = null;

        public void enqueue(int num){
            if (isEmpty()){
                this.last = new Node();
                this.last.item = num;
                this.last.next = this.last;
            } else {
                Node lastOld = this.last;

                this.last = new Node();
                this.last.item = num;
                this.last.next = lastOld.next;
                lastOld.next = this.last;
            }

            N++;
        }

        public int dequeue(){
            int num = (int) this.last.next.item;
            if (this.last == this.last.next) this.last = null;
            else this.last.next = this.last.next.next;
            N--;
            return num;
        }
        public boolean isEmpty(){ return this.last == null; }
        public int size(){ return N; }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Queue queue = new Queue();
        for (int i = 0; i < numbers.length; i++) queue.enqueue(numbers[i]);
        while (!queue.isEmpty() ) System.out.print(" " + queue.dequeue());

    }
}
