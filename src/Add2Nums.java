/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//class Add2Nums {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 ==null) {
//            return null;
//        }
//
//        if (l1 == null) {
//            return l2;
//        }
//
//        if (l2 == null) {
//            return l1;
//        }
//
//        ListNode lt1 = l1;
//        ListNode lt2 = l2;
//        ListNode lt = null;
//        ListNode temp = null;
//        int carry = 0;
//        int val = 0;
//
//        while (l1 != null || l2 != null) {
//            if (l1 != null && l2 != null) {
//                val = l1.val + l2.val + carry;
//            } else if (l1 != null) {
//                val = l1.val + carry;
//            } else if (l2 != null) {
//                val = l2.val + carry;
//            }
//
//            if (val > 9) {
//                carry = val/10;
//                val = val%10;
//            }
//
//            if (temp == null) {
//                temp = new ListNode(val);
//            } else {
//                temp.next = new ListNode(val);
//                temp = temp.next;
//            }
//
//            if (lt == null) {
//                lt = temp;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        return lt;
//    }
//}