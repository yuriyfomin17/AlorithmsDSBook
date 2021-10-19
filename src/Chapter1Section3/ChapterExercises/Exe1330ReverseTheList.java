package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1330ReverseTheList {

    static class LinkedList{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void push(int num ){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = num;
            this.last.next = null;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;

            N++;
        }
        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return N; }

        public Node getFirst() { return first; }
        public Node getSecond(){ return this.first.next;}

        public void setFirst(Node first) {
            this.first = first;
        }

        public void reverse(){
            Node first = this.first;
            Node previous = null;
            while (first != null){

                Node second = first.next;
                first.next = previous;

                previous = first;
                first = second;
            }
            this.first = previous;
        }

        public void reverse(Node first , Node previous){
            if (first == null) {
                this.first = previous;
                return;
            }

            Node second = first.next;
            first.next = previous;

            previous = first;
            first = second;
            reverse(first, previous);
        }

        private class LinkedListIterator implements Iterator<Integer>{
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                Integer item = (Integer) current.item;
                current = current.next;
                return item;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < numbers.length; i++) linkedList.push(numbers[i]);

        linkedList.reverse(linkedList.getFirst(), null);
        LinkedList.LinkedListIterator linkedListIterator = linkedList.new LinkedListIterator();
        while (linkedListIterator.hasNext()) System.out.print(" " + linkedListIterator.next());

    }
}
