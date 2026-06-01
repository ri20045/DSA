class Solution {
    public int minAddToMakeValid(String s) {
        int open_count = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open_count++;
            } else {
                if (open_count == 0) {
                    res += 1;
                }
                open_count = Math.max(open_count - 1, 0);
            }
        }
        return open_count + res;
    }

}
