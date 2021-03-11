package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class CycleNodeInLinkdedList {
    public ListNode cycleNode(ListNode head) {
        // write your solution here
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.add(head)) {
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }
}
