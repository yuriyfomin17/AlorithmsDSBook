package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1325InsertAfter {
    static class LinkedList{
        private int N = 0;
        private Node first = null;
        private Node last  = null;

        public void push(String s){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = s;
            this.last.next = null;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;

            N++;
        }

        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return N; }

        public void insertAfter(Node node1, Node newNode){
            if (node1 != null && newNode != null){
                newNode.next = node1.next;
                node1.next = newNode;
                N++;
            }
        }
        public Node find(String key){
            Node current = this.first;
            while (current != null && !current.item.equals(key)) current = current.next;
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
                String item = (String) current.item;
                current = current.next;
                return item;
            }
        }
    }
    public static void main(String[] args) {
        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        LinkedList linkedList = new LinkedList();
        for (String s: strings) {
            linkedList.push(s);
        }
        Node node1 = linkedList.find("7");
        Node newNode = new Node();
        newNode.item = "99";
        newNode.next = null;
        linkedList.insertAfter(node1, newNode);
        LinkedList.LinkedListIterator linkedListIterator = linkedList.new LinkedListIterator();
        while (linkedListIterator.hasNext()) System.out.println(linkedListIterator.next());
    }
}
