package LeetCode;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int firstIndex = nums.length - 2;

        while (firstIndex >= 0 && nums[firstIndex] >= nums[firstIndex + 1]) {
            firstIndex--;
        }
        if (firstIndex == -1) {
            reverse(nums, 0);
            return;
        }

        int secondIndex = firstIndex  + 1;
        while (secondIndex < nums.length && nums[secondIndex] > nums[firstIndex]) {
            secondIndex++;
        }
        secondIndex--;

        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.printf("%d,", nums[i]);
//        }
    }

    public static void swap(int[] nums, int firstIndex, int secIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secIndex];
        nums[secIndex] = temp;
    }

    public static void reverse(int[] nums, int start) {
        for (int i = 0; i < (nums.length - start) / 2; i++) {
            swap(nums, start + i, nums.length - 1 - i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        int[] nums1 = {1, 2, 3}; // [1, 3, 2]
        int[] nums2 = {3, 2, 1}; // [1, 2, 3]
        int[] nums3 = {1, 1, 5}; // [1, 5, 1]
        int[] nums4 = {1, 5, 1}; // [5, 1, 1]

//        nextPermutation(nums);
        nextPermutation(nums4);
    }
}
