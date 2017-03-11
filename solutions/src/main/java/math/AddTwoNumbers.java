package math;

import common.CommonList;

/**
 * Created by joe wang on 2017/3/11.
 */
public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     */
    public CommonList.ListNode addTwoNumbers(CommonList.ListNode l1, CommonList.ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private CommonList.ListNode addTwoNumbers(CommonList.ListNode l1, CommonList.ListNode l2, int plus) {
        if (null == l1 && null == l2) {
            if (plus > 0) {
                return new CommonList.ListNode(plus);
            }
            return null;
        }
        if (null != l1 && null == l2) {
            int val = l1.val + plus;
            CommonList.ListNode listNode = new CommonList.ListNode(val % 10);
            if (val >= 10) {
                listNode.next = addTwoNumbers(l1.next, null, 1);
            }else {
                listNode.next = l1.next;
            }
            return listNode;
        }else if (null == l1 && null != l2) {
            int val = l2.val + plus;
            CommonList.ListNode listNode = new CommonList.ListNode(val % 10);
            if (val >= 10) {
                listNode.next = addTwoNumbers(null, l2.next, 1);
            }else {
                listNode.next = l2.next;
            }
            return listNode;
        }else {
            int val = l1.val + l2.val + plus;
            CommonList.ListNode listNode = new CommonList.ListNode((val) % 10);
            listNode.next = addTwoNumbers(l1.next, l2.next, val / 10);
            return listNode;
        }

    }
}
