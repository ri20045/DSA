class WordDictionary {

    private class TrieNode {
        TrieNode[] links;
        boolean flag;

        TrieNode () {
            links = new TrieNode[26];
            flag = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.links[index] == null)
                node.links[index] = new TrieNode();
            node = node.links[index];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] word, int i, TrieNode node) {
        if (i == word.length) {
            return node.flag;
        }
        char c = word[i];

        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.links[j] != null && dfs(word, i+1, node.links[j])) {
                    return true;
                }
            }
            return false;
        }
        else {
            int index = c - 'a';
            if (node.links[index] == null) return false;
            return dfs(word, i+1, node.links[index]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
