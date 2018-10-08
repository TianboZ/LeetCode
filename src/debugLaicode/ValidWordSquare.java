package debugLaicode;


import java.util.ArrayList;
import java.util.List;

/*
store each column in List<String>

for each word in row, compare it with word in the column
*/
public class ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        List<StringBuilder> col = new ArrayList<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (col.size() < i + 1) {
                    col.add(new StringBuilder());
                }
                col.get(i).append(s.charAt(i));
            }
        }
        int i = 0;
        for (String s : words) {
            if (!s.equals(col.get(i).toString())) return false;
            i++;
        }
        return true;
    }
}
// time o(mn)   m  = words.length   n = each string max length