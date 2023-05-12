package LinkedList;

/**
 * @Author: Vincent
 * @Date: 2023/5/10 15:47
 * @Description:
 * 链表的奇偶位重排
 * 奇->偶
 **/

public class OddEvenList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(9);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(7);
        list1.next.next.next.next=new ListNode(1);
        ListNode listNode = oddEvenList(list1);
        System.out.println();
    }

    public static ListNode oddEvenList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even  = head.next;
        ListNode evenHead = even;
        while (odd != null && odd.next !=null){
            //odd连接even的后一个
            odd.next = even.next;
            //移动even
            odd = odd.next;
            //even连接后一个奇数位
            even.next = odd.next;
            //even进入后一个偶数位
            even = even.next;

        }
        odd.next = evenHead;
        return head;

    }
}
