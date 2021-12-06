package Chapter1Section4.Exercises;
import java.util.Iterator;

public class Exe1429StequeTwoStacks {

    public static void main(String[] args) {
        checkStequeTwoStack2();
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

    public static void checkStequeTwoStack(){
        StequeWithStack steque = new StequeWithStack();
        steque.push(1);
        steque.push(2);
        steque.push(3); // 3 2 1
        steque.pop(); // 2 1
        steque.enqueue(5);
        steque.enqueue(6); // 6 5 1 2
        System.out.println("Steque items: " + steque);
        System.out.println("Expected: 6 5 1 2");

        steque.push(4); // 4 2 1 6 5

        System.out.println("Steque items: " + steque);
        System.out.println("Expected: 4 2 1 5 6");
    }

    public static void checkStequeTwoStack2(){
        StequeWithStack steque = new StequeWithStack();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        steque.enqueue(4);
        steque.enqueue(5);
        System.out.println("Size: " + steque.size() + " expected: 3");
        System.out.println("isEmpty: " + steque.isEmpty() + " expected: false");
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println("Expected output from pop:3 2 1 4");


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

        public String toString() {
            String result = "";
            Stack.StackIterator stackIterator = new Stack.StackIterator();
            while (stackIterator.hasNext()) result += " " + stackIterator.next();
            return result;

        }

        public class StackIterator implements Iterator<Item> {
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

    static class StequeWithStack<Item> {
        Stack topStack = new Stack();
        Stack bottomStack = new Stack();

        // push item to the bottom of the stack
        public void enqueue(Item item) {
            if (bottomStack.isEmpty()) while (!topStack.isEmpty()) bottomStack.push(topStack.pop());
            bottomStack.push(item);
        }

        // push item to the top of stack
        public void push(Item item) {
            if (topStack.isEmpty()) while (!bottomStack.isEmpty()) topStack.push(bottomStack.pop());
            topStack.push(item);
        }

        // remove top item from the stack
        public Item pop() {
            if (topStack.isEmpty()) while (!bottomStack.isEmpty()) topStack.push(bottomStack.pop());

            return (Item) topStack.pop();
        }

        public boolean isEmpty() {
            return topStack.isEmpty() && bottomStack.isEmpty();
        }

        public int size() {
            return topStack.size() + bottomStack.size();
        }

        public String toString() {
            return topStack.toString() + bottomStack.toString();
        }
    }
}
