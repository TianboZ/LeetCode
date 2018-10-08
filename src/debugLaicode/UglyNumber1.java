package debugLaicode;

public class UglyNumber1 {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        int[] divisors = {2, 3, 5};
        for (int divisor : divisors) {
            while(num % divisor == 0) {
                num /= divisor;
            }
        }
        return num == 1;
    }
}
