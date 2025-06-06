class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else {
                if (st.empty()) return false;
                char c = st.pop();
                if ((ch == '}' && c != '{') || (ch == ')' && c != '(') || (ch == ']' && c != '[')) {
                    return false;
                }
            }
        }
        return st.empty();
    }
}
