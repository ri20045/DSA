class Solution {
    public String findOrder(String[] words) {
        // code here
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int minLength = Math.min(first.length(), second.length());
            boolean foundDifference = false;
            
            for (int j = 0; j < minLength; j++) {
                char out = first.charAt(j);
                char in = second.charAt(j);
                
                if (out != in) {
                    if (!graph.get(out).contains(in)) {
                        graph.get(out).add(in);
                        inDegree.put(in, inDegree.get(in) + 1);
                    }
                    foundDifference = true;
                    break;
                }
            }
            
            if (!foundDifference && first.length() > second.length()) {
                return "";
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            
            for (char neighbor : graph.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (sb.length() < graph.size()) {
            return "";
        }
        return sb.toString();
    }
}
