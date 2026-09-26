class Solution {
    public int maxProfit(int[] prices) {
        int one = 0;
        int two = 1;
        int output = 0;
        while (two < prices.length) {
            if (prices[two] < prices[one]) {
                one = two;
            }
            else {
                if (prices[two] - prices[one] > output) {
                    output = prices[two] - prices[one];
                }
            }
            two++;
        }  
        return output; 
    }
}
