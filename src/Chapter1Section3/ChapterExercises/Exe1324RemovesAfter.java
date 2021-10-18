package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1324RemovesAfter {
    static class LinkedList{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void push(String item){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = item;
            this.last.next = null;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }

        public boolean isEmpty(){ return this.first == null;}
        public int size(){ return N;}

        public void removesAfter(Node node){
            if (size() <= 1 || node == null ||node.next == null) return;

            Node current = this.first;
            Node previous = this.first;
            while (current != null && current != node){
                previous = current;
                current = current.next;
            }
            if (previous != null && current!= null && current == node){
                previous.next = current.next;
                current.next = null;
            }
        }
        public Node findNode(String elem){
            Node current = this.first;
            while (current != null && !current.item.equals(elem)) current = current.next;
            return current;
        }
        private class LinkedListIterator implements Iterator<String>{
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
        String[] numbers = {"1", "2", "3"};
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < numbers.length; i++) {
            linkedList.push(numbers[i]);
        }
        Node node = linkedList.findNode("2");
        linkedList.removesAfter(node);
        LinkedList.LinkedListIterator linkedListIterator = linkedList.new LinkedListIterator();
        while (linkedListIterator.hasNext()) System.out.println(linkedListIterator.next());
    }
}
