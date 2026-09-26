class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        sum = nums[0];
        counter = 0;
        for num in nums:
            counter = max(num, counter + num);
            if counter > sum:
                sum = counter;
    
        return sum;
        