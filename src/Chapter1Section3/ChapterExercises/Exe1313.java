package Chapter1Section3.ChapterExercises;

public class Exe1313 {
    static class Queue{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void enqueue(String s){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = s;
            this.last.next = null;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }
        public String dequeue(){
            if (isEmpty()) return null;
            String item = (String) this.first.item;
            this.first = this.first.next;
            N--;
            return item;
        }
        public boolean isEmpty(){
            return this.first == null;
        }
    }
    public static void main(String[] args) {
        // a ✅
        // 0 1 2 3 4 5 6 7 8 9
        // enqueue => 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 => [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // dequeue => 0, 1, 2, 3 ,4, 5, 6, 7, 8, 9

        Queue queue = new Queue();
//        queue.enqueue("0");
//        queue.enqueue("1");
//        queue.enqueue("2");
//        queue.enqueue("3");
//        queue.enqueue("4");
//        queue.enqueue("5");
//        queue.enqueue("6");
//        queue.enqueue("7");
//        queue.enqueue("8");
//        queue.enqueue("9");
//        while (!queue.isEmpty()) System.out.println(queue.dequeue());


        // b ❌
        // 4 6 8 7 5 3 2 9 0 1

        queue.enqueue("0");
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        System.out.println(queue.dequeue());
        queue.enqueue("5");
        queue.enqueue("6");
        System.out.println(queue.dequeue());
        queue.enqueue("7");
        queue.enqueue("8");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }

        // c ❌
        // 2 5 6 7 4 8 9 3 1 0

        // d ❌
        // 4 3 2 1 0 5 6 7 8 9
    }
}
