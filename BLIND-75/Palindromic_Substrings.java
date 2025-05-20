class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for (int i=0; i<n; i++) {
            res += countPalindrome(s, i, i);
            res += countPalindrome(s, i, i+1);
        }
        return res;
    }

    public int countPalindrome(String s, int left, int right) {
        int res = 0;
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(right) == s.charAt(left)) {
            res += 1;
            left --;
            right ++;
        }
        return res;
    }
}
