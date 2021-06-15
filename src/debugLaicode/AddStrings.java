package debugLaicode;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int n1 = 0;
            int n2 = 0;
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
                j--;
            }

            int sum = n1 + n2 + carry;

            carry = sum / 10;
            sb.append(sum % 10);
        }

        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
