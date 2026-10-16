class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] accomp = new int[nums.length];
        int max = 1;
        for (int i = nums.length-1; i > 0; i--) {
            int temp = helper(nums, i, accomp);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
    public int helper(int[] nums, int index, int[] accomp) {
        if (index == 0) {
            return 1;
        }
        int maximum = 1;
        if (accomp[index] != 0) {
            return accomp[index];
        }
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index]) {
                int tracker = 1 + helper(nums, i, accomp);
                if (tracker > maximum) {
                    maximum = tracker;
                }
            }
        }
        accomp[index] = maximum;
        return maximum;
    }
}
