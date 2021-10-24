package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1347CatenableQueuesStackSteques<Item> {
    static class Stack{
        private int N = 0;
        private Node last = null;

        public void push(Node newNode){
            Node oldLast = this.last;
            this.last = newNode;
            if (!isEmpty()) this.last.next = oldLast;
            N++;
        }
        public Node pop(){
            Node lastNode = this.last;
            this.last = this.last.next;
            N--;
            return lastNode;
        }
        public boolean isEmpty(){ return this.last == null; }
        public int size(){ return N; }

        @Override
        public String toString(){
            String result = "";
            DSIterator dsIterator = new DSIterator(this.last);
            while (dsIterator.hasNext()) result+= " " + dsIterator.next();
            return result;
        }
    }
    static class Queue{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void enqueue(Node newNode){
            Node oldLast = this.last;

            this.last = newNode;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;

            N++;
        }
        public Node dequeue(){
            if (isEmpty()) return null;
            Node node = this.first;
            this.first = this.first.next;
            N--;
            return node;
        }

        public boolean isEmpty(){ return N == 0; }

        @Override
        public String toString(){
            String result = "";
            DSIterator dsIterator = new DSIterator(this.first);
            while (dsIterator.hasNext()) result+= " " + dsIterator.next();
            return result;
        }
    }
    static class Steque{
        private int N = 0;
        Node first = null;
        Node last = null;

        // push item to the bottom of the stack
        public void enqueue(Node newNode){
            Node oldLast = this.last;
            this.last = newNode;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }

        // push item to the top of the stack
        public void push(Node newNode){
            Node oldFirst = this.first;
            this.first = newNode;

            if (isEmpty()) this.last = this.first;
            else this.first.next = oldFirst;
            N++;
        }

        // remove item from the top of the stack
        public Node pop(){
            Node node = this.first;
            this.first = this.first.next;
            N--;
            return node;
        }

        public boolean isEmpty(){ return  N == 0; }

        @Override
        public String toString(){
            String result = "";
            DSIterator dsIterator = new DSIterator(this.first);
            while (dsIterator.hasNext()) result+= " " + dsIterator.next();
            return result;
        }

        public static Queue queueCatenation(Queue queue1, Queue queue2){
            Queue newQueue = new Queue();
            CircularLinkedList circularLinkedList = new CircularLinkedList();
            while (!queue1.isEmpty()) {
                Node node = queue1.dequeue();
                newQueue.enqueue(new Node(node.item));
            }
            return newQueue;
        }

        public static Steque stequeCatenation(Steque steque1, Steque steque2){
            Steque newSteque = new Steque();
            CircularLinkedList circularLinkedListBuffer = new CircularLinkedList();

            while (!steque1.isEmpty()) circularLinkedListBuffer.push(steque1.pop());
            while (!circularLinkedListBuffer.isEmpty()) {
                Node node = circularLinkedListBuffer.removeLeft();
                newSteque.push(new Node(node.item));

            }

            while (!steque2.isEmpty()) circularLinkedListBuffer.push(steque2.pop());
            while (!circularLinkedListBuffer.isEmpty()) {

                Node node = circularLinkedListBuffer.removeLeft();
                newSteque.push(new Node(node.item));
            }

            return newSteque;
        }
    }
    static class CircularLinkedList<Item>{
        private Node last = null;
        private int N = 0;

        public void push(Node newNode){
            Node oldLast = this.last;
            Node first = null;
            if (this.last != null) first = this.last.next;

            this.last = newNode;
            if (isEmpty()) {
                this.last.next = this.last;
                this.last.next.previous = this.last;
            } else {
                oldLast.next = this.last;
                this.last.next = first;
                this.last.previous = oldLast;
            }
            N++;
        }
        public boolean isEmpty(){ return N == 0; }
        public int size(){ return N; }

        public Node removeLeft(){
            if (isEmpty()) return null;
            Node node = this.last.next;
            if (size() == 1) this.last = null;
            else this.last.next = this.last.next.next;
            N--;
            return node;
        }
        public Node removeRight(){
            if (isEmpty()) return null;
            Node node = this.last;
            if (size() == 1) this.last = null;
            else this.last = this.last.previous;
            N--;
            return node;
        }

        @Override
        public String toString(){
            String result = "";
            // remember that this.last.next is the first item in linkedList
            Node current = this.last.next;
            while (current != this.last) {
                result += " " + current;
                current = current.next;
            }
            if (current == this.last) result += " " + current;
            return result;
        }
        public String toStringReverse(){
            String result = "";
            Node current = this.last;
            // remember that this.last.next is the first item in linkedList
            while (current != this.last.next) {
                result += " " + current;
                current = current.previous;
            }
            if (current == this.last.next) result += " " + current;
            return result;
        }

        private class CircularLinkedListIterator implements Iterator<Item>{
            private Node currentReverse = last;
            private boolean isStartReverse = true;

            private Node current = last.next;
            private boolean isStart = true;
            @Override
            public boolean hasNext() {
                // remember that this.last.next points to the first element of the linked list
                // thus we should iterate until we again reach the first element since,
                // we have started from the first element
                boolean result = isStart || current != last.next;
                if (isStart) isStart = false;
                return result;
            }

            @Override
            public Item next() {
                Item item = (Item) current;
                current = current.next;
                return item;
            }

            public boolean hasNextReverse() {
                // remember this.last.next is the first element of the queue
                // Hence, currentReverse firstly points to the last element.
                // Thus, we should iterate until we reach first element of the
                // linkedList
                boolean result = isStartReverse || currentReverse != last.next;
                if (isStartReverse) isStartReverse = false;
                return result;
            }
            public Item nextReverse() {
                Item item = (Item) currentReverse;
                currentReverse = currentReverse.previous;
                return item;
            }
        }

    }
    static class DSIterator implements Iterator{
        Node current;
        public DSIterator(Node first){
            this.current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node next() {
            Node node = current;
            current = current.next;
            return node;
        }
        public Node reverseNext(){
            Node node = current;
            current = current.previous;
            return node;
        }
    }

    public static void main(String[] args) {
        testStequeCatenation();
    }
    public static void testStequeCatenation(){
        Steque steque1 = new Steque();
        steque1.push(new Node(1));
        steque1.push(new Node(2));
        steque1.push(new Node(3));
        steque1.enqueue(new Node(5));
        steque1.enqueue(new Node(6));

        Steque steque2 = new Steque();
        steque2.push(new Node(1));
        steque2.push(new Node(2));
        steque2.push(new Node(3));
        steque2.enqueue(new Node(5));
        steque2.enqueue(new Node(6));

        Steque catenationSteque = Steque.stequeCatenation(steque1, steque2);
        System.out.println("Catenation Steque: " + catenationSteque);


    }
    public static void testLinkedList(){
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < numbers.length; i++)  circularLinkedList.push(new Node(numbers[i]));
        System.out.println("Linked List items: " + circularLinkedList);
        System.out.println("Expected: 1 2 3 4 5 6 7 8 9 10");
        System.out.println("Linked List items reverse: " + circularLinkedList.toStringReverse());
        System.out.println("Expected: 10 9 8 7 6 5 4 3 2 1");
    }
    public static void testStack(){
        Stack stack = new Stack();
        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(3));
        stack.push(new Node(4));
        stack.push(new Node(5));
        stack.pop();
        stack.push(new Node(6));
        stack.pop();
        System.out.println("Stack items: " + stack);
        System.out.println("Expected: 4 3 2 1");
    }
    public static void testQueue(){
        Queue queue = new Queue();
        queue.enqueue(new Node(1));
        queue.enqueue(new Node(2));
        queue.enqueue(new Node(3));
        queue.enqueue(new Node(4));
        queue.dequeue();
        queue.enqueue(new Node(5));
        queue.enqueue(new Node(6));
        queue.dequeue();
        System.out.println("Queue items: " + queue);
        System.out.println("Expected: 3 4 5 6");
    }
    public static void testSteque(){
        Steque steque = new Steque();
        steque.push(new Node(1));
        steque.push(new Node(2));
        steque.push(new Node(3));
        steque.pop();
        steque.enqueue(new Node(5));
        steque.enqueue(new Node(6));
        System.out.println("Steque items: " + steque);
        System.out.println("Expected: 2 1 5 6");
    }
}
