package Chapter1Section3.ChapterExercises;

public class Exe1319RemoveLastNode {
    static class LinkedList<Item>{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void push(Item item){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = item;
            this.last.next = null;
            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }
        public void removeLastNode(){
            if (isEmpty()) return;
            if (size() == 1){
                this.first = null;
                this.last = null;
            } else {
                Node current = this.first;
                while (current.next != this.last) current = current.next;
                current.next = null;
                this.last = current;
            }
            N--;
        }
        public boolean isEmpty(){ return first == null;}
        public int size(){ return N;}
    }

    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "4", "5"};
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            linkedList.push(numbers[i]);
        }
        linkedList.removeLastNode();
        System.out.println(linkedList.size());
        linkedList.removeLastNode();
        System.out.println(linkedList.size());
        linkedList.removeLastNode();
        System.out.println(linkedList.size());
        linkedList.removeLastNode();
        System.out.println(linkedList.size());
        linkedList.removeLastNode();

    }
}
