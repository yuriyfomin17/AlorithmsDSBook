package Chapter1Section3.ChapterNotes;

import java.util.Iterator;

public class Bag<Item> {
    private Node first;
    private int N = 0;
    public void add(Item item){
        Node oldFirst = first;
        oldFirst.item = item;
        this.first = new Node();
        this.first.next = oldFirst;
        N++;
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext() {
            return current!= null;
        }
        public void remove(){}
        public Item next(){
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }
}
