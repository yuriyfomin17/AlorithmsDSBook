package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1327Max {
    static class LinkedList{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void push(int n){
            Node oldFirst = this.last;

            this.last = new Node();
            this.last.item = n;
            this.last.next = null;
            if (isEmpty()) this.first = this.last;
            else oldFirst.next = this.last;
            N++;
        }

        public boolean isEmpty(){ return first == null; }
        public int size(){ return N; }

        public int max(){
            Node current = this.first;
            int maxKey = Integer.MIN_VALUE;
            while (current != null){
                maxKey = Math.max(maxKey, (int) current.item);
                current = current.next;
            }
            return maxKey;
        }

        private class LinkedListIterator implements Iterator<Integer>{
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current == null;
            }

            @Override
            public Integer next() {
                Integer num = (Integer) current.item;
                current = current.next;
                return num;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < nums.length; i++) linkedList.push(nums[i]);
        int maxValue = linkedList.max();
        System.out.printf("Max value in LinkedList %d", maxValue);
    }
}
