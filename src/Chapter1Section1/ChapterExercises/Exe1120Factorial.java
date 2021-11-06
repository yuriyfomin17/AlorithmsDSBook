package Chapter1Section1.ChapterExercises;

public class Exe1120Factorial {
    public static void main(String[] args) {
    }
    public static void exe1120(){ // ✅ checked
        // calculate ln(N!) enhanced by memoization. However, doesn't need it , since recursion calls just one recursive fucntion
        class Factorial{
            public static long F(int N, long[] info){
                if (N == 0) return 1;
                if (info[N-1] != 0) return info[N-1];
                long result =  N * F(N -1, info);
                info[N-1] = result;
                return result;
            }
        }
        System.out.println(Math.log(Factorial.F(5, new long[5])));
    }
}
