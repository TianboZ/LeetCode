package debugLaicode;

import java.util.HashSet;
import java.util.Set;

/*

   p2   |   p1
        |
        |

    if p1 and p2 are sysmetric to a line, then (p1.x - p2.x) / 2 + p2.x = (p1.x + p2.x) / 2 , this should be same for other pairs
    on oters levels

    now, assume this line exist, then try to find the leftmost and rightmost x value, add them as "sum"
    then "sum" should be used as standard

    use HashSet<String> to store each point. e.g. "x,y"

    for each point, if (sum - x, y) not exist in hashset, then the line is not exist

    time o(n)
    space o(n)
*/
public class LineReflection {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<String> set = new HashSet<>();
        for (int[] point: points) {
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
            int x = point[0];
            int y = point[1];
            set.add(x + "," + y); // "1,1"  "-1,1"
        }

        int sum = min + max;

        for (int[] point: points) {
            int x = point[0];
            int y = point[1];

            int counterX = sum - x;
            if (!set.contains(counterX + ","+y)) return false;
        }
        return true;
    }
}
