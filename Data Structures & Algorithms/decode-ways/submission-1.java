class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return decode(s, 0, memo);
    }

    private int decode(String s, int i, int[] memo) {
        if (i == s.length()) {
            return 1;
        }
        if (i == s.length() - 1) {
            if (s.charAt(i) == '0') {
                return 0;
            }
            return 1;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        boolean firstT = false;
        boolean secondT = false;
        if (s.charAt(i) != '0') {
            firstT = true;
        }
        int two = Integer.parseInt(s.substring(i, i + 2));
        if (two >= 10 && two <= 26) {
            secondT = true;
        }

        int result = 0;
        if (firstT) {
            result += decode(s, i + 1, memo);
        }
        if (secondT) {
            result += decode(s, i + 2, memo);
        }

        memo[i] = result;
        return result;
    }
}