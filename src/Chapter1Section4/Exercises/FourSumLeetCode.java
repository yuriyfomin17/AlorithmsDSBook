package Chapter1Section4.Exercises;

import java.util.*;

class FourSumLeetCode {
    public static void main(String[] args) {
        int[] arr1 = {1,0,-1,0,-2,2};
        fourSum(arr1, 0);
    }
    static public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int N = nums.length;
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j ++){
                int twoSumTarget = target - (nums[i] + nums[j]);
                int low = j + 1;
                int high = nums.length - 1;
                // System.out.println();
                // System.out.println("nums[i]:" + nums[i]);
                // System.out.println("nums[j]:" + nums[j]);
                // System.out.println("twoSumTarget:" + twoSumTarget);
                while(low < high){
                    int sum = nums[low] + nums[high];
                    if(sum < twoSumTarget) low++;
                    else if(sum > twoSumTarget) high--;
                    else {
                        String key = "" + nums[i] + nums[j] + nums[low] + nums[high];
                        if(!hashSet.contains(key)){
                            List<Integer> list = new ArrayList<>();

                            list.add(nums[low]);
                            list.add(nums[high]);
                            list.add(nums[i]);
                            list.add(nums[j]);

                            result.add(list);

                            hashSet.add(key);
                        }

                        low++;

                    };

                }
            }
        }
        return result;
    }
}