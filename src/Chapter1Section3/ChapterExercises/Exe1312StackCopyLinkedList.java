package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1312StackCopyLinkedList {
    private int N = 0;
    private Node first = null;

    public void push(String s){
        Node oldFirst = this.first;

        this.first = new Node();
        this.first.item = s;
        this.first.next = null;

        this.first.next = oldFirst;
        N++;
    }
    public String pop(){
        if (isEmpty()) return null;
        String s = (String) this.first.item;
        this.first = this.first.next;
        N--;
        return s;
    }
    public boolean isEmpty(){
        return this.first == null;
    }

    private class StackIterator implements Iterator<String>{

        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }
        public String next(){
            String s = (String) current.item;
            current = current.next;
            return s;
        }
    }

    public Exe1312StackCopyLinkedList copy(){
        Exe1312StackCopyLinkedList temp = new Exe1312StackCopyLinkedList();
        Exe1312StackCopyLinkedList copyStack = new Exe1312StackCopyLinkedList();
        Exe1312StackCopyLinkedList.StackIterator stackIterator = new StackIterator();

        while (stackIterator.hasNext()){
            temp.push(stackIterator.next());
        }

        while (!temp.isEmpty()) copyStack.push(temp.pop());
        return copyStack;
    }

    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        Exe1312StackCopyLinkedList stack = new Exe1312StackCopyLinkedList();
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }
        Exe1312StackCopyLinkedList copyStack = stack.copy();

        while (!copyStack.isEmpty()) System.out.println(copyStack.pop());
    }
}
