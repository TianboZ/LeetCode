package MianJing.thumbtack.OA_Dianmian;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
class LineReflection1 {
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*

clearify:
    could be dulicate points on same posiiton
    they have to appear in pair


asummption:
    intput <int, int>

solution:
    p1      |      p2
            |
            |
   if the line exist, p1.x + (p2.x - p1.x)/2  shuold be constant
   p1.x + p2.x == sum,  sum should be constant for all the other symmectirc pairs

   assume line exist, then leftmost.x + rightmost.x == sum
   use the sum as standard, to check other pair

    e.g.   p1(x, y)    to check if there is symmetic, just to check if exist(sum - x, y)

    iterate all the points, to find if it has counter point


    Map<key: "x,y", value: frequency>

    time O(n)   n is number of points
    space O(n)

*/
// https://imgur.com/a/HRoba
class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        System.out.println("hello thumbtack!");


        //int[][] points = {{1,1}, {1,1}, {-1,1}, {-1,1}};
        //int[][] points = {{1,1}, {1,1}, {-1,1}, {-1,1}, {1,1}};
        int[][] points = {{1,1}, {1,1}, {-1,1}, {-1,1}, {-2,0}, {2,0},{3,1}};

        Double res = findSymmetricXcordinate(points);
        System.out.println(res);
    }

    public static Double findSymmetricXcordinate(int[][] points) {
        // sanity check
        if (points == null || points.length == 0) return null;

        int sum = 0;
        int leftMost = Integer.MAX_VALUE;
        int rightMost = Integer.MIN_VALUE;

        // key: "x,y"  value: frequecy
        Map<String, Integer> map = new HashMap<>();
        // count each position frequency
        for (int[] point: points) {
            int x = point[0];
            int y = point[1];

            leftMost = Math.min(leftMost, x);
            rightMost = Math.max(rightMost, x);

            String pos = "" + x + "," + y;
            map.put(pos, map.getOrDefault(pos, 0) + 1);
        }

        // get the stardard
        sum = leftMost + rightMost;

        // iterate each point, find if there exist a symmetirc point or not
        for (int[] point: points) {
            int x = point[0];
            int y = point[1];

            int counterX = sum - x;
            String pos = "" + counterX + "," + y;
            if (map.containsKey(pos)) {
                map.put(pos, map.get(pos) - 1);
                if (map.get(pos) == 0) {
                    map.remove(pos); // when the frequency == 0, remove from the map
                }
            } else {
                return null;
            }
        }
        return sum * 1.0 / 2;
    }
}


/*

so many points, store in 3 PCs

we still 10 PCs to solve the problem

each PC has a Map<key: "x,y", value: frequency>

// first pass
for each PC
    find the leftmost.x  and rightmost.x

time o(m * n)

so that we have the sum, use it as standard

// second pass
for each  PC
    get a point "x,y"
    iterate all the other 2 PCs
        on each PC, look up operation in PC

time o(n * m * n)

time complexity:
n is number of PC
m is number of points in each PC

o(n * m * n)


*/
