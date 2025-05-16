class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int right = 0;
        int left = 0;
        int[] hash = new int[256];
        for (int i=0; i< hash.length; i++) {
            hash[i] = -1;
        }
        while (right < n) {
            char ch = s.charAt(right);
            if (hash[ch] != -1) { //in the map
                if (hash[ch] >= left) {
                    left = hash[ch] + 1;
                }
            }
            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
            hash[ch] = right; // update right
            right ++;
        }
        return maxLength;
    }
}
