package Chapter1Section3.ChapterNotes;

public class FIFOLinkedList<Item> {

    private int N = 0; // Number of items in the queue
    private Node first; // link to least recently added item
    private Node last; // link to most recently added item

    public boolean isEmpty(){ return first == null; }
    public int size(){ return N; }

    public void enqueue(Item item){
        // Add item to the end of list
        Node oldLast = last;
        Node last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) first = this.last;
        else oldLast.next = last;

        N++;
    }

    public Item dequeue(){
        Item item = (Item) first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public static void main(String[] args) {

    }

}

