package Chapter1Section1.ChapterExercises;

public class Exe1114 {
    public static void main(String[] args) {
    }

    static public void exe1114() { // ✅ checked
        // Write a static method lg() that takes an int
        // value N as argument and returns the largest int not larger than the base-2 logarithm of N. Do not use Math.
        // log2(N) = ln(N)/ln(2) = x
        // ln(N) =  ln(2) * x
        // apply rule of exponents => N = 2^x
        int N = 17;
        int accumulator = 1;
        int powerOfTwoCount = 0;
        while (accumulator * 2 <= N) {
            powerOfTwoCount += 1;
            accumulator *= 2;
        }

        System.out.println((powerOfTwoCount));
    }
}
