package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

/**
 * Good discussion about why queue with 3 stacks can't be implemented
 * https://stackoverflow.com/questions/5538192/how-to-implement-a-queue-with-three-stacks/
 * Here one solution is based on stack overflow answer
 *
 * Another solution is based on https://ecommons.cornell.edu/bitstream/handle/1813/6273/80-433.pdf?sequence=1&isAllowed=y
 *
 */
public class Exe1349QueueThreeStacks {
    static class Stack<Item> implements Iterable<Item> {
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
        public Item peek(){ return (Item) this.first.item; }
        public int size(){ return N; }
        public boolean isEmpty(){ return N == 0; }
        @Override
        public Iterator<Item> iterator() {
            return new StackIterator();
        }

        private class StackIterator implements Iterator<Item>{
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = (Item) current.item;
                current = current.next;
                return item;
            }
        }
    }
    static class QueueStackOverFlow<Item>{
        private int N = 0;
        private Stack stack1 = new Stack();
        private Stack stack2 = stack1;
        // как матрешка
        public void enqueue(Item item){
            stack2.push(item);
            Stack tempStack1 = new Stack();
            stack2.push(tempStack1);
            stack2 = tempStack1;
            N++;
        }
        public Item dequeue(){
            Stack tempStack1 = (Stack) stack1.pop();
            Item item = (Item) stack1.pop();
            stack1 = tempStack1;
            N--;
            return item;
        }

        public int size(){ return N; }
        public boolean isEmpty(){ return stack1.isEmpty(); }
    }

    static class QueueCornellPaper<Item>{

        Stack stackHead = new Stack(); // in reverse order
        Stack stackTail = new Stack();

        // returns the front element of the queue
        public Item query(){
            return null;
        }

        // returns and deletes the front element of the queue
        public Item delete(){
            return null;
        }

        // inserted element to the end of the queue
        public void insert(Item item){
            stackTail.push(item);
            stackHead.push(stackTail.peek());
        }
        public boolean isEmpty(){ return stackHead.size() + stackTail.size() == 0; }
        public int size() { return stackHead.size() + stackTail.size(); }

    }
    public static void main(String[] args) {
        testStackOverFlowPaper();
    }
    static void testStackOverFlowPaper(){
        QueueStackOverFlow queue = new QueueStackOverFlow();
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//        queue.enqueue(1);
//        queue.enqueue(1);
//        queue.dequeue();
        for (int i = 0; i < numbers.length; i++) queue.enqueue(numbers[i]);
        while (!queue.isEmpty()) System.out.println("Item: " + queue.dequeue());
    }
    static void testCornellPaper(){
        QueueCornellPaper queueCornellPaper = new QueueCornellPaper();
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < numbers.length; i++)  queueCornellPaper.insert(numbers[i]);
        System.out.println("hello");
    }
    static void testStack(){
        Stack<Integer> stack = new Stack();
        Stack<Integer> reverseStack = new Stack();
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < numbers.length; i++) stack.push(numbers[i]);


        for (int elem: stack) reverseStack.push(elem);
        for (int elem: stack) System.out.print(" " + elem);
        System.out.println();
        System.out.println(" Peek: " + stack.peek());
        System.out.println();
        for (int elem: reverseStack) System.out.print(" " + elem);
        System.out.println();
        System.out.println(" Peek: " + reverseStack.peek());
    }
}
