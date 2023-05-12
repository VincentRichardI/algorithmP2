package LinkedList;

import java.util.List;

/**
 * @Author: Vincent
 * @Date: 2023/5/8 17:04
 * @Description:
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 *  9->3->7，链表 2 为 6->3
 *  结果链表为 1->0->0->0。
 **/

public class AddInList {


    public static void main(String[] args) {
        ListNode list1 = new ListNode(9);
        list1.next=new ListNode(3);
        list1.next.next=new ListNode(7);

        ListNode list2 = new ListNode(6);
        list2.next=new ListNode(3);

        ListNode result = addInList(list1,list2);
        reverseList(list1);
        reverseList(list2);
    }

    public static ListNode addInList(ListNode head1,ListNode head2){
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        //进位数
        int carry = 0;
        //新链表的虚拟头
        ListNode dummy = new ListNode(-111);
        ListNode newHead = dummy;
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        while (head1 != null || head2 != null || carry!=0){
            //获取每个位的运算值
            int hV1 = (head1 == null)? 0: head1.val;
            int hV2 = (head2 == null)? 0: head2.val;
            //计算每个位的总值
            int total = hV1+hV2+carry;
            //计算下一轮的进位数
            carry = total/10;
            //计算当前位的数值
            int temp = total%10;
            //将计算结果链到新链表中
            newHead.next = new ListNode(temp);
            newHead = newHead.next;
            //移动下一个
            if (head1 != null){
                head1 = head1.next;
            }
            if (head2 != null){
                head2 = head2.next;
            }
        }

        return reverseList(dummy.next);

    }

    public static ListNode reverseList(ListNode head ){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur !=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur ;
            cur = temp;
        }

        return pre;
    }
}
