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
            else if (isOperand(currString)) operands.push(currString);
            else if (currString.equals(")")){
                String operand = operands.pop();
                String num2 = stackNums.pop();
                String num1 = stackNums.pop();
                int result = processArithmeticValues(operand, Integer.parseInt(num1), Integer.parseInt(num2));
                stackNums.push(Integer.toString(result));
            }else stackNums.push(currString);
        }
        while (!stackNums.isEmpty() && !operands.isEmpty()){
            String operand = operands.pop();
            String num2 = stackNums.pop();
            String num1 = stackNums.pop();
            int result = processArithmeticValues(operand, Integer.parseInt(num1), Integer.parseInt(num2));
            System.out.println(result);
        }
    }
    public static void insertBrackets(String s){
        Stack closingBrackets = new Stack();
        Stack openingBrackets = new Stack();
    }

    public static void main(String[] args) {
        calculateArithmeticExpression("( ( 1 + 2 ) * ( ( 3 -4 ) * ( 5 - 6 ) )");
    }
    public static boolean isOperand(String s){
        String[] operands = {"+", "-", "*", "/"};
        for (int i = 0; i < operands.length ; i++) {
            if (operands[i].equals(s)) return true;
        }
        return false;
    }
    public static int processArithmeticValues(String operand, int num1, int num2){
        if (operand.equals("+")) return num1 + num2;
        if (operand.equals("-")) return num1 - num2;
        if (operand.equals("*")) return num1 * num2;
        if (operand.equals("/")) return num1 / num2;
        return 0;
    }
}
