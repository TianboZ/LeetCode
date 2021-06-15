package MianJing.tiktok;

public class AddStrings {
    public String add(String s1, String s2) {
        int dot1 = s1.indexOf(".");
        int dot2 = s1.indexOf(".");

        int diff = (s1.length() - 1 - dot1) - (s2.length() - 1 - dot2);

        if (diff > 0) {
            // s2 append 0
            StringBuilder sb = new StringBuilder(s2);
            while (diff > 0) {
                sb.append('0');
                diff--;
            }
            s2 = sb.toString();
        } else {
            StringBuilder sb = new StringBuilder(s1);
            while (diff > 0) {
                sb.append('0');
                diff--;
            }
            s1 = sb.toString();
        }

        int i = s1.length()  - 1;
        int j = s2.length()  - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            if (s1.charAt(i) == '.') {
                sb.append('.');
                i--; j--;
                continue;
            }
            int n1 = 0;
            if (i >= 0) {
                n1 = s1.charAt(i) - '0';
            }
            i--;

            int n2 = 0;
            if (j >= 0) {
                n2 = s2.charAt(j) - '0';
            }
            j--;

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        if (carry > 0) sb.append(carry);

        String res = sb.reverse().toString();

        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        AddStrings sol = new AddStrings();
        sol.add("1.101", "9.9");
    }
}
