package MianJing.thumbtack.OA_Dianmian;

import java.util.*;

/*
* step1:
* for each string in dict, get the standardlized version, e.g. Reed --> rad
* rules: 1. change all letters to smaller case   2. change all consecutive vowels to one letter, which is 'a'
*
* step2:
* store them into map, Map<key: standard string, value: set of original string>
*     Map<String, Set<String>>
* */
public class CorrectMispelledWordDict {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("Red");
        dict.add("Blue");
        dict.add("Yellow");
        dict.add("YelloW");
        dict.add("aaa");
        dict.add("aa");
        System.out.println(correctMispelling(dict, "yellow"));

    }
    public static Set<String> correctMispelling(Set<String> dict, String input) {
        // key: standard string, value: set of original string
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : dict) {
            String std = standard(s);
            Set<String> set = map.get(std);
            if (set == null) {
                set = new HashSet<>();
                map.put(std, set);
            }
            set.add(s);
        }

        Set<String> res = map.get(standard(input));
        return res; // if cannot correct input string, return null

    }
    private static String standard(String s) {
        Set<Character> set = new HashSet<>();
        String str = s.toLowerCase();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length();i++) {
            if (set.contains(str.charAt(i))) {
                // vowel
                while (i < str.length() && set.contains(str.charAt(i))) {
                    i++;
                }
                sb.append('a');
            } else {
                // not vowel
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // time O(mn + k)   n = dict size         m = dict word's average length   k = input string length
    // space O(n)

    ////////////////////////

}


/*
You have a dictionary (set) of words. You need to implement a spellchecker that returns the correct word for an input word.

1. When there is no valid suggestion, your function should return NULL.
2. When there is more than one valid suggestion, return any matching word.
3. When there is no spelling mistake in the input (exact match found), your function should return the same word back.

The spellchecker only handles the following two class of spelling mistakes

1. Capitalization
    * Example 1: <set: {yellow, radish}, input: yelloW, output: yellow>
    * Example 2: <set: {yellow, yelloW, radish}, input: yelloW, output: yelloW>

2. Vowels (letters in the set {a,e,i,o,u}) mixed up - consonants are in the correct order, but one or more vowels in the input word is/are not the same as the vowels in the corresponding dictionary word
    * Example 1: <set: {yellow, radish}, input: yollow, output: yellow>
    * Example 2: <set: {yellow, radish}, input: redosh, output: radish>


    solution:

    map<key: standard, value: set of oritianl strings>

    yelloW --> yellow

    ---------------
    standard rule: yellow --> yallaw
    yelloW -- > yellow --> yalllow


    dict size = n
    time o(n) to build map
    time o(1) to search word

    space o(n)

*/

class Thumbtack {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int a = 1;
        System.out.println(a);

        List<String> list = new ArrayList<>();
        list.add("yellow");
        list.add("radish");
        list.add("raDish"); //
        list.add("yelloW");

        String input = "yellaw"; // vowel wrong: should find yellow, yelloW
        String input1 = "yellaW"; // capital + vowel wrong: should retrun yellow or yelloW
        String input2 = "radish"; // exact word: should find same word, return radish
        String input3 = "aaaa"; // return null

        Dict dict = new Dict(list);

        String res = dict.findCorrectWord(input);
        String res1 = dict.findCorrectWord(input1);
        String res2 = dict.findCorrectWord(input2);

        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
    }


     static class Dict {
        // field

        Map<String, Set<String>> map;  // key: std    value: set of original

        // constructor
        Dict(List<String> list) {
            this.map = new HashMap<>();
            for (String s : list) {
                String std = standard(s);
                Set<String> set = map.get(std);
                if (set == null) {
                    set = new HashSet<>();
                    map.put(std, set);
                }
                set.add(s);
            }
        }

        // api
        // time o(1)
        public String findCorrectWord(String input) {
            String std = standard(input);
            if (map.containsKey(std)) {
                Set<String> originals = map.get(std);
                if (originals.contains(input)) return input; //  find the same word
                // work as iterator
                for (String original : originals) {
                    return original;
                }
                //return "";
            }
            return null;
        }

        private String standard(String s) {
            String str = s.toLowerCase();
            Set<Character> vowels = new HashSet();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u'); // 这里卡了半天，老哥问我怎么优化

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (vowels.contains(str.charAt(i))) {
                    // it is vowel
                    sb.append('a');
                } else {
                    // not vowel
                    sb.append(str.charAt(i));
                }
            }
            return sb.toString();

        }
    }
}

