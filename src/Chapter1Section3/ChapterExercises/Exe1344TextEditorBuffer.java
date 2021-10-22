package Chapter1Section3.ChapterExercises;

public class Exe1344TextEditorBuffer {
    public static void main(String[] args) {

    }

    static class Buffer {

        private Node left = null;
        private Node beginningLeft = null;
        private int leftN = 0;

        private Node right = null;
        private Node beginningRight = null;
        private int rightN = 0;

        private Node cursor = null;

        public void insert(char c) {
            Node newNode = new Node();
            newNode.item = c;
            if (cursorEmpty()) {
                if (left == null) {
                    this.left = newNode;
                    this.left.side = Node.Side.RIGHT;
                    this.beginningLeft = this.left;
                }
                if (right == null) {
                    this.right = newNode;
                    this.right.side = Node.Side.RIGHT;
                    this.beginningRight = this.right;
                }
            } else {
                Node previous = this.cursor.previous;
                Node next = this.cursor.next;
                if (previous != null) newNode.side = previous.side;
                if (next != null) newNode.side = next.side;
                previous.next = newNode;
                newNode.previous = previous;

                newNode.next = next;
                next.previous = newNode;

            }
            this.cursor = newNode;
            if (this.cursor.side == Node.Side.RIGHT) this.rightN++;
            if (this.cursor.side == Node.Side.LEFT) this.leftN++;
        }

        public char delete() {
            char character = 0;
            if (!cursorEmpty()) return character;
            character = (char) this.cursor.item;
            Node previous = this.cursor.previous;
            Node next = this.cursor.next;

            previous.next = next;
            this.cursor = previous;

            if (next != null) next.previous = previous;

            return character;
        }

        public void left(int count) {
            Node current = this.cursor;

            while (current != null && count-- != 0 && this.cursor.side == Node.Side.RIGHT ) current = current.previous;
            while (current != null && count-- != 0 && this.cursor.side == Node.Side.LEFT) current = current.next;
            if (count == 0) this.cursor = current;
            else if (count != 0) {
                current = this.beginningRight;
                while (current != null && count-- != 0) current = current.next;
                if (count == 0) this.cursor = current;
                else System.out.println("Impossible position");
            }

        }

        public void right( int count) {
            Node current = this.cursor;

            while (current != null && count-- != 0 && this.cursor.side == Node.Side.RIGHT ) current = current.next;
            while (current != null && count-- != 0 && this.cursor.side == Node.Side.LEFT) current = current.previous;
            if (count == 0) this.cursor = current;
            else if (count != 0) {
                current = this.beginningLeft;
                while (current != null && count-- != 0) current = current.next;
                if (count == 0) this.cursor = current;
                else System.out.println("Impossible position");
            }
        }

        public int size() { return this.rightN + this.leftN; }
        public int leftSize(){ return this.leftN; }
        public int rightSize(){ return this.rightN; }

        public boolean cursorEmpty() {
            return cursor == null;
        }
    }
}
