package debugLaicode;

public class SplitSpace {
    public static void main(String[] args) {
        SplitSpace splitSpace = new SplitSpace();
        splitSpace.split("ab c");
    }
    public String  split(String input) {
        // write your solution here
        if(input == null || input.length() == 0) {
            return input;
        }
        int right = 0;
        int left = 0;
        StringBuilder sb = new StringBuilder();
        while (right < input.length()) {
            while (right < input.length() && input.charAt(right) != ' ') {
                right++;
            }
            sb.append(input.substring(left, right));
            sb.append("20%");
            if (right < input.length() - 1) {
                left = right + 1;
                right = left;
            }
        }
        Character character = 'C';
        return sb.toString();
    }
}

