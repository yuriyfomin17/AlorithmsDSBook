package Chapter1Section3.ChapterExercises;

public class Exe1328MaxRecursive {
    static class LinkedList{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void push(int n){
            Node oldFirst = this.last;

            this.last = new Node();
            this.last.item = n;
            this.last.next = null;
            if (isEmpty()) this.first = this.last;
            else oldFirst.next = this.last;
            N++;
        }

        public boolean isEmpty(){ return first == null; }
        public int size(){ return N; }

        public int max(Node current, int maxValue){
            if (current == null) return maxValue;
            return max(current.next, Math.max(maxValue, (int)current.item));
        }

        public Node getFirst() {
            return first;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < numbers.length; i++) linkedList.push(numbers[i]);

        System.out.printf("Max value in linkedList is %d", linkedList.max(linkedList.getFirst(), Integer.MIN_VALUE));

    }
}
