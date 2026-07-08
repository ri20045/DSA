class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26)
                return true;
            int idx = s2.charAt(right) - 'a';
            s2Count[idx]++;
            if (s2Count[idx] == s1Count[idx]) {
                matches++;
            } else if (s2Count[idx] == s1Count[idx] + 1) {
                matches--;
            }
            idx = s2.charAt(left) - 'a';
            s2Count[idx]--;
            if (s2Count[idx] == s1Count[idx]) {
                matches++;
            } else if (s2Count[idx] == s1Count[idx] - 1) {
                matches--;
            }
            left++;
        }
        return matches == 26;
    }
}
