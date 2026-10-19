class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> master = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            HashSet<Integer> traverse = new HashSet<>();
            for (int j = i+1; j < nums.length; j++) {
                if (traverse.contains(target-nums[j])) {
                    master.add(List.of(nums[i], nums[j], target-nums[j])); 
                }
                traverse.add(nums[j]);
            }
        }
        return new ArrayList<>(master);
    }
}
