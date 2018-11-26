package debugLaicode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

assumptions:
    position<int, int>

    could have duplicate points on the same position

solution:

            p1      |      p2(p2.1)     p2, p2.1 same position
                 p3 | p4
                    |
                    |
                    |
这条线不存在


            p1(p1.1)|      p2(p2.1)     p1, p1.1 same position
                 p3 | p4                p2, p2.1 same position
                    |
                    |
                    |

这条线存在


    steps:
    if there exist a line reflects the points, then p1.x + p2.x = sum, sum should be a constant
    for other symmetric pairs, sum still should be the same

    assume the line exist, then leftmost.x + rightmost.x  should equal to sum
    find the sum first

    iterate all the point, check if it has symmetric point

    use Map<key: "x,y",  value: frequency> to store each point


    time: O(n)
    space O(n)
    n is number of points
*/
public class LineReflection {
    public static  boolean isReflected(int[][] points) {

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        // key: "x,y"    value: frequency
        Map<String, Integer> map = new HashMap<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            left = Math.min(left, x);
            right = Math.max(right, x);

            String pos = "" + x + "," + y;
            map.put(pos, map.getOrDefault(pos, 0) + 1);
        }

        int sum = left + right;

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            int counterX = sum - x;
            String pos = "" + counterX + "," + y;
            Integer count = map.get(pos);
            if (count == null) {
                return false;
            } else {
                map.put(pos, count - 1);
                if (map.get(pos) == 0) map.remove(pos);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] points = {{-1,1}, {1,1}, {-2,2}, {2,21}};
        boolean res = isReflected(points);
        System.out.println(res);
    }
}
