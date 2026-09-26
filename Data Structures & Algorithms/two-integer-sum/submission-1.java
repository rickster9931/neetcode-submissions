class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int save = map.getOrDefault(nums[i], 0);
                int[] give = new int[]{save, i};
                return give;
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}
