package MianJing.ixl.onsite;

/*
*  A: 0 - 127   B: 128 - 255
*
*   A A B A B B
*   _ _ ___ ___
*
*   A A A A B A
*   _ _ _ _ ___
*
* solution:
* linear scan from left to right, if meet
*  - A, group it self
*  - B, group it and next element
*
* so we can know last two elements if can group together or not
*
* time O(n)
* space O(1)
*
*
* solution2:
*  linear scan from right to left
*
*
* CASE1:
* last is B
*    A A B A B B
 *   _ _ ___ ___
 *
 *
*  CASE2:
*  last 2 are A
*     X X   A A
*           _ _
*
* CASE3:
* last is A, odd B before it, even B before it.    odd B: last 2 group   even B: last 1 group
*   X X X A B A
*         _ ___
*
*   X X X A B B A
*         _ ___ _
*
*
* X X X A B B B A
*       _ ___ ___
* */
public class LastByte2 {
    public int group(int[] arr) {
        // sanity check
        if (arr == null) return -1;
        if (arr.length == 1) {
            return 1;
        }
        int len = arr.length;

        // length >= 2

        // case1
        if (convert(arr[arr.length - 1]) == 'B') {
            return 2;
        }
        // case2
        if (convert(arr[len - 1]) == 'A' && convert(arr[len - 2]) == 'A') return 1;

        // case3
        int cnt = 0; // count B
        for (int i = len - 2; i >= 0; i--) {
            char c = convert(arr[i]);
            if (c == 'B') {
                cnt++;
            } else {
                break;
            }
        }

        return cnt % 2 == 0 ? 1 : 2;
    }
    private char convert(int i) {
        if (i >= 0 && i <= 127) return 'A';
        return 'B';
    }

    public static void main(String[] args) {
        int[] test1 = {1,1,1,1,2};
        int[] test2 = {1,1,1,255,3}; // 2
        int[] test3 = {1,1,1,128, 128, 3}; // 1
        int[] test4 = {1,1,1,128, 128,129, 3}; // 2
        int[] test5 = {124,128,124,126,126,128,250,128,251,124,128,124,80}; // 1

        LastByte2 sol = new LastByte2();
        int res = sol.group(test5);
        System.out.println(res);
    }
}
