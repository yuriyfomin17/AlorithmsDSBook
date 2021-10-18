package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1320Deletes {
    static class LinkedList<Item>{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void push(Item item){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = item;
            this.last.next = null;
            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }
        public void removeLastNode(){
            if (isEmpty()) return;
            if (size() == 1){
                this.first = null;
                this.last = null;
            } else {
                Node current = this.first;
                while (current.next != this.last) current = current.next;
                current.next = null;
                this.last = current;
            }
            N--;
        }
        public void removeKNode(int k){
            if (k <= size()){
                int count = 1;
                Node current = this.first;
                Node previous = this.first;
                while (current != null && count != k){
                    previous = current;
                    current = current.next;
                    count++;
                }
                if (count == 1) this.first = this.first.next;
                else previous.next = current.next;
            }


        }
        public boolean isEmpty(){ return first == null;}
        public int size(){ return N;}

        public Iterator<String> iterator() {
            return new LinkedListIterator();
        }

        private class LinkedListIterator implements Iterator<String>{
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                String item = (String) current.item;
                current = current.next;
                return item;
            }
        }
    }

    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "4", "5"};
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            linkedList.push(numbers[i]);
        }
        linkedList.removeKNode(2);
        LinkedList.LinkedListIterator linkedListIterator = linkedList.new LinkedListIterator();
        while (linkedListIterator.hasNext()) System.out.println(linkedListIterator.next());
    }
}
