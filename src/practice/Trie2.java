package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie2 {
    // fields
    class Node {
        boolean isWord;
        Map<Character, Node> children;
        Node() {
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    Node root;

    // constructor
    Trie2() {
        this.root = new Node();
    }

    // API
    public boolean search(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }
        return curr.isWord;
    }

    public void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                Node node = new Node();
                curr.children.put(c, node);
                curr = node;
            }
        }
        curr.isWord = true;
        return;
    }

    public void delete(String s) {

    }

    public List<String> searchWithPrefix(String s) {
        // find the prefix string
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return null;
            }
        }

        // start from curr node, find all the strings start with prefix
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        dfs(res, curr, sb);
        System.out.println(res);
        return res;

    }
    private void dfs(List<String> res, Node curr, StringBuilder path) {
        // base-case
        if (curr == null) {
            return;
        }
        // recursive rule
        if (curr.isWord) {
            res.add(path.toString());
        }

        for (Map.Entry<Character, Node> entry : curr.children.entrySet()) {
            path.append(entry.getKey());
            dfs(res, entry.getValue(), path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
