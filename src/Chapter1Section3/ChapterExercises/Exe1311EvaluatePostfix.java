package Chapter1Section3.ChapterExercises;

public class Exe1311EvaluatePostfix {
    static class Stack{
        private int N = 0;
        private Node first = null;

        public void push(String s){
            Node oldFirst = first;

            this.first = new Node();
            this.first.item = s;
            this.first.next = null;
            this.first.next = oldFirst;
            N++;
        }
        public String pop(){
            String s = (String) this.first.item;
            this.first = this.first.next;

            N--;
            return s;
        }
        public boolean isEmpty(){
            return this.first == null;
        }
    }
    public static void main(String[] args) {
        evaluatePostFix("12+42/*");
    }
    // infix => ( ( 1 + 2 ) * ( 4 / 2 ) ), postfix => 1 2 + 4 2 / *
    // infix => ( 1 + 2 ) *  (( 3 -4 ) * ( 5 - 6 ) ), postfix => 12+34-56-**
    public static void evaluatePostFix(String postFixExpression){
        Stack numbers = new Stack();
        for (int i = 0; i < postFixExpression.length(); i++) {
            String s = Character.toString(postFixExpression.charAt(i));

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                String num2 = numbers.pop();
                String num1 = numbers.pop();
                String currExpression = "( " + num1 + " " + s + " " + num2 + " )";
                numbers.push(currExpression);
            } else numbers.push(s);

        }
        System.out.println(numbers.pop());
    }
}
