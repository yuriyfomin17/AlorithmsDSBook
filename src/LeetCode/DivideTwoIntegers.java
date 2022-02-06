package LeetCode;

public class DivideTwoIntegers {
    /**
     *
     *  <h2>Task:Given Two Integers divide them without using multiplication, division, subtraction.
     *  Input integers will be in range of [Integer.MIN_VALUE, Integer.MAX_VALUE]</h2>
     *  <h3>Time and Complexity Analysis</h3>
     *
     *  <p> Time Complexity: log(N)</p>
     e
     *  <p> Space Complexity: O(1) </p>
     *
     * */
    public static void main(String[] args) {

    }

    public static int divideTwoIntegers(int dividend, int divisor){
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        int sign = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? 1: -1;
        while (a - b >= 0){
            int x = 0;
            while (a - (b << 1 << x) >= 0) x++;
            a -= b << x;
            res += 1 << x;
        }
        return res * sign;
    }

}
