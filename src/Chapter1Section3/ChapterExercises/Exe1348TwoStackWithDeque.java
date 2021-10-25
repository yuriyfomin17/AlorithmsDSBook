package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1348TwoStackWithDeque {
    static class Stack<Item>{
        private int N = 0;
        private Node first = null;

        public void push(Item item){
            Node oldFirst = this.first;
            this.first = new Node(item);
            if (!isEmpty()) this.first.next = oldFirst;
            N++;
        }
        public Item pop(){
            Item item = (Item) this.first.item;
            this.first = this.first.next;
            N--;
            return item;
        }
        public int size(){ return N; }
        public boolean isEmpty(){ return this.first == null; }

        public Node getFirst() {
            return first;
        }
    }
    static class Deque<Item>{
        private final Stack leftStack = new Stack();
        private final Stack rightStack = new Stack();
        private int N = 0;

        // add an item to the left end
        public void pushStack1(Item item){
            leftStack.push(item);
            N++;
        }

        // add an item to the right end
        public void pushStack2(Item item){
            rightStack.push(item);
            N++;
        }

        // remove an item from the left end
        public Item popStack1(){
            Item item = (Item) leftStack.pop();
            N--;
            return item;
        }

        // remove an item from the right end
        public Item popStack2(){
            Item item = (Item) rightStack.pop();
            N--;
            return item;
        }

        public String toStringStack1(){
            DequeIterator dequeIterator = new DequeIterator(leftStack.getFirst());
            String result = "";
            while (dequeIterator.hasNext()) result += " " + dequeIterator.next();
            return result;
        }

        public String toStringStack2(){
            DequeIterator dequeIterator = new DequeIterator(rightStack.getFirst());
            String result = "";
            while (dequeIterator.hasNext()) result += " " + dequeIterator.next();
            return result;
        }

        private class DequeIterator implements Iterator<Item>{
            Node current = null;

            public DequeIterator(Node start){ current = start; }
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
    public static void main(String[] args) {
        testPushStack1();
        testPushStack2();
        testPopStack1();
        testPopStack2();
        testMixedOperations();
    }
    public static void testPushStack1(){
        Deque deque = new Deque();
        deque.pushStack1("a");
        deque.pushStack1("b");
        deque.pushStack1("c");

        System.out.println("Test Push on stack 1");
        System.out.println(deque.toStringStack1());
        System.out.println("Expected: c b a");

    }
    public static void testPushStack2(){
        Deque deque = new Deque();

        deque.pushStack2("a");
        deque.pushStack2("b");
        deque.pushStack2("c");
        System.out.println("Test Push on stack2");
        System.out.println(deque.toStringStack2());
        System.out.println("Expected: c b a");
    }
    public static void testPopStack1(){
        Deque deque = new Deque();
        deque.pushStack1("a");
        deque.pushStack1("b");
        deque.pushStack1("c");

        deque.popStack1();
        deque.popStack1();

        System.out.println("Test Pop on stack 1:");
        System.out.println(deque.toStringStack1());
        System.out.println("Expected: a");
    }
    public static void testPopStack2(){
        Deque deque = new Deque();
        deque.pushStack2("a");
        deque.pushStack2("b");
        deque.pushStack2("c");

        deque.popStack2();
        deque.popStack2();

        System.out.println("Test Pop on stack 2:");
        System.out.println(deque.toStringStack2());
        System.out.println("Expected: a");
    }

    public static void testMixedOperations(){
        Deque deque = new Deque();
        deque.pushStack1("yuriy");
        deque.pushStack2("a");
        deque.pushStack1("stack");
        deque.pushStack2("b");
        deque.pushStack1("deque");
        deque.pushStack2("c");

        System.out.println("Test stack 1 and stack 2 together");

        System.out.println(deque.toStringStack1());
        System.out.println("Expected stack 1: deque stack yuriy");
        System.out.println(deque.toStringStack2());
        System.out.println("Expected stack 2: - c b a");

        deque.popStack1();
        deque.popStack2();
        System.out.println(deque.toStringStack1());
        System.out.println("Expected stack 1: stack yuriy");
        System.out.println("Expected stack 2: b a");
    }
}
