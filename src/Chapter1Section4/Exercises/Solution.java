package Chapter1Section4.Exercises;

import java.util.HashMap;

class Solution {
    static HashMap<String, Integer> hashMap = new HashMap<>();
    public int superEggDrop(int k, int n) {
        return superEggDrop2(k, n);
    }

    public static int superEggDrop2(int k, int n) {
        String key = "" + k + n;
        if(n == 1 || n == 0 || k == 1) {
            hashMap.put(key, n);
            return n;
        }
        else if(hashMap.containsKey(key)) return hashMap.get(key);
        int minNum = Integer.MAX_VALUE;
        for(int x = 1; x< n; x++ ){
            String key1 = "" + (k  - 1) + ( x - 1);
            String key2 = "" + (k) + (n - x);
            int num1 =  !hashMap.containsKey(key1) ? superEggDrop2(k - 1, x - 1) : hashMap.get(key1);
            int num2 = !hashMap.containsKey(key2) ? superEggDrop2(k, n - x) : hashMap.get(key2);
            minNum = Math.min(minNum, 1 +  Math.max(num1, num2));

        }
        hashMap.put(key, minNum);
        return minNum;

    }
}
