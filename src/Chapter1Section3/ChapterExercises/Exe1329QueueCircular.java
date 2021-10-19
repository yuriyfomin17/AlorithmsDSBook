package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

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
            // if the last element is the same as first one, simply set the last to null which automatically sets the
            // the first element to null
            if (this.last == this.last.next) this.last = null;
            // this.last.next is the fist element. Hence, this.first = this.first.next => this.last.next = this.last.next.next;
            else this.last.next = this.last.next.next;
            N--;
            return num;
        }
        public boolean isEmpty(){ return this.last == null; }
        public int size(){ return N; }

        private class QueueIterator implements Iterator<Integer>{
            private Node current = last.next;
            // keep track that it is beginning of the iteration hence condition current != last.next can be avoided
            private boolean start = true;
            @Override
            public boolean hasNext() {
                // since there is no null links. Hence, eventually current will go to first
                return last != null && (start || current != last.next);
            }

            @Override
            public Integer next() {
                if (start) start = false;
                Integer num = (Integer) current.item;
                current = current.next;
                return num;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Queue queue = new Queue();
        for (int i = 0; i < numbers.length; i++) queue.enqueue(numbers[i]);
//        while (!queue.isEmpty() ) System.out.print(" " + queue.dequeue());

        // iterator
        Queue.QueueIterator queueIterator = queue.new QueueIterator();
        while (queueIterator.hasNext()) {
            System.out.print(" " + queueIterator.next());

        }

    }
}
