package LinkedList;

import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        ReverseList reverseList = new ReverseList();
        reverseList.reverseList2(head);
    }

    //额外栈解法，时间O(n),空间O(n)
    public void reverseList1(ListNode head){
        Stack<ListNode> integers = new Stack<>();
        if (head == null){
            return ;
        }else {
            while (head != null){
                integers.push(head);
                head = head.next;
            }
            //新头
            ListNode newHead = integers.pop();
            //从链表新头开始遍历
            ListNode cur = newHead;
            while(!integers.isEmpty()){
                //临时节点
                ListNode tempNode = integers.pop();
                cur.next = tempNode;
                //移动当前节点指针
                cur = cur.next;
            }
            //最后必须指向null，否则可能形成环
            cur.next = null;


            System.out.println("反转后");
            while(newHead!=null){
                System.out.print(newHead.val+"->");
                newHead = newHead.next;
            }
        }
    }

    //双指针解法,时间O(n)，空间O(1)
    public void reverseList2(ListNode head){
        //head的前驱节点
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            //把cur的下一个节点存起来
            ListNode tempNode = cur.next;
            //改变cur的next指针指向
            cur.next = pre;
            //pre向后移
            pre = cur ;
            //当前cur为存储起来的cur.next
            cur = tempNode;

        }

        System.out.println("反转后");
        while(pre!=null){
            System.out.print(pre.val+"->");
            pre = pre.next;
        }
    }
}
