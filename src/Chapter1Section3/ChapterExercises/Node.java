package Chapter1Section3.ChapterExercises;

class Node<Item> {
    public Item item;
    public Node next;

    public String toString(){
        if (item instanceof Integer) return Integer.toString((int)item);
        if (item instanceof String) return (String) item;
        else return "Not a string";
    }
}