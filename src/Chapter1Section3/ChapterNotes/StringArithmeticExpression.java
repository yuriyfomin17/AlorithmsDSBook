package Chapter1Section3.ChapterNotes;

import edu.princeton.cs.algs4.Stack;

// Thank You E.W.Dijkstra for your work in 1960s
public class StringArithmeticExpression {
    public static void main(String[] args) {
        String  arithmeticExpression = "( 1 + ( ( 2 + 3) * ( 4 * 5 ) ) )";
        processArithmeticExpression(arithmeticExpression);
//        "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )"
        String[]  arithmeticExpressionAlternative = {"(", "(", "1", "+", "sqrt", "(", "5", ")", ")", "/", "2", ")"};
        processArithmeticExpressionAlternative(arithmeticExpressionAlternative);
    }

    public static void processArithmeticExpression(String arithmeticExpression) {
        Stack<String> operands = new Stack<>();
        Stack<Double> values = new Stack<>();
        for (int i = 0; i < arithmeticExpression.length(); i++) {

            String s = Character.toString(arithmeticExpression.charAt(i));
            if (s.equals("(") || s.equals(" ")) continue;
            else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
                operands.push(s);
            } else if (s.equals(")")) {
                double v = values.pop();
                String currOperand = operands.pop();
                if (currOperand.equals("sqrt")) values.push(Math.sqrt(values.pop()));
                else values.push(processValues(currOperand, v, values.pop()));
            } else values.push(Double.parseDouble(s));
        }
        System.out.println(values.pop());
    }

    public static double processValues(String operand, double v1, double v2) {
        if (operand.equals("+")) return v1 + v2;
        if (operand.equals("-")) return v1 - v2;
        if (operand.equals("*")) return v1 * v2;
        if (operand.equals("/")) {
            return v2 / v1;
        }

        return 0;
    }

    public static void processArithmeticExpressionAlternative(String[] arithmeticExpression) {
        Stack<String> operands = new Stack<>();
        Stack<Double> values = new Stack<>();

        for (int i = 0; i < arithmeticExpression.length; i++) {
            String s = arithmeticExpression[i];
            if (s.equals("(") || s.equals(" ")) continue;
            else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
                operands.push(s);
            } else if (s.equals(")")) {
                double v = values.pop();
                String currOperand = operands.pop();
                if (currOperand.equals("sqrt")) values.push(Math.sqrt(v));
                else values.push(processValues(currOperand, v, values.pop()));
            } else values.push(Double.parseDouble(s));
        }
        System.out.println(values.pop());
    }
}
