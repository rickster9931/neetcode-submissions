class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter = Math.max(nums[i], counter + nums[i]);
            if (counter > sum) {
                sum = counter;
            }
        }
        return sum;
    }
}
