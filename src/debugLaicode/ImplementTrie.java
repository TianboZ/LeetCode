package debugLaicode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementTrie {

    // helper class
    class Node {
        boolean isWord;
        Map<Character, Node> neighbors;
        Node() {
            this.neighbors = new HashMap<>();
        }
    }

    // fields
    Node root;

    // constructor
    /** Initialize your data structure here. */
    public ImplementTrie() {
        this.root = new Node();
    }

    // APIs
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            Node next = curr.neighbors.get(word.charAt(i));
            if (next == null) {
                next = new Node();
                curr.neighbors.put(word.charAt(i), next);
            }
            curr = next;
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            Node next = curr.neighbors.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            curr = next;
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node start = findPrefix(prefix);
        if (start == null) return false;
        return dfs(start);
    }
    private Node findPrefix(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            Node next = curr.neighbors.get(s.charAt(i));
            if (next == null) {
                return null;
            }
            curr = next;
        }
        return curr;
    }
    private boolean dfs(Node start) {
        // base-case
        if (start.neighbors.size() == 0) {
            if (start.isWord) return true;
            return false;
        }

        // recursive rule
        if (start.isWord) return true;
        for (Map.Entry<Character, Node> entry: start.neighbors.entrySet()) {
            if (dfs(entry.getValue())) return true;
        }
        return false;
    }

    // search with  regular expression
    public boolean searchWithRegularExpression(String word) {
        return dfs(word, 0 ,root);
    }
    private boolean dfs( String s, int index, Node node) {
        // base-case
        if (index == s.length()) {
            if (node.isWord) return true;
            return  false;
        }
        if (node.neighbors.size() == 0 ) {
            return  false;
        }
        // rule
        Character c = s.charAt(index);
        if (c == '.') {
            for (Map.Entry<Character, Node> entry : node.neighbors.entrySet()) {
                if (dfs(s, index + 1, entry.getValue())) return true;
            }
        } else {
            Node next = node.neighbors.get(c);
            if (next != null && dfs( s, index + 1, next)) {
                return true;
            }
        }
        return false;
    }
}