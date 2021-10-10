package Chapter1Section3.ChapterNotes;


public class LIFOLinkedList<Item> {
    private Node first; // top of stack (most recently added node)
    private int N = 0; // number of items

    public boolean isEmpty(){ return first == null;}
    public int size(){ return N;}

    public void push(Item item){
        // Add item to top of stack
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop(){
        // Remove item from top of stack
        Item item = (Item) first.item;
        first = first.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        String s = " to be or not to - be - - that -(- - is";
        LIFOLinkedList<String> stringStackLinkedListImplementation = new LIFOLinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            String currString = Character.toString(s.charAt(i));
            if (!currString.equals("-")) stringStackLinkedListImplementation.push(currString);
            else {
                System.out.println("Removed element: " + stringStackLinkedListImplementation.pop());
            }
        }
        System.out.println(stringStackLinkedListImplementation.size());
    }
}
