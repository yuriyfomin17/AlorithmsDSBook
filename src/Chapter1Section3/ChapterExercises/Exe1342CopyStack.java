package Chapter1Section3.ChapterExercises;


import java.util.Iterator;

public class Exe1342CopyStack {
    static class Stack<Item>{
        private int N = 0;
        private Node first = null;

        public Stack(){
        }
        public Stack(Stack stack){
            Stack tempStack = new Stack();
            while (!stack.isEmpty()) tempStack.push(stack.pop());
            Stack copyStack = new Stack();
            for (int i = 0; i < tempStack.size(); i++) {
                Node node = tempStack.pop();
                copyStack.push(node);
                stack.push(node);
            }
            this.first = copyStack.getFirst();
            this.N = copyStack.size();
        }
        public void push(Node node){
            Node oldFirst = this.first;

            this.first = node;

            if (!isEmpty()) this.first.next = oldFirst;
            N++;
        }
        public Node pop(){
            Node item =  this.first;
            this.first = this.first.next;
            return item;
        }
        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return N; }

        public Node getFirst() {
            return first;
        }

        public String toString(){
            StackIterator stackIterator = new StackIterator();
            String result = "";
            while (stackIterator.hasNext()) result += " " + stackIterator.next();
            return result;
        }
        private class StackIterator implements Iterator<Item>{
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = (Item) current.item;
                current = current.next;
                return  item;
            }
        }
    }

    public static void main(String[] args) {
        testCopyStack1();
        testCopyStack2();


    }

    public static void testCopyStack1(){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stack originalStack = new Stack();
        for (int i = 0; i < numbers.length; i++) originalStack.push(new Node(numbers[i]));
        System.out.println("Original Stack Before Copy: " + originalStack);
        Stack stackCopy = new Stack(originalStack);
        System.out.println();
        System.out.println("Original Stack After Copy: " + originalStack);
        System.out.println("Expected: " + "10 9 8 7 6 5 4 3 2 1");
        System.out.println("Copy Stack after Copy: " + stackCopy);
        System.out.println("Expected: " + "10 9 8 7 6 5 4 3 2 1");
        System.out.println();
    }
    public static void testCopyStack2(){
        Stack originalStack = new Stack();
        originalStack.push(new Node(1));
        originalStack.push(new Node(2));
        originalStack.push(new Node(3));
        originalStack.push(new Node(4));

        Stack copyStack = new Stack(originalStack);
        copyStack.push(new Node(5));
        copyStack.push(new Node(6));

        originalStack.pop();
        originalStack.pop();

        copyStack.pop();

        System.out.println("Original Stack: " + originalStack);
        System.out.println("Expected: 2 1");

        System.out.println("Stack Copy: " + copyStack);
        System.out.println("Expected: 5 4 3 2 1");
    }

}
