package debugLaicode;

import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImplementTrie {

    public TrieNode root;

    public ImplementTrie() {
        this.root = new TrieNode();
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            cur = next;

        }

        return cur.isWord;
    }

    public void delete(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                return;
            }
            cur = next;

        }

        cur.isWord = false;
    }

    public boolean startWith(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            cur = next;

        }

        return dfs(cur);
    }
    private boolean dfs(TrieNode node) {
        // base-case
        if (node == null) {
            return false;
        }
        if (node.isWord) {
            return true;
        }
        // recursive rule

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            if (dfs(entry.getValue())) {
                return true;
            }
        }

        return false;
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                next = new TrieNode();
                cur.children.put(word.charAt(i), next);
            }
            cur = next;

        }
        cur.isWord = true;
    }


    public void searchAllWithPrefix(String prefix) {
        // step1: search prefix
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = cur.children.get(prefix.charAt(i));
            if (next == null) {
                return;
            }
            cur = next;

        }
        // step2: find all words with this prefix
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(prefix);
        searchAllWithPrefix(cur, res, sb);
        System.out.println(sb.toString());
        System.out.println(res);
    }
    private void searchAllWithPrefix(TrieNode node, List<String> res, StringBuilder sb) {
        // baes-caes
        if (node == null) {
            return;
        }

        // recursive rule
        if (node.isWord) {
            res.add(sb.toString());
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            sb.append(entry.getKey());
            searchAllWithPrefix(entry.getValue(), res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public void findAllWordsWithWildcard(String target) {
        if (target == null || target.length() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        TrieNode cur = root;
        findAllWordsWithWildcard(target, 0, sb, res, cur);
        System.out.println(res);
    }
    private void findAllWordsWithWildcard(String target, int index, StringBuilder sb, List<String> res, TrieNode cur) {
        // base-case
        if (index == target.length()) {
            if (cur.isWord) {
                res.add(sb.toString());
            }
            return;
        }
        // recursive rule
        char toMatch = target.charAt(index);
        if (toMatch == '?') {
            for (Map.Entry<Character, TrieNode> entry : cur.children.entrySet()) {
                sb.append(entry.getKey());
                findAllWordsWithWildcard(target, index + 1, sb, res, entry.getValue());
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            TrieNode next = cur.children.get(toMatch);
            if (next != null) {
                sb.append(toMatch);
                findAllWordsWithWildcard(target, index + 1, sb, res, next);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public static void main(String[] args) {
        ImplementTrie implementTrie = new ImplementTrie();

        implementTrie.insert("leetcode");
        implementTrie.insert("leetcode1");
        implementTrie.insert("leetcode2");
        implementTrie.insert("leetcode3");
        System.out.println(implementTrie.search("leet"));
        System.out.println(implementTrie.startWith("leet"));
        //implementTrie.delete("leetcode");
        System.out.println(implementTrie.startWith("leet"));
        System.out.println(implementTrie.search("leetcode"));
        implementTrie.searchAllWithPrefix("leet");
        implementTrie.findAllWordsWithWildcard("leet?ode?");
    }
}
