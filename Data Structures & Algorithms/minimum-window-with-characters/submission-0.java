class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int missing = t.length();
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need[c] > 0) {
                missing--;
            }
            need[c]--;

            while (missing == 0) {
                if (right - left + 1 < bestLen) {
                    bestStart = left;
                    bestLen = right - left + 1;
                }
                char l = s.charAt(left);
                need[l]++;
                if (need[l] > 0) {
                    missing++;
                }
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}