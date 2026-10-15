class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] tracker = new int[amount];
        int result = helper(coins, amount, tracker);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int helper(int[] coins, int amount, int[] tracker) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        int minimum = Integer.MAX_VALUE;
        if (tracker[amount-1] != 0) {
            return tracker[amount-1];
        }
        for (int i = 0; i < coins.length; i++) {
            int calculate = helper(coins, amount - coins[i], tracker);
            if (calculate == Integer.MAX_VALUE) {
                continue;
            }
            minimum = Math.min(minimum, 1 + calculate);
        }
        tracker[amount-1] = minimum;
        return minimum;
    }
}
