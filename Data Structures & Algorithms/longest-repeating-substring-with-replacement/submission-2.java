class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int left = 0;
        int right = 0;
        int output = 0;
        while (right < s.length()) {
            count[s.charAt(right) - 'A']++;
            if (count[s.charAt(right) - 'A'] > maxCount) {
                maxCount = count[s.charAt(right) - 'A'];
            }
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            if ((right - left + 1) > output) {
                output = right - left + 1;
            }
            right ++;
        }
        return output;
    }
}
