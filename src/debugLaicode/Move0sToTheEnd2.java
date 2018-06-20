package debugLaicode;

public class Move0sToTheEnd2 {
    public int[] moveZero(int[] array) {
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == 0) {
                continue;
            } else {
                array[slow] = array[fast];
                slow++;
            }
        }

        // post processing
        for (int i = slow; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }
}
