package MianJing.thumbtack;


import java.util.HashSet;
import java.util.Set;

/*

   p2   |   p1
        |
        |

    if p1 and p2 are sysmetric to a line, then (p1.x - p2.x) / 2 + p2.x = (p1.x + p2.x) / 2 , this should be same for other pairs
    on oters levels

    find the leftmost and rightmost x position first, then this value should be used as standard

    use HashSet<String> to store each point. e.g. "x,y"

    for each point, find if exist sysmetric point in the HashSet

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
            StringBuilder sb = new StringBuilder();
            sb.append(point[0]).append(",").append(point[1]);
            set.add(sb.toString());
        }

        int sum = min + max;

        for (int[] point: points) {
            int x1 = point[0];
            int x2 = sum - x1;
            StringBuilder sb = new StringBuilder();
            sb.append(x2).append(",").append(point[1]);
            if (!set.contains(sb.toString())) return false;
        }
        return true;
    }
}

// time O(n)
