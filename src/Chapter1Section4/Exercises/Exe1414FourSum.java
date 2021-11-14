package Chapter1Section4.Exercises;

public class Exe1414FourSum {
    public static int countFourSum(int[] arr){
        int N = arr.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N ; j++) {
                for (int k = j; k < N; k++) {
                    for (int l = k; l < N; l++) if (arr[i] + arr[j] + arr[k] + arr[l] == 0) cnt++;
                }

            }

        }
        return cnt;
    }
}
