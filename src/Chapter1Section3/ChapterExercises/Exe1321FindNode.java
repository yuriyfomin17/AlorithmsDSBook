package Chapter1Section3.ChapterExercises;

public class Exe1321FindNode {
    static class LinkedList{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void push(String item){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = item;
            this.last.next = null;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }
        public boolean find(String key){
            Node current = this.first;
            while (current != null && !current.item.equals(key)){
                current = current.next;
            }
            return current != null && current.item.equals(key);
        }

        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return N; }

    }

    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < numbers.length; i++) linkedList.push(numbers[i]);

        String[] keys = {"5", "6", "8"};
        for (int i = 0; i < keys.length; i++) System.out.println("Key " + keys[i] + " " + linkedList.find(keys[i]));
    }
}
