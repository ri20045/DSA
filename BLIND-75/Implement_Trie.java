class Trie {

    private class TrieNode {
        TrieNode[] links;
        boolean flag;

        TrieNode() {
            links = new TrieNode[26];
            flag = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.links[index] == null) {
                node.links[index] = new TrieNode();
            }
            node = node.links[index];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.links[index] == null) {
                return false;
            }
            node = node.links[index];
        }
        return node.flag;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.links[index] == null) {
                return false;
            }
            node = node.links[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
