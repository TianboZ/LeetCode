package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word){
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), word, 0);
        System.out.println(ans);
        return ans;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder sb, String word, int index){
        // base-case
        System.out.println(sb.toString());
        if(index == word.length()){
            ans.add(sb.toString());
            return;
        }
        // not abbr
        sb.append(word.charAt(index));
        backtrack(ans, sb, word, index + 1);
        sb.deleteCharAt(sb.length() - 1);

        // abbr
        if (sb.length() > 0 && Character.isDigit(sb.charAt(sb.length() - 1))) {
            int i = 0;
            while (sb.length() > 0 && Character.isDigit(sb.charAt(sb.length() - 1))) {
                i++;
            }
            int num = Integer.parseInt(sb.substring(sb.length() - i, sb.length()));

            sb.setLength(sb.length() - i);
            int len = sb.length();
            sb.append(num + 1);
            backtrack(ans, sb, word, index + 1);
            sb.setLength(len);
            sb.append(num);
        } else {
            sb.append(1);
            backtrack(ans, sb, word, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }


    }

    public static void main(String[] args) {
        GeneralizedAbbreviation generalizedAbbreviation = new GeneralizedAbbreviation();
        generalizedAbbreviation.generateAbbreviations("word");
    }
}
