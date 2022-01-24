package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    /**
    *   <h2>Time and Space Complexity Analysis</h2>
    *  <p> Time complexity: O(2^2n * n). For each of 2^2n sequences, we need to create and validate the
     *  the sequence, which takes O(n) work</p>
     *
     *  <p>Space complexity: O(2^2n * n). Naively every sequence could be valid</p>
    *
    * */
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
}
