package LinkedList;

import java.util.Scanner;

/*
* 按大小合并两个链表
* */
public class ReverseList5 {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next=new ListNode(3);
        list1.next.next=new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next=new ListNode(4);
        list2.next.next=new ListNode(6);

        System.out.println(" ");

        ListNode result = ReverseList5.Merge(list1,list2);
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode dummy = new ListNode(-111);
        ListNode start = dummy;
        while(cur1 != null && cur2 != null){
            if(cur1.val >cur2.val){
                start.next = cur2;
                cur2 = cur2.next;
            }else{
                start.next = cur1;
                cur1 = cur1.next;
            }
            start = start.next;

        }

        if (cur1 == null){
            start.next = cur2;
        }
        if (cur2 ==null ){
            start.next = cur1;
        }
        return dummy.next;
    }
}
