package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAllParenthesis(result, 0, new char[2 * n]);
        return result;
    }

    public static void generateAllParenthesis(List<String> result, int pos, char[] curr){
        if(curr.length == pos) {
            if(isValid(curr)) result.add(new String(curr));
        }else{
            curr[pos] = '(';
            generateAllParenthesis(result, pos + 1, curr);
            curr[pos] = ')';
            generateAllParenthesis(result, pos + 1, curr);
        }


    }

    public static boolean isValid(char[] curr){
        int balance = 0;

        for(char c : curr){
            if(c == '(') balance++;
            else if(c == ')') balance--;
            if(balance < 0) return false;
        }
        return balance == 0;
    }

    /**
     *  <h2>Task: Generate all variation of parenthesis</h2>
     *  <h3>Time and Space Complexity Analysis - Approach 2</h3>
     *  <p> Time complexity: O(4^n / (sqrt(n))). Each valid sequence has at most n steps during backtracking procedure</p>
     *
     *  <p>Space complexity: O(4^n / (sqrt(n))) and using O(n) space to store the sequence</p>
     *
     * */
    public static List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        generateAllParenthesis2(result, new StringBuilder(), n, 0, 0);
        return result;
    }

    public static void generateAllParenthesis2(List<String> result, StringBuilder curr, int max, int open, int close ){
        if(max * 2 == curr.length()){
            result.add(curr.toString());
            return;
        }
        if(open < max){
            curr.append("(");
            generateAllParenthesis2(result, curr, max, open + 1, close );
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open){
            curr.append(")");
            generateAllParenthesis2(result, curr, max, open, close + 1 );
            curr.deleteCharAt(curr.length() - 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<String> arr = new ArrayList<>();
        arr.add(new String(stringBuilder));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

    }





    public static void main(String[] args) {
        generateParenthesis2(3);
    }
}
