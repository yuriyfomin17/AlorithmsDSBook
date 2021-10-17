package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1312StackCopyFeatureArray {
    static class Stack{
        private int N = 0;
        private String[] a;
        public Stack(){
            a = new String[3];
        }
        public void push(String item){
            if (N == a.length) resize(a.length * 2);
            a[N++] = item;
        }
        public String pop(){
            String item = a[--N];
            a[N] = null; // loitering
            if (N > 0 && N == a.length / 4) resize(a.length / 2);
            return item;
        }
        public void resize(int size){
            String[] newArr = new String[size];
            for (int i = 0; i < N; i++) {
                newArr[i] = a[i];
            }
            a = newArr;
        }
        public boolean isEmpty(){
            return N == 0;
        }

        public Stack copy(){
            Stack newStack = new Stack();
            for (int i = 0; i < N; i++) {
                newStack.push(a[i]);
            }
            return newStack;
        }

    }

    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        Stack stack = new Stack();
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }

        Stack copyStack = stack.copy();
        while (!copyStack.isEmpty()) System.out.println(copyStack.pop());
    }
}
