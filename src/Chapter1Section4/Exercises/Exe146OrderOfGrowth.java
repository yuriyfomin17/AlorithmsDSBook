package Chapter1Section4.Exercises;

public class Exe146OrderOfGrowth {

    public static void aMethod(int N){
        int sum = 0; // A
        for (int n = N; n > 0 ; n /= 2) {  // B
            for (int i = 0; i < n; i++) { // C
                sum++; // D
            }
        }
    }
    /** Time execution table for aMethod
     *       statement block      time in seconds            frequency               total time
     *              D                   t0              x depends on input              x * t0
     *              C                   t1         N + N/2 + N/4 + N/8 + .... + 1    N + N/2 + N/4 + N/8 + .... + 1 => geometric series converges to 2N
     *              B                   t2                      ln(N)                ln(N) * t2
     *              A                   t3                         1                    t3
     *       Grand Total: x * t0 + t1 * 2N + t2 * ln(N) + t3
     *       Tilde approx: ~ t1 *  2N
     *       Order of growth: N
     *
     */

    public static void bMethod(int N){
        int sum = 0; // A
        for (int i = 1; i < N ; i *= 2) { // B
            for (int j = 0; j < i; j++) { // C
                sum++; // D
            }
        }
    }
    /** Time execution table for bMethod
     *       statement block      time in seconds            frequency                                  total time
     *              D                   t0              x depends on input                                x * t0
     *              C                   t1              N * (1, 2, 4, ..., 2^log(N))                       ln(N)
     *              B                   t2                      ln(N)                                 ln(N) * t2
     *              A                   t3                         1                                    t3
     *       Grand Total: x * t0 + t1 * 2N + t2 * ln(N) + t3
     *       Tilde approx: ~ t1 *  2N
     *       Order of growth: N
     *
     */

    public static void cMethod(int N){
        int sum = 0; // A
        for (int i = 1; i < N ; i *= 2) { // B
            for (int j = 0; j < N; j++) { // C
                sum++; // D
            }
        }
    }

    /** Time execution table for bMethod
     *       statement block      time in seconds            frequency                                  total time
     *              D                   t0                   x depends on input                             x * t0
     *              C                   t1                      N * ln(N)                                N * ln(N) * t1
     *              B                   t2                      ln(N)                                    ln(N) * t2
     *              A                   t3                         1                                        t3
     *       Grand Total: x * t0 + N * ln(N) * t1 + ln(N) * t2 + t3
     *       Tilde approx: ~ t1 *  N * ln(N)
     *       Order of growth: N * ln(N)
     *
     */
}
