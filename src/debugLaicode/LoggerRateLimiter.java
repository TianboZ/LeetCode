package debugLaicode;

import java.util.HashMap;
import java.util.Map;

/*

solution:
    Map<key: message, value: timestamp>

    for each comming message, if the this message exist before,
    3 cases:
        1.then check if the it happend 10 sec ago, if it is, then not print current messagge
        2.otherwise, print current message, update time in the map
        3. if the message not exist, print message, record it into map



     time O(1)
     space O(n)
*/
public class LoggerRateLimiter {
    private int limiter = 10;
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        this.map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer time = map.get(message);
        if (time == null) {
            map.put(message, timestamp);
            return true;
        } else if (timestamp - time >= limiter) {
            map.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
