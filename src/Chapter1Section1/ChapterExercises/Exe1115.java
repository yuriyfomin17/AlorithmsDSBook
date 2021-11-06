package Chapter1Section1.ChapterExercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exe1115 {
    public static void main(String[] args) {
    }

    static public void exe1115() { // ✅ checked
        int[] array = {1, 2, 3, 9};
        int M = 7;
        int[] result = new int[M];
        HashMap<Integer, Integer> info = new HashMap();
        for (int el : array) {
            if (info.containsKey(el)) info.put(el, info.get(el) + 1);
            else info.put(el, 1);
        }
        for (Map.Entry<Integer, Integer> entry : info.entrySet()) {
            if (entry.getKey() < result.length) result[entry.getKey()] = entry.getValue();
        }
        System.out.println(Arrays.toString(result));
    }
}
