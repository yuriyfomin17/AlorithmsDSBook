package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1326Remove {
    static class LinkedList{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void push(String key){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = key;
            this.last.next = null;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }
        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return N; }

        public void remove(String key){
            Node previous = this.first;
            Node current = this.first;
            while (current != null){
                if (current.item.equals(key) && previous == current) this.first = this.first.next;
                if (current.item.equals(key) && previous != current) {
                    while (current!= null &&current.item.equals(key)) current = current.next;
                    previous.next = current;
                }
                if (current == null) return;
                previous = current;
                current = current.next;
            }
        }

        class LinkedListIterator implements Iterator<String>{
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                String s = (String) current.item;
                current = current.next;
                return s;
            }
        }
    }
    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "5", "5" , "6", "6", "6", "7", "7", "8", "9", "10"};
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < numbers.length; i++) {
            linkedList.push(numbers[i]);
        }
        LinkedList.LinkedListIterator linkedListIterator = linkedList.new LinkedListIterator();
        while (linkedListIterator.hasNext()) System.out.print(" " + linkedListIterator.next());
        System.out.println();
        linkedList.remove("10");
        LinkedList.LinkedListIterator linkedListIterator2 = linkedList.new LinkedListIterator();
        while (linkedListIterator2.hasNext()) System.out.print(" " + linkedListIterator2.next());

    }
}
