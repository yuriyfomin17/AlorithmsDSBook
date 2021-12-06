package Chapter1Section4.Exercises;

public class Exe1431DequeThreeStacks {
    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        deque.pushLeft(4);

        System.out.println(deque.popRight());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());

        System.out.println("Expected: 1 4 3");

        deque.pushRight(7);
        deque.pushRight(8);
        System.out.println("Size: " + deque.size() + " Expected: 3");
        System.out.println("IsEmpty: " + deque.isEmpty() + " Expected: false");

        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        System.out.println("Expected: 2 7 8");
    }

    static class Deque<Item> {
        Stack stackLeft = new Stack();
        Stack stackRight = new Stack();
        Stack stackDelete = new Stack();

        public Item popRight() {
            Item item = null;
            if (!stackRight.isEmpty()) {
                item = (Item) stackRight.pop();
            } else if (!stackLeft.isEmpty()) {
                while (!stackLeft.isEmpty()) stackDelete.push(stackLeft.pop());
                item = (Item) stackDelete.pop();
                while (!stackDelete.isEmpty()) stackLeft.push(stackDelete.pop());
            }
            return item;
        }

        public Item popLeft() {
            Item item = null;
            if (!stackLeft.isEmpty()) {
                item = (Item) stackLeft.pop();
            } else if (!stackRight.isEmpty()) {
                while (!stackRight.isEmpty()) stackDelete.push(stackRight.pop());
                item = (Item) stackDelete.pop();
                while (!stackDelete.isEmpty()) stackRight.push(stackDelete.pop());
            }
            return item;
        }

        public void pushLeft(Item item) {
            stackLeft.push(item);
        }

        public void pushRight(Item item) {
            stackRight.push(item);
        }
        public int size(){ return stackRight.size() + stackLeft.size(); }
        public boolean isEmpty(){ return stackLeft.isEmpty() && stackRight.isEmpty();}
    }

    static class Stack<Item> {
        Node last;
        private int N = 0;

        public void push(Item item) {
            Node newLast = new Node(item);
            if (!isEmpty()) newLast.next = this.last;
            this.last = newLast;
            N++;
        }

        public Item pop() {
            if (isEmpty()) return null;
            Item item = (Item) this.last.item;
            this.last = this.last.next;
            N--;
            return item;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

    }

    static class Node<Item> {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
            this.next = null;

        }
    }
}
