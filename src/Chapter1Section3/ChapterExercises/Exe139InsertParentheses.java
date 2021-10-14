package Chapter1Section3.ChapterExercises;

public class Exe139InsertParentheses {
    public static class Stack{
        int N = 0;
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
            if (isEmpty()) return "";
            String num = (String) this.first.item;
            this.first = this.first.next;

            N--;
            return num;
        }

        public boolean isEmpty(){
            return first == null;
        }
    }

    public static void calculateArithmeticExpression(String s){
        Stack stackNums = new Stack();
        Stack operands = new Stack();

        for (int i = 0; i < s.length(); i++) {
            String currString = Character.toString(s.charAt(i));
            if (currString.equals("(") || currString.equals(" ")) continue;
            else if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) operands.push(currString);
            else if (currString.equals(")")){
                String operand = operands.pop();
                String num2 = stackNums.pop();
                String num1 = stackNums.pop();
                int result = processArithmeticValues(operand, Integer.parseInt(num1), Integer.parseInt(num2));
                stackNums.push(Integer.toString(result));
            }else stackNums.push(currString);
        }
        System.out.println(stackNums.pop());
    }
    public static void insertBrackets(String expression){
        Stack stackNums = new Stack();
        Stack operands = new Stack();
        String subExpression = "";
        for (int i = 0; i < expression.length(); i++) {
            String s = Character.toString(expression.charAt(i));
            if (s.equals(" ")) continue;
            else if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) operands.push(s);
            else if (s.equals(")")){
                String operand = operands.pop();
                String num2 = stackNums.pop();
                String num1 = stackNums.pop();
                stackNums.push("(" + num1 + operand + num2 + ")");
            } else stackNums.push(s);
        }
        System.out.println(stackNums.pop());
        System.out.println(subExpression);
    }

    public static void main(String[] args) {
//        calculateArithmeticExpression("( ( 1 + 2 ) * ( ( 3 -4 ) * ( 5 - 6 ) )");
        insertBrackets("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
        getInfixExpression("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
    }

    public static int processArithmeticValues(String operand, int num1, int num2){
        if (operand.equals("+")) return num1 + num2;
        if (operand.equals("-")) return num1 - num2;
        if (operand.equals("*")) return num1 * num2;
        if (operand.equals("/")) return num1 / num2;
        return 0;
    }

    public static void getInfixExpression(String input) {

        Stack operands = new Stack();
        Stack operators = new Stack();

        String[] inputValues = input.split("\\s");

        for (String value : inputValues) {
            if (value.equals("(")) {
                //do nothing
            } else if (value.equals("+")
                    || value.equals("-")
                    || value.equals("*")
                    || value.equals("/")) {
                operators.push(value);
            } else if (value.equals(")")) {
                String operator = operators.pop();
                String value2 = operands.pop();
                String value1 = operands.pop();

                String subExpression = "( " + value1 + " " + operator + " " + value2 + " )";
                operands.push(subExpression);
            } else {
                operands.push(value);
            }
        }
        System.out.println(operands.pop());
    }

    // Parameter example: "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"
}
