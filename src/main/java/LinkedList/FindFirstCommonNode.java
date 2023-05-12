package LinkedList;

/**
 * @Author: Vincent
 * @Date: 2023/5/8 16:22
 * @Description:
 **/

public class FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next=new ListNode(3);
        list1.next.next.next=new ListNode(6);
        list1.next.next.next.next=new ListNode(7);

        ListNode list2 = new ListNode(4);
        list2.next=new ListNode(5);
        list2.next.next=new ListNode(6);
        list2.next.next.next=new ListNode(7);

        ListNode result = FindFirstCommonNode(list1, list2);
        System.out.println("D");
    }

    public static ListNode FindFirstCommonNode(ListNode head1,ListNode head2){
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while( cur1!=cur2){
            cur1=cur1==null?head2:cur1.next;
            cur2=cur2==null?head1:cur1.next;
        }
        return cur1;
    }
}
