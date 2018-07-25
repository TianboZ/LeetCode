package debugLaicode;

public class NestedValue {
    public int value(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return 0;
        }
        int level = 0;
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                level++;
            } else if (input.charAt(i) == '}') {
                level--;
            } else {
                sum = sum + level * (input.charAt(i) - '0');
            }
        }
        return sum;
    }
}
