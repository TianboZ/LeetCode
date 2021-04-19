package MianJing.ixl.onsite;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
*
* given a html string like
"this is not italic<i>this is italic</i>this is another not italic<i>this is another italic</i>"
* return an array [not_italic("this is not italic"), italic("this is italic"), not_italic("this is another not italic"),italic("this is another italic")],
*
*  italic() and not_italic() are given。用stack做。
*
*
* solution:
* linear scan, use string API `indexOf()` to find open and close tag
* for each substring, store them in a list
*
*
* */
public class HTML {
    class Pair {
        String chunk;
        boolean isTag;
        Pair(String chunk, boolean isTag) {
            this.chunk = chunk;
            this.isTag = isTag;
        }
    }
    public void parse(String html) {
        // sanity check, todo

        List<Pair> list = new ArrayList<>();
        int i = 0;
        String open = "<i>";
        String close = "</i>";

        while (i < html.length()) {
            int openIdx = html.indexOf(open, i);

            if (openIdx != -1) {
                int closeIdx = html.indexOf(close, openIdx);
                String tagStr = html.substring(openIdx + open.length(), closeIdx);

                if (openIdx != i) {
                    String noTagStr = html.substring(i, openIdx);
                    list.add(new Pair(noTagStr, false));
                }

                list.add(new Pair(tagStr, true));
                i = closeIdx + close.length();
            } else {
                // no open
                list.add(new Pair(html.substring(i), false));
                break;
            }
        }

        for (Pair p : list) {
            System.out.println(p.chunk);
        }
    }
    public static void main(String[] args) {
        HTML sol = new HTML();
        String html  =  "x<i>this is italic</i>this is another not italic    <i>this is another italic</i> ";
        String html2  =  "this is string";
        sol.parse(html);
    }
}
