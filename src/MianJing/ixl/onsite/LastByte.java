package MianJing.ixl.onsite;


/*
*  [0, 127]: A
*  [128, 255]: B
*
*
* sol:
* linear scan from left to right
*
* A A A B B A
* _ _ _ ___ _
*
* meet A, group itself
* meet B, group it with next element
*
* complexity:
* time  O(n)
* space  O(1)
*
* sol2:
* try scan from right?
*
* ?: dont care
*
*
* case1
*       ? ? ? ? B
*             ___
* case2
*
*     ? ? ? ? A A
*             _ _
*           ___ _
* case3:
*     ？ ？ ？ ？ A B A
*               _ ____
*
*    ?  ? ? A B B A
*           _ ___ _
*
*    ? ? A B B B A
*        _ ___ ___
*
*    odd B: 2
*    even B: 1
*
* */
public class LastByte {
    public Integer isOne(int[] input) {
        // sanity check, todo
        if (input == null) return null;
        if (input.length == 0) return null;
        if (input.length == 1) {
            return 1;
        }

        // case1:
        int len = input.length;
        if (type(input[len - 1]) == 'B') {
            return 2;
        }

        // case2:
        if (type(input[len - 1]) == 'A' && type(input[len - 2]) == 'A') {
            return 1;
        }

        int i = len - 2;
        int countB = 0;
        while (i >= 0 && type(input[i]) == 'B') {
            i--;
            countB++;
        }

        if (countB % 2 == 0) {
            return 1;
        }
        return 2;
    }
    private char type(int num) {
        if (num >= 0 && num <= 127) return 'A';
        return 'B';
    }

    public static void main(String[] s) {
        LastByte sol = new LastByte();
        int[] test4 = {};
        int[] test1 = {125, 12, 1, 127}; // 1
        int[] test2 = {125, 12, 1, 127, 222, 2}; // 2
        int[] test3 = {125, 12, 1, 222, 222,2}; // 1

        Integer res = sol.isOne(test3);
        System.out.println(res);
    }
}
