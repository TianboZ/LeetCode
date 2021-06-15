package debugLaicodeSlidingWindow;
import java.util.*;

public class FindKLengthSubstringsWithNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String S, int K) {
        Map<Character, Integer> map = new HashMap<>();
        int repeat = 0;
        int cnt = 0;

        for(int i = 0; i < S.length(); i++) {
            // right most element
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // element before window
            int j  = i - K;
            if (j >= 0) {
                c = S.charAt(j);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
            }

            // update
            if (i + 1 - K >= 0 && map.size() == K) cnt++;

        }
        return cnt;
    }
}
