package MianJing.ixl;
/*
*
* https://www.geeksforgeeks.org/find-intersection-of-all-intervals/
*
* solution:
*
* i1 = [l1, r1]
*
* if i2 = [l2, r2]
*   - don't overlap with i1 only when l2 > r1  or r2 < l1
*   - overlaps with  i1, then overlap is [max(l1, l2), min(r1, r2)]
*
* */
public class FindIntersections {
    static int[] findIntersection(int intervals[][], int N) {
        // First interval
        int l = intervals[0][0];
        int r = intervals[0][1];

        // Check rest of the intervals
        // and find the intersection
        for (int i = 1; i < N; i++) {
            int[] interval = intervals[i];

            if (interval[0] > r || interval[1] < l) {  // If no intersection exists
                System.out.println(-1);
                return null;
            } else { // intersection
                l = Math.max(l, interval[0]);
                r = Math.min(r, interval[1]);
            }
        }
        System.out.println ("[" + l +", " + r + "]");
        return null;
    }

    // Driver code
    public static void main (String[] args)
    {

        int intervals[][] = {
                { 1, 6 },
                { 2, 8 },
                { 3, 10 },
                { 5, 8 }};
        int N = intervals.length;
        findIntersection(intervals, N);
    }

}
