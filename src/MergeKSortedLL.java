public class MergeKSortedLL {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode start = null;
        if (lists == null || lists.length == 0) {
            return start;
        }

        while(isValid(lists)) {
            ListNode temp = null;

            int min = Integer.MAX_VALUE;
            ListNode minNode = null;
            int minIndex = 0;
            for (int i = 0; i<lists.length; i++) {
                ListNode node = lists[i];
                if (node != null) {
                    if (node.val < min) {
                        min = node.val;
                        minNode = node;
                        minIndex = i;
                    }
                }
            }
            lists[minIndex] = lists[minIndex].next;

            if (start == null) {
                start = minNode;
                temp = minNode;
                temp.next = null;
            } else {
                temp.next = minNode;
                temp = temp.next;
                temp.next = null;
            }
        }
        return start;
    }

    private boolean isValid(ListNode[] lists) {
        boolean valid = false;
        for (ListNode node:lists) {
            valid = valid || (node != null);
        }
        return valid;
    }
}
