class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > (n + 1 / 2)) {
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[] { i, freq[i] });
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            sb.append((char) ('a' + curr[0]));
            curr[1]--; //reduce frequency by 1
            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }
            prev = curr;
        }
        return sb.length() == n ? sb.toString() : "";
    }
}
