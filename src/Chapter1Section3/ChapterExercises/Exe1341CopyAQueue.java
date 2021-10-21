package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1341CopyAQueue {
    static class Queue<Item>{
        private int size = 0;
        private Node first = null;
        private Node last = null;


        public Queue(Queue queue){
            Queue newQueue = copyQueue(queue);
            this.first = newQueue.getFirst();
            this.last = newQueue.getLast();
            this.size = newQueue.getSize();
        }
        public Queue(){

        }

        public void enqueue(Node num){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = num;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            size++;
        }
        public Item dequeue(){
            if (isEmpty()) return null;
            Item item = (Item)this.first.item;
            this.first = this.first.next;
            size--;
            return item;
        }
        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return size; }

        public String toString(){
            String result = "";
            QueueIterator queueIterator = new QueueIterator();

            while (queueIterator.hasNext()) result+= " " + queueIterator.next();
            return result;
        }

        private class QueueIterator implements Iterator<Node>{
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Node next() {
                Node item = current;
                current = current.next;
                return  item;
            }
        }

        public int getSize() {
            return size;
        }

        public Node getFirst() {
            return first;
        }

        public Node getLast() {
            return last;
        }
    }
    public static void main(String[] args) {
        Queue queue1 = new Queue();
        queue1.enqueue(new Node(1));
        queue1.enqueue(new Node(2));
        queue1.enqueue(new Node(3));
        queue1.enqueue(new Node(4));

        Queue queueCopy = new Queue(queue1);
        queueCopy.enqueue(new Node(5));
        queueCopy.enqueue(new Node(99));

        queue1.dequeue();

        queueCopy.dequeue();
        queueCopy.dequeue();

        System.out.println("Queue1: " + queue1);
        System.out.println("Expected: 2 3 4");
        System.out.println();

        System.out.println("Queue Copy: " + queueCopy);
        System.out.println("Expected: 3 4 5 99");

    }

    public static Queue copyQueue(Queue queue){
        Node[] nodes = new Node[queue.size];
        int index = 0;
        Queue copyQueue = new Queue();
        while (!queue.isEmpty()){
            nodes[index++] = (Node) queue.dequeue();
        }
        for (int i = 0; i < nodes.length; i++) {
            queue.enqueue(nodes[i]);
            copyQueue.enqueue(nodes[i]);
        }
        return copyQueue;
    }
}
