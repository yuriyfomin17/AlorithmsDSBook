package Chapter1Section3.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe136StackDequeue {
    private static void invertQueue(QueueLinkedList<String> queue) {
        StackArray<String> stack = new StackArray<>();

        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }

        while(!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    }

    public static void main(String[] args) {
        QueueLinkedList<String> queue = new QueueLinkedList<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        invertQueue(queue);

        StdOut.print("Inverted queue: ");
        while (!queue.isEmpty()){
            StdOut.print(queue.dequeue() + " ");
        }

        StdOut.println("\nExpected: 3 2 1");
    }

    static class StackArray<Item>{
        private int N = 0;
        private Item[] a;

        public StackArray(){
            a = (Item[]) new Object[5];
        }

        public boolean isEmpty(){
            return N == 0;
        }

        public Item peek(){
            return a[a.length - 1];
        }
        public void push(Item elem){
            if (N > 0 && N == a.length ) resize(a.length * 2);
            a[N++] = elem;
        }
        public Item pop(){
            Item item = a[--N];
            a[N] = null; // loitering
            if (N > 0 && N == a.length / 4) resize(a.length / 2);
            return item;
        }

        public void resize(int size){
            Item[] newArr = (Item[]) new Object[size];
            for (int i = 0; i < N; i++) {
                newArr[i] = a[i];
            }
            a = newArr;
        }
    }

    static class QueueLinkedList<Item>{
        private Node first = null;
        private Node last = null;
        private int N = 0;

        public void enqueue(Item item){
            Node oldLast = last;
            this.last = new Node();
            last.item = item;
            last.next = null;

            if (isEmpty()) first = last;
            else oldLast.next = last;
            N++;
        }
        public Item dequeue(){
            Item item = (Item) first.item;
            first = first.next;
            if (isEmpty()) last = null;
            N--;
            return item;
        }

        public int size() { return N; }

        public boolean isEmpty(){ return  first == null;}
    }

    static class StackLinkedList<Item>{
        private int N = 0;
        private Node first = null;

        public StackLinkedList(){

        }
        public void push(Item item){
            Node oldFirst = first;

            this.first = new Node();
            this.first.item = item;
            this.first.next = null;

            this.first.next = oldFirst;
            N++;
        }
        public Item pop(){
            Item item = (Item) this.first.item;
            this.first = first.next;
            N--;
            return item;
        }
        public boolean isEmpty(){ return first == null;}
    }
}
