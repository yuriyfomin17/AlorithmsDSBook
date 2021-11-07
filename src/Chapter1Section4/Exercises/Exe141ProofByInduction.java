package Chapter1Section4.Exercises;

public class Exe141ProofByInduction {

}
/** TODO Prove by Induction
 * Show that the number of different triples that can be chosen from N items
 * precisely (N * (N - 1) * (N - 2))/ 6
 */

/** PROOF
 * When choosing item there are N possibilities
 * when choosing next item there are N - 1 possibilities
 * when choosing next item there are N - 2 possibilities
 *
 * if the order of items would matter then all together number of different triples that
 * could be chosen, would be N * (N - 1) * (N - 2). However, result doesn't matter
 * Hence, all possible outcomes from 3 items is 3! = 6.
 * Hence, number of different triples that could be chosen is (N * (N - 1) * (N - 2))/ 6
 *
 * By induction:
 * lets consider number of triples that can be chosen to be P(N) =  (N * (N - 1) * (N - 2)) / 6
 * Consider base cases
 *  P(1) = (1 * 0 * -1) / 6 = 0
 *  P(2) = (2 * -1 * 0) / 6 = 0
 *  P(3) = (3 * 2 * 1 ) / 6 = 1
 *
 *  So, base cases hold
 *
 *  Now if we assume that number of triples that could be chosen from N is (N * (N - 1) * (N - 2))/ 6
 *  and we prove that P(N + 1) = ((N + 1) * N * (N - 1)) / 6
 *  then P(N) holds for any arbitrary N
 *
 *  P(N + 1) = P(N) + (number of new triples that contain the newly inserted N + 1)
 *  There are exactly "N choose K" new triples that contain N + 1 so
 *
 *  P(N + 1) = P(N) + N! / 2!(N - 2)!
 *           = P(N) + N(N - 1) / 2
 *           = (N * (N - 1) * (N - 2))/ 6  + 3 * N * (N - 1) / 6
 *           = (N  * (N - 1) * ( N + 1 )) / 6
 */

