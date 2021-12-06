package Chapter1Section4.Exercises;

import java.util.Iterator;

public class Exe1429StequeTwoStacks {

    public static void main(String[] args) {


    }

    public static void checkSteque() {
        Steque steque = new Steque();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        steque.push(4);
        steque.enqueue(5);
        System.out.println(steque + " expected: 4 3 2 1 5");
        steque.dequeue();
        System.out.println(steque + " expected: 3 2 1 5");
    }

    static class Steque<Item> {
        Node first;
        Node last;
        int N = 0;

        // add element on top of stack
        public void push(Item item) {
            Node newFirst = new Node(item);
            if (isEmpty()) this.first = this.last = newFirst;
            else {
                newFirst.next = this.first;
                this.first = newFirst;
            }

            N++;

        }

        // add element to the bottom of stack
        public void enqueue(Item item) {
            Node newLast = new Node(item);
            if (isEmpty()) this.last = this.first = newLast;
            else {
                this.last.next = newLast;
                this.last = this.last.next;
            }

            N++;
        }

        // remove the element from the top of stack
        public Item dequeue() {
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

        public String toString() {
            String result = "";
            StequeIterator stequeIterator = new StequeIterator();
            while (stequeIterator.hasNext()) result += " " + stequeIterator.next();
            return result;
        }

        class StequeIterator implements Iterator<Item> {
            Node current = first;

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
}
