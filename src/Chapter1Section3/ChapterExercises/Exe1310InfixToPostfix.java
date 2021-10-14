package Chapter1Section3.ChapterExercises;

public class Exe1310InfixToPostfix {
    static class Stack{
        private int N = 0;
        private Node first = null;

        public void push(String s){
            Node oldFirst = this.first;
            this.first = new Node();

            this.first.item = s;
            this.first.next = null;
            this.first.next = oldFirst;

            N++;
        }
        public String pop(){
            if (isEmpty()) return "";
            String s = (String) first.item;
            first = first.next;
            N--;
            return s;
        }
        public boolean isEmpty(){
            return first == null;
        }
    }
    public static void main(String[] args) {
        infixToPostFix("( 1 + 2 ) *  (( 3 -4 ) * ( 5 - 6 ) )");
    }
    // ( 1 + 2 ) *  (( 3 -4 ) * ( 5 - 6 ) ) => 12+34-56-**
    public static void infixToPostFix(String expression){
        Stack operands = new Stack();
        Stack numbers = new Stack();
        String result = "";
        for (int i = 0; i < expression.length(); i++) {
            String currString = Character.toString(expression.codePointAt(i));
            if (currString.equals("(")) continue;
            else if (currString.equals("+") || currString.equals("-") || currString.equals("*") || currString.equals("/")){
                operands.push(currString);
            } else if (!currString.equals(" ") && !currString.equals("(") && !currString.equals(")")){
                numbers.push(currString);
            } else if (currString.equals(")")){
                String num2 = numbers.pop();
                String num1 = numbers.pop();
                String operand = operands.pop();
                if (num1.equals("") && num2.equals("")) result +=  " " + operand;
                else result += " " + num1 + " " + num2 + " " + operand;
            }
        }
        System.out.println(result.trim() + operands.pop());
    }
}
