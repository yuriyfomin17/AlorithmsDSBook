package Chapter1Section4.Exercises;

public class Exe144TwoSumTable {

    static class TwoSum{
        public int count(int[] arr){
            int cnt = 0; // A
            for (int i = 0; i < arr.length; i++) { // B block
                for (int j = 0; j < arr.length; j++) { // C block
                    if (arr[i] + arr[j] == 0) cnt++; //   D block
                }
            }
            return cnt;
        }
    }

    /** TODO
     * table for time execution for TwoSum
     *
     *        statement block      time in seconds            frequency            total time
     *              D                   t0               x depends on input            t0 * x
     *              C                   t1                  (N^2 - N) / 2              t1 * ((N^2 - N) / 2)
     *              B                   t2                      N                      t2 * N
     *              A                   t3                      1                       t3
     *    Grand total: (t1/2) * N^2
     *                      + (-t1/2 + t2) * N
     *                      + t3 + t0x
     *   Tilde approximation:  (t1 / 2 ) N^2 assuming x is small
     *   Order of growth: N^2
     */

}
