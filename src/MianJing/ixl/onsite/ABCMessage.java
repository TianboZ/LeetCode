package MianJing.ixl.onsite;

import java.util.HashSet;
import java.util.Set;

/*

    A3 A1 B B A2 C1 B C2 C3

setA: 3, 1,
*  liner scan from left to right. if meet A, store client id 进 set; 遇见 B, 停下来，开始往后扫
，扫到第一个 满足如下条件的C
*   - C 的id 是之前遇见过的某一个 A的 id， 也就是从set 里面有的; 把这个id 从set 里remove, meaning this id is
*       used
*
* */
public class ABCMessage {
//    public void message(String[][] arr) {
//        Set<String> idASet = new HashSet<>();  // store A's id
//        for (int i = 0; i < arr.length; i++) {
//            String type = arr[i][0];
//            String id = arr[i][1];
//
//            if (type.equals("A")) {
//                idASet.add(id);
//            } else if (type.equals("B")) {
//                for (int j = i + 1; j < arr.length; j++) {
//                    // find valid C
//                    if (arr[j][0].equals("C")) {
//                        String cId = arr[j][1];
//                        if (idASet.contains(cId)) {
//                            // assign C's id to current B
//                            arr[i][1] = cId;
//
//                            // remove  C's id from current A ids set
//                            idASet.remove(cId);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        for (String[] string: arr) {
//            System.out.println(string[0] + ":" + string[1]);
//
//        }
//        System.out.println(arr);
//    }

    public void message(String[][] strs) {
        // sanity check
        // todo

        Set<String> setAids = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            String type  = strs[i][0];
            String id = strs[i][1];

            if (type.equals("A")) {
                setAids.add(id);
            } else if (type.equals("B")) {
                // scan right subarray
                for (int j = i; j < strs.length; j++) {
                    type  = strs[j][0];
                    id = strs[j][1];

                    if (type.equals("C") && setAids.contains(id)) {
                        strs[i][1] = id;
                        setAids.remove(id);
                        break;
                    }
                }
            }
        }

        for (String[] s: strs) {
            System.out.println(s[0] + ": " + s[1]);
        }
        return;
    }

    public static void main(String[] args) {
        ABCMessage sol = new ABCMessage();
        String[][] messages = {
                {"A", "3"},
                {"A", "1"},
                {"B", ""},
                {"B", ""},
                {"A", "2"},
                {"C", "1"},
                {"B", ""},
                {"C", "2"},
                {"C", "3"}


//                {"A", "2"},
//                {"A", "1"},
//                {"B", ""},
//                {"C", "2"},
//                {"B", ""},
//                {"C", "1"},

//                {"A", "1"},
//                {"A", "2"},
//                {"A", "3"},
//                {"A", "4"},
//                {"B", ""},
//                {"B", "2"},
//                {"C", "3"},
//                {"C", "4"},
//                {"B", ""},
//                {"B", ""},
//                {"C", "1"},
//                {"C", "2"},

        };
        sol.message(messages);
    }
}
