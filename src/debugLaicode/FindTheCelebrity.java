package debugLaicode;

import java.util.*;

/*
* solution:
*
* brute force:
* for each people i,
*   check if people j knows i   (j <= i)
*
*
* time o(n^2)
* space O(1)
*
* solution2:

    compare pair of people (i,j)

    knows(i, j)     i is not celebrity
    otherwise       j is not celebrity

    1. find the candidate by one pass
    2. make sure if the candidate is a celebrity by one pass

*
* */
public class FindTheCelebrity {

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (!knows(i, candidate) || knows(candidate, i)) return -1;
        }
        return candidate;
    }
    // dummy API
    private boolean knows(int a, int b) {
        return true;
    }
}
