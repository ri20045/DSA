class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        if (n == 1) return s;
        for (int i=0; i<n; i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i+1);
            if (odd.length() > longest.length()) longest = odd;
            if (even.length() > longest.length()) longest = even;
        }
        return longest;
    }

    public String expand (String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
