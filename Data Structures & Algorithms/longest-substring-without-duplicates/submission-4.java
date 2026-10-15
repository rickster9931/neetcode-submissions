class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] tracker = new int[128];
        int counter = 0;
        int output = 0;
        int i = 0;
        int prev = i;
        int j = 0;
        while (j < s.length()) {
            if (tracker[s.charAt(i)] == 1) {
                if (counter > output) {
                    output = counter;
                }
                int k = prev;
                while (s.charAt(k) != s.charAt(i)) {
                    tracker[s.charAt(k)] = 0;
                    k++;
                    counter--;
                }
                prev = k + 1;
                i++;
            }
            else {
                tracker[s.charAt(i)] = 1;
                counter++;
                i++;
                if (counter > output) {
                    output = counter;
                }
            }
            j++;
        }
        return output;
    }
}
