package Chapter1Section3.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exe1331DoubleLinkedList {
    static class DoubleNode {
        public Integer item;
        public DoubleNode next;
        public DoubleNode previous;

        public String toString(){
            return Integer.toString(item);
        }
    }
    static class LinkedList{
        private int N = 0;
        private DoubleNode first = null;
        private DoubleNode last = null;

        public void push(int num){
            DoubleNode oldLast = this.last;

            this.last = new DoubleNode();
            this.last.item = num;
            this.last.next = null;

            if (isEmpty()) {
                this.first = this.last;
                this.first.previous = this.last;
                this.last.previous = this.first;
            } else {
                oldLast.next = this.last;
                this.last.previous = (DoubleNode) oldLast;
            }
        }

        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return N; }
        public void insertAtTheBeginning(int num){
            if (isEmpty()){
                this.first = new DoubleNode();
                this.first.item = num;
                this.last = this.first;
                this.last.previous = this.first;
            } else {
                DoubleNode oldFirst = this.first;

                this.first = new DoubleNode();
                this.first.item = num;
                this.first.next = oldFirst;
                oldFirst.previous = this.first;
            }
            N++;

        }
        public DoubleNode find(int key){
            DoubleNode current = this.first;
            while (current != null && current.item != key) current = (DoubleNode) current.next;
            return current;
        }
        public void removeFromBeginning(){
            if (isEmpty()) return;
            this.first =  this.first.next;
            N--;
        }

        public void insertAtTheEnd(int num){
            if (isEmpty()) {
                this.first = new DoubleNode();
                this.first.item = num;
                this.last = this.first;
                this.last.previous = this.first;
            } else {
                DoubleNode oldLast = this.last;

                this.last = new DoubleNode();
                this.last.item = num;
                this.last.next = null;

                oldLast.next = this.last;
                this.last.previous = oldLast;
            }
            N++;
        }
        public void removeFromTheEnd(){
            if (isEmpty()) return;
            this.last = this.last.previous;
            this.last.next = null;
            N--;
        }

        public void insertBeforeGivenNode(DoubleNode beforeNode, int itemToInsert){
            if (beforeNode == null) return;
            DoubleNode newNode = new DoubleNode();
            newNode.item = itemToInsert;

            newNode.next = beforeNode;
            newNode.previous = beforeNode.previous;
            beforeNode.previous.next = newNode;
            beforeNode.previous = newNode;
            N++;
        }

        public void insertAfterGivenNode(DoubleNode afterNode, int itemToInsert){
            DoubleNode newNode = new DoubleNode();
            newNode.item = itemToInsert;

            newNode.next = afterNode.next;
            newNode.previous = afterNode;
            afterNode.next = newNode;
            N++;
        }
        public void removeGivenNode(DoubleNode nodeToRemove){
            if (nodeToRemove == null || isEmpty()) return;
            DoubleNode current = this.first;

            while (current != null && current != nodeToRemove) current = current.next;

            if (size() == 1 && nodeToRemove == current) this.first = null;
            else {
                nodeToRemove.previous.next = nodeToRemove.next;
                nodeToRemove.next.previous = nodeToRemove.previous;
            }
        }
        private class LinkedListIterator implements Iterator<Integer>{
            private DoubleNode current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                Integer num = current.item;
                current = current.next;
                return num;
            }
        }

        public String toString(){
            LinkedListIterator linkedListIterator = new LinkedListIterator();
            String result = "";
            while (linkedListIterator.hasNext()){
                result =  result + " " + linkedListIterator.next();
            }
            return result.trim();
        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
//        for (int i = 0; i < numbers.length; i++) linkedList.push(numbers[i]);

        linkedList.insertAtTheBeginning(10);
        linkedList.insertAtTheBeginning(30);
        linkedList.insertAtTheEnd(999);

        StdOut.println("Doubly linked list items after initial insert: " + linkedList);
        StdOut.println("Expected: 30 10 999");

        linkedList.insertBeforeGivenNode(linkedList.find(9999), 998);
        linkedList.insertBeforeGivenNode(linkedList.find(999), 997);

        StdOut.println("\nDoubly linked list items after insert before 999: " + linkedList);
        StdOut.println("Expected: 30 10 997 999");

        linkedList.insertAfterGivenNode(linkedList.find(10), 11);
        StdOut.println("\nDoubly linked list items after insert after 10: " + linkedList);
        StdOut.println("Expected: 30 10 11 997 999");

        linkedList.removeFromBeginning();
        linkedList.removeFromTheEnd();

        linkedList.removeGivenNode(linkedList.find(11));

        StdOut.println("\nDoubly linked list items after deletions: " + linkedList);
        StdOut.println("Expected: 10 997");

    }
}
