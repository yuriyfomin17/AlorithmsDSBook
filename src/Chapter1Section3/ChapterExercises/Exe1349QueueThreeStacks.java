package Chapter1Section3.ChapterExercises;

public class Exe1349QueueThreeStacks {
    static class Stack<Item>{
        private int N = 0;
        private Node first = null;

        public void push(Item item){
            Node oldFirst = first;
            this.first = new Node(item);
            if (!isEmpty()) this.first.next = oldFirst;
            N++;
        }
        public Item pop(){
            Item item = (Item) this.first.item;
            N--;
            this.first = this.first.next;
            return item;
        }
        public int size(){ return N; }
        public boolean isEmpty(){ return first == null; }
    }
    static class Queue<Item>{
        private int N = 0;
        private Stack stack1 = new Stack();
        private Stack stack2 = stack1;

        public void enqueue(Item item){
            Stack stack3 = new Stack();
            stack3.push(item);
            stack2.push(stack3);
            stack3 = new Stack();
            stack2.push(stack3);
            stack2 = stack3;
            N++;
        }

        public Item dequeue(){
            Stack stack3 = (Stack) stack1.pop();
            stack1 = (Stack) stack1.pop();
            Item item = (Item) stack1.pop();
            stack1 = stack3;
            N--;
            return item;
        }
        public int size(){ return N; }
        public boolean isEmpty(){ return stack1.isEmpty(); }
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < numbers.length; i++) queue.enqueue(numbers[i]);
        while (!queue.isEmpty()) System.out.println("Item: " + queue.dequeue());
    }
}
