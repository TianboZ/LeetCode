package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;
    public TrieNode() {
        this.children = new HashMap<>();
    }
}
