package LinkedList;

import java.util.List;
import java.util.Stack;

/**
 * @Author: Vincent
 * @Date: 2023/5/9 17:11
 * @Description:
 **/

public class IsPail {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(9);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(7);
        list1.next.next.next.next=new ListNode(1);
        boolean result = isPail(list1);
        System.out.println(result);

    }

    public static boolean isPail(ListNode head) {

        //设置快慢指针，慢指针走1步，快指针走2步，
        ListNode quick = head;
        ListNode slow = head;

        //quick为空时表明，快指针走到底，此时slow指针走到链表中间
        while(quick!= null && quick.next!=null){
            quick = quick.next.next;
            slow = slow.next;
        }

        //如果quick不为空则表明当前链表为奇数长度,此时slow向后移一位
        if (quick!=null){
            slow = slow.next;
        }
        //链表中ListNode p = head 的话，操作p会不会对head造成影响
        slow = reverseList(slow);
        //为什么reverseList(slow)以后head就变成9->3->3
        quick = head;

        while (slow!=null){
            if (slow.val != quick.val){
                return false;
            }
            slow = slow.next;
            quick = quick.next;
        }

        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
