class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums.length == 2) {
            if ((0 + nums[0]) >= 1) {
                return true;
            }
            return false;
        }
        int i = nums.length - 2;
        int reach = nums.length - 1;
        while (i >= 0) {
            while ((i + nums[i]) < reach) {
                i--;
                if (i < 0) {
                    break;
                }
            }
            reach = i;
            if (i != 0) {
                i--;
            }
            else {
                break;
            }
        }
        if (i == 0) {
            return true;
        }
        return false;
    }
}
