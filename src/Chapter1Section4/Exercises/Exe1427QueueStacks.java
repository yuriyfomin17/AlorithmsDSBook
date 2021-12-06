package Chapter1Section4.Exercises;


import java.util.Iterator;

public class Exe1427QueueStacks {
    public static void main(String[] args) {
//        checkQueue();
//        checkStack();
        checkQueueWithTwoStacks();
    }

    static void checkQueue() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Queue queue = new Queue();
        for (int num: arr) queue.enqueue(num);
        queue.dequeue();
        System.out.println(queue);
    }
    static void checkStack(){
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Stack stack = new Stack();
        for (int num: arr) stack.push(num);
        stack.pop();
        System.out.println(stack);

    }
    static void checkQueueWithTwoStacks(){
        QueueTwoStacks queueTwoStacks = new QueueTwoStacks();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int num: arr)  queueTwoStacks.enqueue(num);
        System.out.println(queueTwoStacks + " Expected: 10 9 8 7 6 5 4 3 2 1"); // note because elements are in push stack, they are printed in reverse order
        queueTwoStacks.dequeue();// once one element is dequeued. It will be printed in queue order
        System.out.println(queueTwoStacks  + " Expected: 2 3 4 5 6 7 8 9 10");
        queueTwoStacks.dequeue();
        System.out.println(queueTwoStacks  + " Expected: 3 4 5 6 7 8 9 10");
        int[] arr2 = { 11, 12, 13, 14, 15 };
        for (int num: arr2)  queueTwoStacks.enqueue(num);
        System.out.println(queueTwoStacks + " Expected: 15 14 13 12 11 3 4 5 6 7 8 9 10");

    }


    static class QueueTwoStacks<Item>{
        Stack dequeueStack = new Stack();
        Stack pushStack = new Stack();
        public void enqueue(Item item){
            pushStack.push(item);
        }
        public Item dequeue(){
            if (dequeueStack.isEmpty()){
                while (!pushStack.isEmpty()) dequeueStack.push(pushStack.pop());
            }
            return (Item) dequeueStack.pop();
        }
        public boolean isEmpty(){ return dequeueStack.size() + pushStack.size() == 0; }
        public int size(){ return dequeueStack.size() + pushStack.size(); }

        public String toString(){
            return pushStack.toString() + dequeueStack.toString();
        }
    }
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
            QueueIterator queueIterator = new QueueIterator();
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
    static class Stack<Item> {
        Node last = null;
        int N = 0;

        public void push(Item item) {
            Node newLast = new Node(item);

            if (!isEmpty()) newLast.next = this.last;
            this.last = newLast;
            N++;
        }
        public Item pop(){
            Item item = (Item) this.last.item;
            this.last = this.last.next;
            N--;
            return item;
        }

        public int size() {
            return N;
        }

        public boolean isEmpty() {
            return N == 0;
        }
        public class StackIterator implements Iterator<Item>{
            private Node current = last;
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

        public String toString(){
            String result = "";
            StackIterator stackIterator = new StackIterator();
            while (stackIterator.hasNext()) result +=  " " + stackIterator.next();
            return result;
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
}
