package LinkedList;

import java.util.List;

/**
 * @Author: Vincent
 * @Date: 2023/5/8 14:23
 * @Description:
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表
 **/

public class ReverseList7 {
   /**
    * @Author Vincent
    * @Date 2023/5/8 15:39
    * @Description
    * @Param [head, i]
    * @return LinkedList.ListNode
    **/
   public static void main(String[] args) {
       ListNode list1 = new ListNode(1);
       list1.next=new ListNode(3);
       list1.next.next=new ListNode(5);
       list1.next.next.next=new ListNode(7);
       list1.next.next.next.next=new ListNode(9);
       ListNode result = ReverseList7.findKthToTail(list1,2);
       ListNode result2 = ReverseList7.findKthToTail(list1,5);
       ListNode result3 = ReverseList7.findKthToTail(list1,6);
       System.out.println(result);
       System.out.println("d");
   }


    public static ListNode findKthToTail(ListNode head,int i) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy.next;
        ListNode cur = dummy.next;
        int length = 0;
        while (l != null) {
            l = l.next;
            length++;
        }
        if (i > length) {
            return null;
        } else {
            for (int j = 0; j < length - i; j++) {
                cur = cur.next;
            }
            return cur;
        }
    }
}
