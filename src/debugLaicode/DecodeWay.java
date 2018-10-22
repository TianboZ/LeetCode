package debugLaicode;


public class  DecodeWay {
    public static void main(String[] args) {
        DecodeWay decodeWay = new DecodeWay();

        char a = '6';
        char b = '1';
        int res = '9' - '0';
        System.out.println(a - b);
        //int res = decodeWay.numDecodeWay("21251");
        //System.out.println(res);
    }
    public int numDecodeWay(String s) {
        //Input your code here
        // dp[i] represents number of ways to decode, ends with index i of original string
        int[] dp = new int[s.length()];

        // base-case
        dp[0] = 1;
        if (10 * Character.getNumericValue(s.charAt(0)) + Character.getNumericValue(s.charAt(1)) <= 26) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }

        // inductive rule
        for (int i = 2; i < s.length(); i++) {

            if (10 * Character.getNumericValue(s.charAt(i - 1)) + Character.getNumericValue(s.charAt(i)) <= 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
                System.out.println(10 * Character.getNumericValue(s.charAt(i - 1)) + Character.getNumericValue(s.charAt(i)));
                System.out.println(dp[i]);
                System.out.println("index : " + i);
                System.out.println();
            } else {

                dp[i] = dp[i - 1];
                System.out.println(10 * Character.getNumericValue(s.charAt(i - 1)) + Character.getNumericValue(s.charAt(i)));
                System.out.println(dp[i]);
                System.out.println("index : " + i);
                System.out.println();
            }
        }

        return dp[dp.length - 1];
    }

    public int numDecodeWay1(String s) {
        // Write your solution here
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        // dp[i] represents number of decode ways
        // for first i letters

        // base-case
        dp[0] = 1;
        dp[1] = 1;

        // inductive rule
        for (int i = 2; i <= s.length(); i++) {
            int sum = 0;
            // case1: 1 digit
            if (s.charAt(i - 1) != '0') {
                sum = sum + dp[i - 1];
            }
            // case2: 2 digits
            int num = ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0'));
            if (num >= 10 && num <= 26) {
                sum = sum + dp[i - 2];
            }
            dp[i] = sum;
        }
        return dp[s.length()];
    }
}
