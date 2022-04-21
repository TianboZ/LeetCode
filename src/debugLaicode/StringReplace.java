package debugLaicode;

/*
*
* solution:
* use string indexOf() to find all targets
* use StringBuilder to concatenate all substrings
*
*
* */
public class StringReplace {
    public String replace(String input, String source, String target) {
        // Write your solution here
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int match = input.indexOf(source);
        while (match != -1) {
            sb.append(input, start, match).append(target);
            start = match + source.length();
            match = input.indexOf(source, start);

        }
        sb.append(input, start, input.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        StringReplace sr = new StringReplace();
        String res= sr.replace("tywjtltyvtyegcboycmqtyq", "ty", "c");
        System.out.println(res);
    }
}
