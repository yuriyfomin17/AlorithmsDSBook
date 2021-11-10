package Chapter1Section4.Exercises;

import java.util.Iterator;

public class Exe1412SameNumbersInSortedArrays {

    public static void main(String[] args) {
        int[] array1 = { 0, 1, 2, 2, 5, 6, 6, 8, 25, 25 };
        int[] array2 = { -2, 0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25, 25 };
        System.out.println(contactedArr(array1, array2));
    }

    public static String contactedArr(int[] array1, int[] array2 ){
        int idx1 = 0;
        int idx2 = 0;
        Exe1412SameNumbersInSortedArrays exe1412SameNumbersInSortedArrays = new Exe1412SameNumbersInSortedArrays();
        LinkedList<Integer> linkedList = exe1412SameNumbersInSortedArrays.new LinkedList<>();
        while (idx1 < array1.length && idx2 < array2.length){
            if (array1[idx1] == array2[idx2]) {
                if (linkedList.isEmpty() || linkedList.rear() != array1[idx1]) linkedList.push(array1[idx1]);
                idx1++;
                idx2++;
            } else if (array1[idx1] < array2[idx2]) idx1++;
            else if (array1[idx1] > array2[idx2]) idx2++;
        }
        return linkedList.toString();
    }

    class LinkedList<Item>{
        private Node first = null;
        private Node last = null;
        private int N = 0;

        public void push(Item item){
            Node oldLast = last;
            this.last = new Node();
            this.last.item = item;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }
        public Item rear(){
            return (Item) this.last.item;
        }
        public boolean isEmpty(){ return N == 0;}
        public int size(){ return N; }
        public String toString(){
            LinkedListIterator linkedListIterator = new LinkedListIterator();
            String result = "";
            while (linkedListIterator.hasNext()) result += " " + linkedListIterator.next();
            return result;
        }
        private class  LinkedListIterator implements Iterator<Item>{
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current!= null;
            }

            @Override
            public Item next() {
                Item item = (Item) current.item;
                current = current.next;
                return item;
            }
        }
    }

    class Node<Item>{
        private Item item;
        private Node next = null;
    }

}
