package Chapter1Section3.ChapterExercises;

public class Exe135BinaryRepresentation {
    public static void main(String[] args) {
        System.out.println(binaryString(50));
        System.out.println(binaryStringStack(50));
    }
    public static String binaryString(int num ){
        String binaryString = "";
        for (int i = num; i > 0 ; i /= 2) {
            if (i % 2 != 0) binaryString = "1" + binaryString;
            else binaryString = "0" + binaryString;
        }
        return binaryString;
    }
    // Stack binary string method. What is interesting is that
    // it kind of reverses an order so you actually start from the lowest number of 50 so 2^5 + 2^4 + 2^1
    public static String binaryStringStack(int N){
        Stack stack = new Stack();
        while (N > 0){
            stack.push(N % 2);
            N = N / 2;
        }
        String result = "";
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
    static class Stack{
        private int N = 0;
        private int[] a;

        public Stack(){
            a = new int[3];
        }
        public void push(int num){
            if (N == a.length) resize(2 * a.length);
            a[N++] = num;
        }
        public int pop(){
            int num = a[--N];
            if (N > 0 && N == a.length / 4) resize(a.length / 2);
            return num;
        }
        public boolean isEmpty(){
            return N == 0;
        }
        public void resize(int newSize){
            int[] newArr = new int[newSize];
            for (int i = 0; i < N; i++) {
                newArr[i] = a[i];
            }
            a = newArr;
        }
    }
}

