package LinkedList;

/**
 * @Author: Vincent
 * @Date: 2023/5/8 16:09
 * @Description:
 **/

public class RemoveKth {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next=new ListNode(3);
        list1.next.next=new ListNode(5);
        list1.next.next.next=new ListNode(7);
        list1.next.next.next.next=new ListNode(9);
        ListNode result = removeKth(list1, 1);
        System.out.println("D");

    }

    public static ListNode removeKth(ListNode head,int k){

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode l = dummy.next;
        ListNode cur = dummy.next;
        int length = 0;
        while (l != null) {
            l = l.next;
            length++;
        }
        if (k > length) {
            return null;
        } else {
            for (int j = 0; j < length - k; j++) {
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }

            cur = cur.next;
            pre.next = cur;

            return dummy.next;
        }
    }
}
