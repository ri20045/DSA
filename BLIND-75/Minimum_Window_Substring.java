class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int required = tMap.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && windowCounts.get(c).intValue() == tMap.get(c).intValue()) {
                formed ++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char lChar = s.charAt(left);
                windowCounts.put(lChar, windowCounts.get(lChar) - 1);
                if (tMap.containsKey(lChar) && windowCounts.get(lChar).intValue() < tMap.get(lChar).intValue()) {
                        formed--;
                    }
                left ++;
            }
            right ++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex , startIndex + minLength);
    }
}
