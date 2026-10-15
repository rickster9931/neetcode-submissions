class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode traverse = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (traverse.children[index] == null) {
                traverse.children[index] = new TrieNode();
            }
            traverse = traverse.children[index];
        }
        traverse.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(TrieNode node, String word, int i) {
        if (i == word.length()) {
            if (node.isEnd) {
                return true;
            }
            return false;
        }
        if (word.charAt(i) != '.') {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
            return dfs(node, word, i+1);
        }   
        else {
            for (int j = 0; j < node.children.length; j++) {
                if (node.children[j] != null) {
                    if (dfs(node.children[j], word, i+1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
