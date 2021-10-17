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
        postFixToInfixConverter("42+13-*");
        evaluatePostfix("12+42/*");
        evaluatePostfix("12+34-56-**");
        evaluatePostfix("42+13-*");
    }
    // infix => ( ( 4 + 2 ) * ( 1 - 3 ) ), postfix => 42+13-*
    // infix => ( ( 1 + 2 ) * ( 4 / 2 ) ), postfix => 1 2 + 4 2 / *
    // infix => ( 1 + 2 ) *  (( 3 -4 ) * ( 5 - 6 ) ), postfix => 12+34-56-**
    public static void postFixToInfixConverter(String postFixExpression){
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
    public static void evaluatePostfix(String postfixExpression){
        Stack numbers = new Stack();
        for (int i = 0; i < postfixExpression.length(); i++) {
            String s = Character.toString(postfixExpression.charAt(i));

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                String num2 = numbers.pop();
                String num1 = numbers.pop();
                int result = processArithmeticExpression(s, num1, num2);
                numbers.push(Integer.toString(result));

            } else numbers.push(s);
        }
        System.out.println(numbers.pop());
    }
    public static int processArithmeticExpression(String operand, String num1, String num2){
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);
        if (operand.equals("+")) return number1 + number2;
        if (operand.equals("-")) return number1 - number2;
        if (operand.equals("*")) return number1 * number2;
        if (operand.equals("/")) return number1 / number2;
        return -1;
    }
}
