package Chapter1Section3.ChapterExercises;

public class Exe133Combinations {
    static class Stack<Item>{
        private int N = 0;
        private Node first = null;

        public boolean isEmpty(){
            return first == null;
        }

        public void push(Item item){
            Node oldFirst = first;

            this.first = new Node();
            this.first.item = item;
            this.first.next = null;

            this.first.next = oldFirst;
            N--;
        }

        public Item pop(){
            if (isEmpty()) return null;
            Item item = (Item) this.first.item;
            N++;
            return item;
        }
    }

    public static void main(String[] args) {


        Stack<String> stack = new Stack<>();
        // a ✅
        System.out.println("A\n");
        stack.push("0");
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");

        // b 0,1 can't occur
        System.out.println("\n");
        System.out.println("B\n");
        stack.push("0");
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.print(stack.pop() + " ");
        stack.push("5");
        stack.push("6");
        System.out.print(stack.pop() + " ");
        stack.push("7");
        stack.push("8");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        stack.push("9");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");

        // c ✅
        System.out.println("\n");
        System.out.println("C\n");
        stack.push("0");
        stack.push("1");
        stack.push("2");
        System.out.print(stack.pop() + " ");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        System.out.print(stack.pop() + " ");
        stack.push("6");
        System.out.print(stack.pop() + " ");
        stack.push("7");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        stack.push("8");
        System.out.print(stack.pop() + " ");
        stack.push("9");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");

        // d ✅
        System.out.println("\n");
        System.out.println("D\n");
        stack.push("0");
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        stack.push("5");
        System.out.print(stack.pop() + " ");
        stack.push("6");
        System.out.print(stack.pop() + " ");
        stack.push("7");
        System.out.print(stack.pop() + " ");
        stack.push("8");
        System.out.print(stack.pop() + " ");
        stack.push("9");
        System.out.print(stack.pop() + " ");


        // e ✅
        System.out.println("\n");
        System.out.println("E\n");
        stack.push("0");
        stack.push("1");
        System.out.print(stack.pop() + " ");
        stack.push("2");
        System.out.print(stack.pop() + " ");
        stack.push("3");
        System.out.print(stack.pop() + " ");
        stack.push("4");
        System.out.print(stack.pop() + " ");
        stack.push("5");
        System.out.print(stack.pop() + " ");
        stack.push("6");
        System.out.print(stack.pop() + " ");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");

        // f ->   1,7  can't occur
        System.out.println("\n");
        System.out.println("F\n");
        stack.push("0");
        System.out.print(stack.pop() + " ");
        stack.push("1");
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");

        // g -> 0, 2 can't occur
        System.out.println("\n");
        System.out.println("G\n");
        stack.push("0");
        stack.push("1");
        System.out.print(stack.pop() + " ");
        stack.push("2");

        // h ✅
        System.out.println("\n");
        System.out.println("H\n");
        stack.push("0");
        stack.push("1");
        stack.push("2");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        stack.push("3");
        stack.push("4");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        stack.push("5");
        stack.push("6");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        stack.push("7");
        stack.push("8");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        stack.push("9");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
    }
}
