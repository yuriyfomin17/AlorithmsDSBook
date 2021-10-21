package Chapter1Section3.ChapterExercises;

import java.util.HashSet;
import java.util.Iterator;

public class Exe1340MoveToFront {
    static class MoveToFront{
        private int size = 0;
        private Node first = null;
        private HashSet<String> hashSet = new HashSet<>();


        public void enqueue(String item){
            if (!hashSet.contains(item)) {
                Node oldFirst = this.first;

                this.first = new Node();
                this.first.item = item;
                this.first.next = oldFirst;
            } else {
                Node current = this.first;
                Node previous = this.first;
                while (current.next != null && !current.item.equals(item)){
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
                Node newFirst = current;
                newFirst.next = this.first;
                this.first = newFirst;
            }
            hashSet.add(item);
        }

        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return size; }

        public String toString(){
            String result = "";
            MoveToFrontIterator moveToFrontIterator = new MoveToFrontIterator();
            while (moveToFrontIterator.hasNext()) result += " " + moveToFrontIterator.next();
            return result;
        }

        private class MoveToFrontIterator implements Iterator<String>{
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
        MoveToFront moveToFront = new MoveToFront();
        moveToFront.enqueue("a");
        moveToFront.enqueue("b");
        moveToFront.enqueue("d");
        moveToFront.enqueue("c");
        moveToFront.enqueue("d");
        moveToFront.enqueue("z");

        System.out.println(moveToFront);
    }
}
