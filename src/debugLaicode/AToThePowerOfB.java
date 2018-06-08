package debugLaicode;

public class AToThePowerOfB {
    public long power(int a, int b) {
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
        long tmp = power(a, b/2);
        if (b % 2 == 0) {
            return  tmp * tmp;
        } else {
            return tmp * tmp * a;
        }
    }
}

// time o(logb)
// space o(logb)