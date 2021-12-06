package Chapter1Section4.Exercises;

import java.util.Iterator;

public class Exe1430DequeStackSteque {
    public static void main(String[] args) {
        testDeque();
    }
    public static void testDeque(){
        Deque deque = new Deque();
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        deque.pushLeft(4);

        System.out.println(deque.popRight());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println("Expected output from pop: 1 4 3");

        deque.pushRight(7);
        deque.pushRight(8);
        System.out.println("Size: " + deque.size() + " expected: 3");
        System.out.println("Is empty " + deque.isEmpty() + " Expected: false");

        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        System.out.println("Expected output from pop: 2 7 8");
    }

    static class Deque<Item> {
        Steque steque = new Steque<>();
        Stack stack = new Stack();

        public void pushLeft(Item item) {
            steque.push(item);
        }

        public void pushRight(Item item) {
            steque.enqueue(item);
        }

        public Item popLeft() {
            if (steque.isEmpty()) while (!stack.isEmpty()) steque.push(stack.pop());
            return (Item) steque.pop();
        }

        public Item popRight() {
            if (stack.isEmpty()) while (!steque.isEmpty()) stack.push(steque.pop());
            return (Item) stack.pop();
        }

        public boolean isEmpty() {
            return stack.isEmpty() && steque.isEmpty();
        }

        public int size() {
            return stack.size() + steque.size();
        }
    }

    static class Stack<Item> {
        Node first = null;
        int N = 0;

        public void push(Item item) {
            Node newFirst = new Node(item);
            if (!isEmpty()) newFirst.next = this.first;
            this.first = newFirst;
            N++;
        }

        public Item pop() {
            if (isEmpty()) return null;
            Item item = (Item) this.first.item;
            this.first = this.first.next;
            N--;
            return item;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }
    }

    static class Steque<Item> {
        Node first;
        Node last;
        int N = 0;

        // push item to the bottom of the stack
        public void enqueue(Item item) {
            Node newLast = new Node(item);
            if (isEmpty()) this.last = this.first = newLast;
            else {
                this.last.next = newLast;
                this.last = this.last.next;
            }
            N++;
        }

        // push item to the top of the stack
        public void push(Item item) {
            Node newFirst = new Node(item);
            if (isEmpty()) this.first = this.last = newFirst;
            else {
                newFirst.next = this.first;
                this.first = newFirst;
            }
            N++;
        }

        // remove the item from the top of the stack
        public Item pop() {
            if (isEmpty()) return null;
            Item item = (Item) this.first.item;
            this.first = this.first.next;
            N--;
            return item;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
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
