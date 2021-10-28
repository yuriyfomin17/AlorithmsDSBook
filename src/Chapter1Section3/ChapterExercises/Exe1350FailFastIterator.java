package Chapter1Section3.ChapterExercises;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Exe1350FailFastIterator {
    static class Stack<Item> implements Iterable<Item>{
        private int N = 0;
        private int pushCount = 0;
        private int popCount = 0;
        private Node first = null;

        public void push(Item item){
            pushCount++;
            Node oldFirst = this.first;
            this.first = new Node();
            this.first.item = item;
            if (!isEmpty()) this.first.next = oldFirst;
        }
        public Node pop(){
            popCount++;
            Node node = this.first;
            this.first = this.first.next;
            N--;
            return node;
        }

        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return N; }
        public String toString(){
            StackIterator stackIterator = new StackIterator();
            String result = "";
            while (stackIterator.hasNext()) result += " " + stackIterator.next();
            return result;
        }

        public Iterator<Item> iterator(){ return new StackIterator(); }
        private class StackIterator implements Iterator<Item>{
            Node current = first;
            private int iteratorPushCount = pushCount;
            private int iteratorPopCount = popCount;
            @Override
            public boolean hasNext() {
                if (iteratorPopCount != popCount || iteratorPushCount != pushCount)
                    throw new ConcurrentModificationException("Can't Push and Pop during iteration");
                return current != null;
            }

            @Override
            public Item next() {
                if (iteratorPopCount != popCount || iteratorPushCount != pushCount)
                    throw new ConcurrentModificationException("Can't Push and Pop during iteration");
                Item item = (Item) current.item;
                current = current.next;
                return item;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < numbers.length; i++) stack.push(numbers[i]);

        for (int num : stack) {
            System.out.print(" " + num);
            stack.pop();
        }
    }
}
