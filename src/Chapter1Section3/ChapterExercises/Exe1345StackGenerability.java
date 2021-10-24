package Chapter1Section3.ChapterExercises;

public class Exe1345StackGenerability {
    static class Stack{
        private int N = 0;
        private int[] a = new int[4];
        private int first = 0;

        public void push(int item){
            if (first == a.length) resize(a.length  * 2);
            a[first++] = item;
            N++;
        }
        public int pop(){
            if (isEmpty()) return -1;
            if (first == a.length / 4) resize(a.length / 2);
            int item = a[--first];
            N--;
            return item;
        }
        public int peek(){
            if (isEmpty()) return -1;
            return a[N - 1];
        }
        public int size(){ return N; }
        public boolean isEmpty(){ return N == 0; }
        public void resize(int newSize){
            int[] newArr = new int[newSize];
            for (int i = 0; i < N; i++) { newArr[i] = a[i]; }
            a = newArr;
        }
    }
    public static boolean willStackUnderflow(String[] arrStrings){
        int count = 0;
        for (int i = 0; i < arrStrings.length; i++) {
            if (arrStrings[i].equals("-")) count--;
            else count++;
            if (count < 0) return true;
        }
        return false;
    }
    public static boolean canPermutationBeGenerated(int[] permutation){
        Stack stack = new Stack();

        int nextNumber = 0;
        for (int number: permutation){
            if (stack.peek() != number) {
                while (nextNumber <= number) stack.push(nextNumber++);
                if (stack.pop() != number) return false;
            } else if (stack.peek() == number) stack.pop();

        }

        return true;
    }
    public static void main(String[] args) {
        // a ✅
        // b ❌
        // c ✅
        // d ✅
        // e ✅
        // f ❌
        // g ❌
        // h ✅
        testPossiblePermutations();
    }
    public static void testPossiblePermutations(){
        int[] a = { 4, 3, 2, 1, 0, 9, 8, 7, 6, 5 };
        int[] b = { 4, 6, 8, 7, 5, 3, 2, 9, 0, 1 };
        int[] c = { 2, 5, 6, 7, 4, 8, 9, 3, 1, 0 };
        int[] d = { 4, 3, 2, 1, 0, 5, 6, 7, 8, 9 };
        int[] e = { 1, 2, 3, 4, 5, 6, 9, 8, 7, 0 };
        int[] f = { 0, 4, 6, 5, 3, 8, 1, 7, 2, 9 };
        int[] g = { 1, 4, 7, 9, 8, 6, 5, 3, 0, 2 };
        int[] h = { 2, 1, 4, 3, 6, 5, 8, 7, 9, 0 };

        if (canPermutationBeGenerated(a)) System.out.println("a ✅");
        else System.out.println("a ❌");

        if (canPermutationBeGenerated(b)) System.out.println("b ✅");
        else System.out.println("b ❌");

        if (canPermutationBeGenerated(c)) System.out.println("c ✅");
        else System.out.println("c ❌");

        if (canPermutationBeGenerated(d)) System.out.println("d ✅");
        else System.out.println("d ❌");

        if (canPermutationBeGenerated(e)) System.out.println("e ✅");
        else System.out.println("e ❌");

        if (canPermutationBeGenerated(f)) System.out.println("f ✅");
        else System.out.println("f ❌");

        if (canPermutationBeGenerated(g)) System.out.println("g ✅");
        else System.out.println("g ❌");

        if (canPermutationBeGenerated(h)) System.out.println("h ✅");
        else System.out.println("h ❌");
     }
    public static void testStack(){
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stack stack = new Stack();
        for (int i = 0; i < numbers.length; i++) stack.push(numbers[i]);

        while (!stack.isEmpty()) System.out.print(" " + stack.pop());
    }

    public static void testUnderflow(){
        String input1Values = "0 1 2 - - -";
        String[] input1 = input1Values.split(" ");

        System.out.println("Input 1 - Will Underflow?");
        System.out.println(willStackUnderflow(input1) + " Expected: false");

        String input2Values = "0 1 2 - - - 3 4 5 - - 6 - - -";
        String[] input2 = input2Values.split(" ");

        System.out.println("Input 2 - Will Underflow? ");
        System.out.println(willStackUnderflow(input2) + " Expected: true");

        String input3Values = "0 - - 1 2 -";
        String[] input3 = input3Values.split(" ");

        System.out.println("Input 3 - Will Underflow? ");
        System.out.println(willStackUnderflow(input3) + " Expected: true");
    }

}
