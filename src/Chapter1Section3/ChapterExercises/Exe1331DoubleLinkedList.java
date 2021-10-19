package Chapter1Section3.ChapterExercises;

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
        private class LinkedListIterator implements Iterator<Integer>{
            private DoubleNode current = first;
            private boolean start = true;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                Integer num = (Integer) current.item;
                current = (DoubleNode) current.next;
                return num;
            }
        }
        public void insertAtTheBeginning(int num){
            if (isEmpty()) return;

            DoubleNode oldFirst = this.first;

            this.first = new DoubleNode();
            this.first.item = num;
            this.first.next = oldFirst;
            oldFirst.previous = this.first;

        }
        public DoubleNode find(int key){
            DoubleNode current = this.first;
            while (current != null && current.item != (Integer)key) current = (DoubleNode) current.next;
            return current;
        }
        public void removeFromBeginning(){
            if (isEmpty()) return;
            this.first = (DoubleNode) this.first.next;
        }

        public void insertAtTheEnd(int num){
            if (isEmpty()) return;

            DoubleNode oldLast = this.last;

            this.last = new DoubleNode();
            this.last.item = num;
            this.last.next = null;

            oldLast.next = this.last;
            this.last.previous = oldLast;
        }
        public void removeFromTheEnd(){
            if (isEmpty()) return;
            this.last = (DoubleNode) this.last.previous;
            this.last.next = null;
        }

        public void insertBeforeGivenNode(DoubleNode beforeNode, int itemToInsert){
            DoubleNode newNode = new DoubleNode();
            newNode.item = itemToInsert;

            newNode.next = beforeNode;
            newNode.previous = beforeNode.previous;
            beforeNode.previous.next = newNode;
            beforeNode.previous = newNode;
        }

        public void insertAfterGivenNode(DoubleNode afterNode, int itemToInsert){
            DoubleNode newNode = new DoubleNode();
            newNode.item = itemToInsert;

            newNode.next = afterNode.next;
            newNode.previous = afterNode;
            afterNode.next = newNode;
            afterNode.next.previous = newNode;
        }
        public void removeGivenNode(DoubleNode nodeToRemove){
            DoubleNode current = this.first;

            while (current != null && current != nodeToRemove) current = current.next;

            nodeToRemove.previous.next = nodeToRemove.next;
            nodeToRemove.next.previous = nodeToRemove.previous;

        }
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < numbers.length; i++) linkedList.push(numbers[i]);

        linkedList.insertAtTheBeginning(0);
        linkedList.removeFromBeginning();
        linkedList.insertAtTheEnd(11);
        linkedList.removeFromTheEnd();
        LinkedList.LinkedListIterator linkedListIterator = linkedList.new LinkedListIterator();
        DoubleNode doubleNode = linkedList.find(5);
        linkedList.insertBeforeGivenNode(doubleNode, -5);
        linkedList.insertAfterGivenNode(doubleNode, -5);
        linkedList.removeGivenNode(doubleNode);
        while (linkedListIterator.hasNext()) System.out.print(" " + linkedListIterator.next());

    }
}
