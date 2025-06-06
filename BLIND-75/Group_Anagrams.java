class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a'] ++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int i=0; i<26; i++) {
                keyBuilder.append(count[i]).append('#');
            }
            String key = keyBuilder.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
