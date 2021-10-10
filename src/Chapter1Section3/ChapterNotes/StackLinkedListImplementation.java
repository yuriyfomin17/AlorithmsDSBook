package Chapter1Section3.ChapterNotes;


public class StackLinkedListImplementation<Item> {
    private int N = 0;
    private Node firstNode;

    public int size(){ return N;}
    public boolean isEmpty(){ return firstNode == null;}

    public void push(Item item){
        Node newFirst = new Node();
        newFirst.item = item;
        Node temp = firstNode;
        firstNode = newFirst;
        newFirst.next = temp;
        N++;
    }
    public Item pop(){
        Item item = (Item) firstNode.item;
        firstNode = firstNode.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        String s = " to be or not to - be - - that -(- - is";
        StackLinkedListImplementation<String> stringStackLinkedListImplementation = new StackLinkedListImplementation<>();
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

class Node<Item> {
    public Item item;
    public Node next;
}
