class Solution {
    public boolean isPalindrome(String s) {

        // if (s.length() == 0) return true;
        // String result = s.replaceAll("[^a-zA-Z0-9]", "");
        // String lowerString = result.toLowerCase();
        // String reversed = new StringBuilder(lowerString).reverse().toString();
        // return (reversed.equals(lowerString));

        //2nd approach TC=O(n) SC=O(1)

        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            while ((left < right) && !alphaNum(s.charAt(left))){
                left += 1;
            }
            while ((right > left) && !alphaNum(s.charAt(right))){
                right -= 1;
            }
            if (Character.toLowerCase(s.charAt(right)) != Character.toLowerCase(s.charAt(left))) return false;
            left += 1;
            right -= 1;
        }
        return true;

    }
    public boolean alphaNum(char c) {
        int ascii = (int) c;
        return ((ascii >= 'A' && ascii <= 'Z') || (ascii >= 'a' && ascii <= 'z') || (ascii >= 48 && ascii <= 57));
    }
}
