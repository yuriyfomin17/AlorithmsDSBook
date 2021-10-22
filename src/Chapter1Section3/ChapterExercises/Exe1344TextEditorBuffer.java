package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1344TextEditorBuffer {
    static class TextEditor {

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
            if (left == null) {
                this.left = newNode;
                this.left.side = Node.Side.LEFT;
                this.beginningLeft = this.left;
            } else if (right == null) {
                this.right = newNode;
                this.right.side = Node.Side.RIGHT;
                this.beginningRight = this.right;
                this.beginningRight.previous = this.beginningLeft;
            } else if (this.cursor.side == Node.Side.LEFT){
                newNode.side = Node.Side.LEFT;
                Node previous = this.cursor.next;
                Node next = this.cursor.previous != null ? this.cursor.previous: this.beginningLeft;

                newNode.next = previous;
                newNode.previous = next;

                if (previous != null) previous.previous = newNode;
                if (next != null) next.next = newNode;

            } else if( this.cursor.side == Node.Side.RIGHT){
                newNode.side = Node.Side.RIGHT;
                Node previous = this.cursor.previous != null ? this.cursor.previous : this.beginningRight;
                Node next = this.cursor.next;

                newNode.previous = previous;
                newNode.next = next;

                if (previous != null) previous.next = newNode;

                if (next != null) next.previous = newNode;
            }
            this.cursor = newNode;
            if (this.cursor.side == Node.Side.RIGHT) this.rightN++;
            if (this.cursor.side == Node.Side.LEFT) this.leftN++;
            if (beginningLeft.previous == null) this.beginningLeft.previous = this.beginningRight;
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
        public String toString(){
            BufferIterator bufferIterator = new BufferIterator();
            String result = "";
            while (bufferIterator.hasNext()) result += " " + bufferIterator.next();
            return result;
        }

        private class BufferIterator implements Iterator<Character>{
            private Node current = left;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Character next() {
                char c = (char) current.item;
                if (current.side == Node.Side.LEFT) current = current.previous;
                else if (current.side == Node.Side.RIGHT) current = current.next;
                return c;
            }
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        try {
            textEditor.insert('y');
            textEditor.insert('u');
            textEditor.insert('r');
            textEditor.insert('i');
            textEditor.insert('y');
            System.out.println("Text Editor: " + textEditor);
        } catch (Exception e){
            e.printStackTrace();
        }


    }


}
