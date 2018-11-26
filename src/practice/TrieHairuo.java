package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieHairuo {
    // fields
    class Node {
        boolean isWord;
        Map<Character, Node> children;
        List<String> words;

        Node() {
            this.children = new HashMap<>();
            this.words = new ArrayList<>();
        }
    }

    Node root;

    // constructor
    TrieHairuo() {
        this.root = new Node();
    }


    // API
    public void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
                curr.words.add(s);
            } else {
                Node node = new Node();
                curr.children.put(c, node);
                curr = node;
                curr.words.add(s);
            }
        }
        curr.isWord = true;
    }

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

    public List<String> searchWithPrefix(String s) {

        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return null;
            }
        }
        return curr.words;
    }

    public static void main(String[] args) {
        TrieHairuo trieHairuo = new TrieHairuo();
        trieHairuo.insert("apple");
        trieHairuo.insert("app");
        trieHairuo.insert("applebbb");

        System.out.println(trieHairuo.searchWithPrefix("app"));
    }
}
