package Chapter1Section4.Exercises;

import java.util.Iterator;

public class Exe1428StackWithQueue {

    static class Queue<Item> {
        Node first = null;
        Node last = null;
        int N = 0;

        public void enqueue(Item item) {
            Node newLast = new Node(item);
            if (isEmpty()) this.first = this.last = newLast;
            else {
                this.last.next = newLast;
                this.last = this.last.next;
            }
            N++;
        }

        public Item dequeue() {
            if (isEmpty()) return null;
            Item item = (Item) this.first.item;
            this.first = this.first.next;
            N--;
            return item;
        }

        public int size() {
            return N;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        @Override
        public String toString() {
            String result = "";
            QueueIterator queueIterator = new Queue.QueueIterator();
            while (queueIterator.hasNext()) result += " " +  queueIterator.next();
            return result;
        }

        private class QueueIterator implements Iterator<Item> {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = (Item) current.item;
                current = current.next;
                return item;
            }
        }

    }
    static class Node<Item> {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
            this.next = null;

        }
    }
    static class Stack<Item>{
        Queue queue = new Queue();

        public void push(Item item){
            this.queue.enqueue(item);
        }
        public Item pop(){
            int size = queue.size();
            int count = 1;
            while (count < size){
                Item item = (Item) queue.dequeue();
                queue.enqueue(item);
                count++;
            }
            return (Item) queue.dequeue();
        }
        @Override
        public String toString(){
            return queue.toString();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Stack stack = new Stack();
        for (int num: arr)  stack.push(num);
        System.out.println(stack + " expected: 1 2 3 4 5 6 7 8 9 10"); // note this is in reverse order since we use toString of the Queue
        stack.pop();
        System.out.println(stack + " expected: 1 2 3 4 5 6 7 8 9");
        stack.pop();
        System.out.println(stack + " expected: 1 2 3 4 5 6 7 8");
        stack.pop();
        System.out.println(stack + " expected: 1 2 3 4 5 6 7");
        stack.push(11);
        stack.push(12);
        System.out.println(stack + " expected: 1 2 3 4 5 6 7 11 12");

    }

}
