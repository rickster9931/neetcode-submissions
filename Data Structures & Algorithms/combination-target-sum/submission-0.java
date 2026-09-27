class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> finalize = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> create = new ArrayList<>();
            create.add(nums[i]);
            eachVal(finalize, create, nums, i, target - nums[i]);
        }
        return finalize;
    }

    public void eachVal(List<List<Integer>> finalize,List<Integer> current, int[] nums, int start, int target) {
        if (target == 0) {
            finalize.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            eachVal(finalize, current, nums, i, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }
}
