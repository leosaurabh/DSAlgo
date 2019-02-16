import java.util.Stack;

public class AdjacentSwap {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args[]) {
        ListNode start = new ListNode(2);
        start.next = new ListNode(5);
        start.next.next = new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(6);
        start.next.next.next.next.next = new ListNode(2);
        start.next.next.next.next.next.next = new ListNode(2);

        // ListNode ans = swapPairs(start);
        ListNode ans1 = reverseKGroup(start, 3);
        System.out.println();
    }

    // [2,5,3,4,6,2,2]
    private static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode start = null;
        ListNode t = head;
        ListNode t1 = null;
        while (t != null) {
            t = head.next;
            if (t == null) {
                break;
            } else {
                head.next = t.next;
                t.next = head;
                if (start == null) {
                    start = t;
                    t1 = head;
                } else {
                    t1.next = t;
                    t1 = head;
                }
                head = head.next;
                t = head;
            }
        }
        return start == null ? t : start;
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (k <= 1) {
            return head;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode t = head;
        ListNode start = null;
        int count = 0;
        while(t != null) {
            if (count < k) {
                stack.push(t);
                count++;
            } else {
                while (!stack.isEmpty()) {
                    if (start == null) {
                        start = stack.pop();
                        head = start;
                    } else {
                        head.next = stack.pop();
                        head = head.next;
                    }
                }
                head.next = t;
                stack.push(t);
                count = 1;
            }
            t = t.next;
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                if (start == null) {
                    start = stack.pop();
                    head = start;
                } else {
                    head.next = stack.pop();
                    head = head.next;
                }
            }
        }
        return start == null ? head : start;
    }
}
