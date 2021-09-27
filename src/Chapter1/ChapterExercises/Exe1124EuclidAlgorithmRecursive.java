package Chapter1.ChapterExercises;

public class Exe1124EuclidAlgorithmRecursive {
    public static void main(String[] args) {
    }

    public static void exe1124(){ // ✅ checked
        class EuclidGreatestCommonDivisor{
            public static int gcd(int num, int divisor){
                System.out.printf("Numerator=%d, denominator=%d\n", num, divisor);
                if (num % divisor == 0) return divisor;
                int remainder = num % divisor;
                return gcd(divisor , remainder);
            }
        }
        System.out.println(EuclidGreatestCommonDivisor.gcd(1234567, 1111111));
    }
}
