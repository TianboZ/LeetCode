package debugLaicode;


public class DecodeWay {
    public static void main(String[] args) {
        DecodeWay decodeWay = new DecodeWay();
        int res = decodeWay.numDecodeWay("21251");
        System.out.println(res);
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
}
