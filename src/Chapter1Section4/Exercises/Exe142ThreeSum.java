package Chapter1Section4.Exercises;
import java.math.BigInteger;

public class Exe142ThreeSum {
    public static void main(String[] args) {

    }
    // handle big integers
    public static int count(int[] array){
        // Count triples that sum to 0
        int length = array.length;
        int count = 0;

        BigInteger bigInteger;
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length ; k++) {
                    bigInteger = BigInteger.valueOf(array[i]);
                    bigInteger = bigInteger.add(BigInteger.valueOf(array[j]));
                    bigInteger = bigInteger.add(BigInteger.valueOf(array[k]));

                    if (bigInteger.intValue() == 0) count++;
                }
            }
        }
        return count;
    }
}
