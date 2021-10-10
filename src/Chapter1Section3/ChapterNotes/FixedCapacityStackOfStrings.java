package Chapter1Section3.ChapterNotes;
import java.util.Iterator;
public class FixedCapacityStackOfStrings<Item>{
    private Item[] a;
    private int N;
    private int i;
    public FixedCapacityStackOfStrings(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item){
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }
    // operator with before prefix such as ++N returns incremented value
    // while N++ firstly returns value that increments it
    public Item pop(){
        Item item = a[--N];
        a[N] = null; // Avoid loitering
        // loitering is the condition when you hold a reference to an item
        // that is no longer needed
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean hasNext() { return i > 0;}
    public Item next() { return a[--i];}

    private class ReverseArrayIterator implements Iterator<Item>
    { // Support LIFO iteration
        private int i = N;
        public boolean hasNext() { return  i > 0;}
        public Item next() { return a[--i];}
        public  void remove(){};

    }

    public static void main(String[] args) {
        String s = " to be or not to - be - - that - - - is";
        FixedCapacityStackOfStrings<String> fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings<String>(100);
        for (int i = 0; i < s.length(); i++) {
            String currString = Character.toString(s.charAt(i));
            if (!currString.equals("-"))
                fixedCapacityStackOfStrings.push(currString);
            else {
                System.out.printf("Element removed %s \n", fixedCapacityStackOfStrings.pop());
            }
        }
        System.out.printf("%d left on stack", fixedCapacityStackOfStrings.size() );
    }
}
