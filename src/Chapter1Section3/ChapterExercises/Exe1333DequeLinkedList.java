package Chapter1Section3.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exe1333DequeLinkedList {
    static class Node<Item>{
        Node next = null;
        Item item = null;
        Node previous = null;
    }
    // Data structure deque or pronounced deck
    static class Deque<Item>{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        // add an item to the left end
        public void pushLeft(Item item){
            Node oldFirst = this.first;

            this.first = new Node();
            this.first.item = item;
            this.first.previous = null;

            if (isEmpty()){
                this.last = this.first;
            } else {
                this.first.next = oldFirst;
                oldFirst.previous = this.first;
            }
            N++;
        }
        // add an item to the right end
        public void pushRight(Item item){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = item;
            this.last.next = null;

            if (isEmpty()){
                this.first = this.last;
            } else {
                oldLast.next = this.last;
                this.last.previous = oldLast;
            }
            N++;
        }
        // remove item from the left end
        public Item popLeft(){
            Item item = (Item) this.first.item;
            if (size() == 1){
                this.first = null;
                this.last = null;
            } else {
                this.first = this.first.next;
                this.first.previous = null;
            }
            N--;
            return item;
        }
        // remove item from the right end
        public Item popRight(){
            Item item = (Item) this.last.item;
            if (size() == 1){
                this.first = null;
                this.last = null;
            } else {
                this.last = this.last.previous;
                this.last.next = null;
            }
            N--;
            return item;
        }

        public boolean isEmpty(){ return this.first == null || this.last == null; }
        public int size(){ return N; }
        public String toString(){
            DequeIterator dequeIterator = new DequeIterator();
            String result = "";
            while (dequeIterator.hasNext()) result += " " +  dequeIterator.next();
            return result;
        }
        private class DequeIterator implements Iterator<Item>{
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current!= null;
            }

            @Override
            public Item next() {
                Item item = (Item) current.item;
                current = current.next;
                return item;
            }
        }

    }

    public static void main(String[] args) {

        testPushLeft();
        testPushRight();
        testPopLeft();
        testPopRight();
    }
    private static void testPushLeft() {
        StdOut.println("Test Push Left");

        Deque<String> deque = new Deque<>();
        deque.pushLeft("a");
        deque.pushLeft("b");
        deque.pushLeft("c");



        StdOut.println("Deque items: " + deque);
        StdOut.println("Expected: c b a");
    }

    private static void testPushRight() {
        StdOut.println("\nTest Push Right");

        Deque<String> deque = new Deque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");



        StdOut.println("Deque items: " + deque);
        StdOut.println("Expected: a b c");
    }

    private static void testPopLeft() {
        StdOut.println("\nTest Pop Left");

        Deque<String> deque = new Deque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        deque.popLeft();
        deque.popLeft();


        StdOut.println("Deque items: " + deque);
        StdOut.println("Expected: c");
    }

    private static void testPopRight() {
        StdOut.println("\nTest Pop Right");

        Deque<String> deque = new Deque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        deque.popRight();
        deque.popRight();

        StdOut.println("Deque items: " + deque);
        StdOut.println("Expected: a");
    }
}
