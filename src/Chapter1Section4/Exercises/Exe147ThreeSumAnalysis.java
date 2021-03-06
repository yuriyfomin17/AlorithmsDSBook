package Chapter1Section4.Exercises;

public class Exe147ThreeSumAnalysis {
}
/** TODO: Analyze ThreeSum under a cost model that counts arithmetic operations (and comparisons) involving the input numbers.
 * with the cost model that counts arithmetic operations and comparisons involving input numbers
 * the main if involves 4 operations instead of 1
 *
 * if (a[i] + a[j] + a[k] == 0)
 *
 * One operation for the if check; one operation to sum a[i] and a[j]; one operation to sum the result with a[k]
 * and one operation to compare the result with 0.
 *
 * Therefore the main "if" has a frequency of 4 (N^3/6 - N^2/2 + N/3) instead of (N^3/6 - N^2/2 + N/3)
 *
 * And the grand total becomes:
 * t1(4N^3/6 - 4N^2/2 + 4N/3) + t2(N^2/2 - N/2) + t3N + t4
 *
 * Tilde approximation: ~(4t1/6)N^3
 * Order of growth: N^3
 *
 */
