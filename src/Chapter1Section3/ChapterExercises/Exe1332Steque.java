package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1332Steque {

    static class Steque<Item>{

        private int N = 0;
        private Node first = null;
        private Node last  = null;

        // push item to the bottom of the stack
        public void enqueue(Item item){
            Node lastOld = this.last;

            this.last = new Node();
            this.last.item = item;
            this.last.next = null;
            N++;
            if (isEmpty()) this.first = this.last;
            else lastOld.next = this.last;
        }
        // push item to the top of stack
        public void push(Item item){
            Node firstOld = this.first;

            this.first = new Node();
            this.first.item = item;
            this.first.next = null;
            N++;
            if (isEmpty()) this.last = this.first;
            else this.first.next = firstOld;
        }
        // remove the top item form stack
        public Item pop(){
            if (isEmpty()) return null;
            Item item = (Item) this.first.item;
            this.first = this.first.next;
            N--;
            return item;
        }

        public boolean isEmpty(){ return this.first == null || this.last == null; }
        public int size(){ return N; }
        public String toString(){
            String result = "";
            StequeIterator stequeIterator = new StequeIterator();
            while (stequeIterator.hasNext()) result += " " + stequeIterator.next();
            return result.trim();
        }
        private class StequeIterator implements Iterator<Item>{
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

    public static void main(String[] args) {
        Steque steque = new Steque();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        steque.pop();
        steque.enqueue(5);
        steque.enqueue(6);
        System.out.println("Steque items: " + steque);
        System.out.println("Expected: 2 1 5 6");
    }
}
