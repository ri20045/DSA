class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int maxVowel = 0;
        int maxConsonant = 0;

        for (int i=0; i<26; i++) {
            char ch = (char)(i+'a');
            if (isVowel(ch)) {
                maxVowel = Math.max(freq[i], maxVowel);
            }
            else {
                maxConsonant = Math.max(freq[i], maxConsonant);
            }
        }
        return maxVowel + maxConsonant;
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
