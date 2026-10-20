class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] track = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            track[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        int init = left;
        while (right < s2.length()) {
            if (track[s2.charAt(right) - 'a'] > 0) {
                track[s2.charAt(right) - 'a']--;
                left++;
                boolean found = true;
                for (int i = 0; i < track.length; i++) {
                    if (track[i] > 0) {
                        found = false;
                    }
                }
                if (found) {
                    return true;
                }
            }
            else {
                if (left > init) {
                    for (int k = init; k < left; k++) {
                        track[s2.charAt(k) - 'a']++;     
                    }
                    init++;
                    left = init;
                    right = init - 1;                  
                } 
                else {
                    init = right + 1;         
                    left = right + 1;
                }
            }
            right++;
        }
        return false;
    }
}
