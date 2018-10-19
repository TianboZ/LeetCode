package MianJing.thumbtack;

import practice.Trie1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    // helper class
    private class TrieNode {
        // fields
        boolean isWord;
        Map<Character, TrieNode> children;

        // constructor
        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    // fiedls
    private TrieNode root;

    // construtor
    public Trie() {
        this.root = new TrieNode();
    }

    // api
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = curr.children.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            curr = next;
        }
        return curr.isWord;
    }

    // 踩着石头过河，如果踩空了，退回来，放一块新石头，继续采石头过河
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = curr.children.get(word.charAt(i));
            if (next == null) {
                next = new TrieNode();
                curr.children.put(word.charAt(i), next);
            }
            curr = next;
        }
        curr.isWord = true;
    }


    public void delete(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                // this word is not exist
                return;
            }
            cur = next;
        }
        // set isWord false
        cur.isWord = false;
    }


    public List<String> wordsStartWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        // step 1: find the prefix
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = curr.children.get(prefix.charAt(i));
            if (next == null) {
                return res; // prefix is not exist
            } else {
                curr = next;
            }
        }

        // step2: run dfs start from the last TrieNode of prefix
        StringBuilder path = new StringBuilder();
        path.append(prefix);
        dfs(curr, path, res);
        System.out.println(res);
        return res;
    }

    private void dfs(TrieNode root, StringBuilder path, List<String> res) {
        // baes-caes
        if (root.children.size() == 0) {
            if (root.isWord) {
                res.add(path.toString());
            }
            return;
        }

        // recursive rule
        if (root.isWord) {
            res.add(path.toString());
        }

        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            path.append(entry.getKey());
            dfs(entry.getValue(), path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> wordsWithWildcard(String target) {
        List<String> res = new ArrayList<>();
        if (target == null || target.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        TrieNode curr = root;
        wordsWithWildcard(0, res, curr, target, sb);
        System.out.println(res);
        return res;
    }

    private void wordsWithWildcard(int index, List<String> res, TrieNode root, String word, StringBuilder path) {
        // base-case
        if (index == word.length()) {
            if (root.isWord) {
                res.add(path.toString());
            }
            return;
        }
        // recursive rule
        char c = word.charAt(index);
        if (c == '?') {
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                path.append(entry.getKey());
                wordsWithWildcard(index + 1, res, entry.getValue(), word, path);
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                if (c == entry.getKey()) {
                    path.append(entry.getKey());
                    wordsWithWildcard(index + 1, res, entry.getValue(), word, path);
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        // usually used operation: search, delete, add
        Trie1 trie1 = new Trie1();
        trie1.insert("cat");
        trie1.insert("catty");
        trie1.insert("catch");
        trie1.insert("cater");
        trie1.insert("cc");

        System.out.println(trie1.search("catty"));


        trie1.wordsStartWithPrefix("ca");

        trie1.wordsWithWildcard("catt?");

        boolean res = trie1.search("catt");

        trie1.delete("cat");
        trie1.wordsStartWithPrefix("ca");
    }
}


