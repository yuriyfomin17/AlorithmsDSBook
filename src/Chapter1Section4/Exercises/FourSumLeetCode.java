package Chapter1Section4.Exercises;

import java.util.*;

class FourSumLeetCode {
    public static void main(String[] args) {
        int[] arr1 = {1,0,-1,0,-2,2};
        fourSum(arr1, 0);
    }
    static public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0] == nums[nums.length - 1] && nums.length >= 4 && 4 * nums[0] == target ){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            list.add(nums[0]);
            list.add(nums[0]);
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        HashMap<Integer, Integer> hashIndexNum = new HashMap<>();
        HashMap<Integer, Integer> hashNumIndex = new HashMap<>();
        HashMap<Integer, Integer> hashNumCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(!hashIndexNum.containsKey(i)){
                hashIndexNum.put(i, num);
            }
            if (!hashNumIndex.containsKey(num)) hashNumIndex.put(num, i);
            if(!hashNumCount.containsKey(num)) hashNumCount.put(num, 1);
            else hashNumCount.put(num, hashNumCount.get(num) + 1);

        }
        HashSet<String> hashSet = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry1: hashIndexNum.entrySet()){
            for(Map.Entry<Integer, Integer> entry2: hashIndexNum.entrySet()){
                for(Map.Entry<Integer, Integer> entry3: hashIndexNum.entrySet()){
                    int num1 = entry1.getValue();
                    int num2 = entry2.getValue();
                    int num3 = entry3.getValue();

                    int num1Index = entry1.getKey();
                    int num2Index = entry2.getKey();
                    int num3Index = entry3.getKey();

                    int key = target - (num1 + num2 + num3);

                    if (num1Index < num2Index && num2Index < num3Index && hashNumCount.containsKey(key)){
                        int count = hashNumCount.get(key) - 1;
                        int keyIndex = hashNumIndex.get(key);

                        if (keyIndex + count > num3Index || keyIndex < num1Index){
                            List<Integer> list = new ArrayList<>();
                            String currKey = "";
                            if (keyIndex < num1Index) {
                                list.add(key);
                                currKey+= key;
                            }

                            list.add(num1);
                            currKey += num1;
                            list.add(num2);
                            currKey += num2;
                            list.add(num3);
                            currKey += num3;
                            if (keyIndex + count > num3Index ) {
                                list.add(key);
                                currKey += key;
                            }
                            if (!hashSet.contains(currKey) && list.size() == 4) result.add(list);
                            hashSet.add(currKey);
                        }

                    }
                }
            }
        }
        return result;
    }
}