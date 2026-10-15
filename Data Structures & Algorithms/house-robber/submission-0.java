class Solution {
    public int rob(int[] nums) {
        int[] tracker = new int[nums.length];
        return helper(nums, tracker, 0);
    }

    public int helper(int[] nums, int[] tracker, int index) {
        if (index == (nums.length - 1)) {
            return nums[nums.length - 1];
        }
        if (index == nums.length) {
            return 0;
        }
        if (tracker[index] != 0) {
            return tracker[index];
        }
        int sum = Math.max(nums[index] + helper(nums, tracker, index+2), helper(nums, tracker, index+1));
        tracker[index] = sum;
        return sum;

    }
}
