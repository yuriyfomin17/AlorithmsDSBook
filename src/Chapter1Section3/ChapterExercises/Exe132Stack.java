package Chapter1Section3.ChapterExercises;

public class Exe132Stack {
    private int N = 0;
    private String[] a;

    public Exe132Stack(int size){
        a = new String[size];
    }
    public void push(String s){
        if (N == a.length) resize(2 * a.length);
        a[N++] = s;
    }
    public String pop(){
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return a[--N];
    }
    public void resize(int size){
        String[] arr = new String[size];
        for (int i = 0; i < N; i++) {
            arr[i] = a[i];
        }
        a = arr;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }

    public static void main(String[] args) {
        // Task is a bit questionable
        String[] s = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Exe132Stack exe132Stack = new Exe132Stack(s.length);
        // a ✅
        System.out.println("A\n");
        exe132Stack.push("0");
        exe132Stack.push("1");
        exe132Stack.push("2");
        exe132Stack.push("3");
        exe132Stack.push("4");
        while (!exe132Stack.isEmpty()) System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("5");
        exe132Stack.push("6");
        exe132Stack.push("7");
        exe132Stack.push("8");
        exe132Stack.push("9");
        while (!exe132Stack.isEmpty()) System.out.print(exe132Stack.pop() + " ");

        // b 0,1 can't occur
        System.out.println("\n");
        System.out.println("B\n");
        exe132Stack.push("0");
        exe132Stack.push("1");
        exe132Stack.push("2");
        exe132Stack.push("3");
        exe132Stack.push("4");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("5");
        exe132Stack.push("6");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("7");
        exe132Stack.push("8");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("9");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");

        // c ✅
        System.out.println("\n");
        System.out.println("C\n");
        exe132Stack.push("0");
        exe132Stack.push("1");
        exe132Stack.push("2");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("3");
        exe132Stack.push("4");
        exe132Stack.push("5");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("6");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("7");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("8");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("9");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");

        // d ✅
        System.out.println("\n");
        System.out.println("D\n");
        exe132Stack.push("0");
        exe132Stack.push("1");
        exe132Stack.push("2");
        exe132Stack.push("3");
        exe132Stack.push("4");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("5");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("6");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("7");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("8");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("9");
        System.out.print(exe132Stack.pop() + " ");


        // e ✅
        System.out.println("\n");
        System.out.println("E\n");
        exe132Stack.push("0");
        exe132Stack.push("1");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("2");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("3");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("4");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("5");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("6");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("7");
        exe132Stack.push("8");
        exe132Stack.push("9");
        while (!exe132Stack.isEmpty()) System.out.print(exe132Stack.pop() + " ");

        // f ->   1,7  can't occur
        System.out.println("\n");
        System.out.println("F\n");
        exe132Stack.push("0");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("1");
        while (!exe132Stack.isEmpty()) System.out.print(exe132Stack.pop() + " ");

        // g -> 0, 2 can't occur
        System.out.println("\n");
        System.out.println("G\n");
        exe132Stack.push("0");
        exe132Stack.push("1");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("2");

        // h ✅
        System.out.println("\n");
        System.out.println("H\n");
        exe132Stack.push("0");
        exe132Stack.push("1");
        exe132Stack.push("2");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("3");
        exe132Stack.push("4");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("5");
        exe132Stack.push("6");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("7");
        exe132Stack.push("8");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
        exe132Stack.push("9");
        System.out.print(exe132Stack.pop() + " ");
        System.out.print(exe132Stack.pop() + " ");
    }
}
