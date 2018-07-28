package debugLaicode;

public class NestedListWeightSum {
    public int depthSum(String nestlists) {
        // Write your solution here
        // Write your solution here
        int depth = 0;
        int total = 0;
        for (int i = 0; i < nestlists.length(); i++) {
            if (nestlists.charAt(i) == '[') {
                depth++;
            } else if (nestlists.charAt(i) == ']') {
                depth--;
            } else if (nestlists.charAt(i) == ',') {
                continue;
            } else if (nestlists.charAt(i) >= '0' && nestlists.charAt(i) <= '9' || nestlists.charAt(i) == '-') {
                //it is digit
                // find the last digit of number, e.g. 123
                int j = i;
                int flag = 1;
                if (nestlists.charAt(i) == '-') {
                    j++;
                    flag = -1;
                }
                int num = 0;
                while (j < nestlists.length()) {
                    if (nestlists.charAt(j) >= '0' && nestlists.charAt(j) <= '9') {
                        num = 10 * num + nestlists.charAt(j) - '0';
                        j++;
                    } else {
                        break;
                    }
                }
                i = j - 1;
                total = total + num * depth * flag;
            } else {
                // it is space
                continue;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        NestedListWeightSum nestedListWeightSum = new NestedListWeightSum();
        int res = nestedListWeightSum.depthSum("[[[8],   -4]]");
        System.out.println(res);
    }
}
