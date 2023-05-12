package LinkedList;

import java.util.Random;

/*
* k个一组进行翻转,要求空间复杂度为O(1)，即不借助外部存储器
* */
public class ReverseList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        Random random = new Random(10);
        ListNode tem = head;
        for (int i = 0; i < 5; i++) {
            tem.next= new ListNode(random.nextInt(10));
            tem=tem.next;
        }
        tem = null;
        //反转前链表为:5->3->0->3->0->6
        /*while (head!=null){
            System.out.print(head.val+"-->");
            head = head.next;
        }*/
        ReverseList2.reverseKGroup(head,3);



    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        //定义一个假的节点。
        ListNode dummy=new ListNode(0);
        //假节点的next指向head。
        // dummy-5->3->0->3->0->6
        dummy.next=head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre=dummy;
        ListNode end=dummy;

        while(end.next!=null){
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->5->3->0->3->0->6 若k为3，循环3次，end指向3
            for(int i=0;i<k&&end != null;i++){
                end=end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if(end==null){
                break;
            }
            //先记录下end.next(3->0->6),方便后面链接链表
            ListNode next=end.next;
            //然后断开链表
            end.next=null;
            //记录下要翻转链表的头节点
            ListNode start=pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next=reverseList(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next=next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre=start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end=start;
        }
        return dummy.next;
    }

    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null) {
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur =tempNode;
        }
        return pre;
    }
}
