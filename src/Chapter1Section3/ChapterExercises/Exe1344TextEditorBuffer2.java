package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1344TextEditorBuffer2 {
    static class TextEditor<Item>{

        private int N = 0;

        private Node last = null;
        private Node first = null;
        private Node cursor = null;

        public void insert(char c){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = c;
            if (isEmpty()) this.first = this.last;
            else if (!isEmpty()){
                oldLast.next = this.last;
                this.last.previous = oldLast;
            }
            if (this.cursor == null) this.cursor = this.last;
            N++;

        }

        public char getCursorPosition(){
            if (cursor == null) return 0;
            return (char)this.cursor.item;
        }

        public char delete(){
            if (cursor == null) return 0;
            char c = (char)cursor.item;
            Node previous = cursor.previous;
            Node next = cursor.next;
            if (size() == 1 && cursor == first && cursor == last) {
                this.first = null;
                this.last = null;
                this.cursor = null;
            } else if (cursor == this.first)  {
                this.first = this.first.next;
                if (this.first.previous != null) this.first.previous.next = null;
                this.first.previous = null;
                this.cursor = this.first;
            } else if (cursor == this.last){
                this.last = this.last.previous;
                if (this.last.previous != null) this.last.previous.next = this.last;
                this.last.next = null;
                this.cursor = this.last;
            }else {
                previous.next = next;
                next.previous = previous;
                cursor = next;
            }
            N--;
            return c;
        }
        public void left(int k){
            Node current = this.cursor;
            while (current != null && k--!= 0) current = current.previous;
            if (current == null && k > 0) this.cursor = this.first;
            else this.cursor = current;
        }
        public void right(int k){
            Node current = this.cursor;
            while (current != null && k--!= 0) current = current.next;
            if (current == null && k > 0) this.cursor = this.last;
            else this.cursor = current;
        }
        @Override
        public String toString(){
            String result = "";
            TextEditorIterator textEditorIterator = new TextEditorIterator();
            while (textEditorIterator.hasNext()) result += textEditorIterator.next();
            return result;
        }

        private class TextEditorIterator implements Iterator<Item>{
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item c = (Item) current.item;
                current = current.next;
                return c;
            }
        }

        public boolean isEmpty(){ return  this.first == null; }
        public int size(){ return N; }

    }

    public static void main(String[] args) {
        testInsertion();
    }

    public static void testInsertion(){
        TextEditor textEditor = new TextEditor();

        textEditor.insert('Y');
        textEditor.insert('u');
        textEditor.insert('r');
        textEditor.insert('i');
        textEditor.insert('y');

        System.out.println("Text Editor: " + textEditor);
        System.out.println("Expected: Yuriy");
        System.out.println("Cursor position: " + textEditor.getCursorPosition());
        System.out.println("Expected: Y" );
        textEditor.right(3);
        System.out.println("Cursor position: " + textEditor.getCursorPosition());
        System.out.println("Expected: i" );

        textEditor.delete();
        System.out.println("Text Editor: " + textEditor);
        System.out.println("Expected: Yury" );
        textEditor.delete();
        System.out.println("Text Editor: " + textEditor);
        System.out.println("Expected: Yur" );
        System.out.println("Cursor position: " + textEditor.getCursorPosition());
        textEditor.delete();
        textEditor.delete();
        System.out.println("Text Editor: " + textEditor);
        System.out.println("Expected: Y" );
        textEditor.delete();
        System.out.println(textEditor);

        textEditor.insert('B');
        System.out.println("TextEditor: " + textEditor);
        System.out.println("Expected: B");
        textEditor.right(3);
        textEditor.left(3);
        System.out.println("Cursor: " + textEditor.getCursorPosition());
        System.out.println("Expected: B");
    }
}
