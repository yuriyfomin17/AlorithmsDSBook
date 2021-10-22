package Chapter1Section3.ChapterExercises;

class Node<Item> {
    enum Side{
        LEFT,
        RIGHT
    }
    public Item item;
    public Node next;
    public Node previous;
    public Side side;

    public Node(Item anItem){
        this.item =  anItem;
        this.next = null;
    }
    public Node(){

    }
    public String toString(){
        if (item instanceof Node node) {
            return node.item.toString();
        }
        if (item instanceof Integer) return Integer.toString((int)item);
        if (item instanceof String) return (String) item;
        else return "Not a string";
    }
}