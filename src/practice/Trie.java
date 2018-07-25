package practice;

import java.util.*;

public class Trie {
    // helper class
    private class TrieNode {
        // fields
        boolean isWord;
        Map<Character, TrieNode> children;

        // constructor
        private TrieNode() {
            this.children = new HashMap<>();
        }

        // API
    }

    // fields
    private TrieNode root;

    // constructor
    public Trie() {
        this.root = new TrieNode();
    }

    // API
    // 踩着石头过河
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isWord; // important!!! check if it is word
    }

    // 踩着石头过河，如果踩空了，退回来，放一块新石头，继续采石头过河
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                // new TireNode
                next = new TrieNode();
                cur.children.put(word.charAt(i), next);
            }
            cur = next;
        }
        // set isWord
        cur.isWord = true;
    }

    // simple version, if find the word, then just set isWord false
    // drawback: space waste
    public void delete(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                return;
            }
            cur = next;
        }
        // set isWord false
        cur.isWord = false;
    }

    // Trie is basic data structure!!! because of search engine!!!

    // question1: find all the words with a given prefix
    // e.g. searchAllWithPrefix("ca") = ["cat", "catty", "cathy"]
    public List<String> searchAllWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();

        // step1: search prefix
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = cur.children.get(prefix.charAt(i));
            if (next == null) {
                return res;
            } else {
                cur = next;
            }
        }

        // step2: find all words with given prefix
        StringBuilder sb = new StringBuilder(prefix);
        searchAllWithPrefix(cur, res, sb);
        System.out.println(res);
        return res;
    }

    private void searchAllWithPrefix(TrieNode node, List<String> res, StringBuilder path) {
        // baes-caes
        if (node.children.size() == 0) {
            if (node.isWord) {
                res.add(path.toString());
            }
            return;
        }

        // recursive rule
        if (node.isWord) {
            res.add(path.toString());
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            path.append(entry.getKey());
            searchAllWithPrefix(entry.getValue(), res, path);
            path.deleteCharAt(path.length() - 1);
        }

    }

    // question2: find all the words with wildcard
    // e.g. findAllWordsWithWildcard("ca?") = ["cat", "cap"]
    public List<String> findAllWordsWithWildcard(String target) {
        List<String> res = new ArrayList<>();
        if (target == null || target.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        TrieNode cur = root;
        findAllWordsWithWildcard(target, 0, sb, res, cur);
        System.out.println(res);
        return res;
    }

    // find all words from root node
    private void findAllWordsWithWildcard(String target, int index,
                                          StringBuilder path, List<String> res, TrieNode root) {
        // base-case
        if (index == target.length()) {
            if (root.isWord) {
                // dont forget, it is a word!!!
                res.add(path.toString());
            }
            return;
        }
        // recursive rule
        char toMatch = target.charAt(index);
        if (toMatch == '?') {
            for (Map.Entry<Character, TrieNode> child : root.children.entrySet()) {
                path.append(child.getKey());
                findAllWordsWithWildcard(target, index + 1, path, res, child.getValue());
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            TrieNode next = root.children.get(toMatch);
            if (next != null) {
                path.append(toMatch);
                findAllWordsWithWildcard(target, index + 1, path, res, next);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // usually used operation: search, delete, add
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("catty");
        trie.insert("catch");
        trie.insert("cater");
        trie.insert("cc");

        System.out.println(trie.search("cat"));

        trie.searchAllWithPrefix("ca");

        trie.findAllWordsWithWildcard("catt?");

        boolean res = trie.search("catt");

        trie.delete("cat");
        trie.searchAllWithPrefix("ca");
    }
}