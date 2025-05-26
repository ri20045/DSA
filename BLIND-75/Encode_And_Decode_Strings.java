public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        String res = "";
        for (String str : strs) {
            res += str.length() + "#" + str;
        }
        return res;
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        int n = str.length();
        int i = 0;

        while (i < n) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j+1, j+1+len);
            res.add(word);
            i = j+1+len;
        }
        return res;
    }
}
