package debugLaicode;

// see https://leetcode.com/problems/powx-n/ more general
public class AToThePowerOfB {
    public static long power(int a, int b) {
        // Write your solution here
        // base-case
        if (b == 0) {
            return 1;
        } else if  (a == 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        }

        // recursive rule
        long half = power(a, b / 2);
        if (b % 2 == 0) {
            return  half * half;
        } else {
            if (b < 0) return half * half / a; // !!!
            return half * half * a;
        }
    }

    public static void main(String[] args) {
        long res = power(2, 10);
        System.out.println(res);
        System.out.println((double) (3.0 / 2));
    }
}

// time o(log b)
// space o(log b)