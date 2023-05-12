package LinkedList;

/**
 * @Author: Vincent
 * @Date: 2023/5/10 16:59
 * @Description:
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 **/

public class DeleteDuplicates2 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(5);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(5);
        list1.next.next.next.next=new ListNode(9);
        ListNode listNode = deleteDuplicates2(list1);
        System.out.println();
    }
    public static ListNode deleteDuplicates2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur !=null){
            while( cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            //若cur与pre没有重复节点，pre后移
            if (pre.next == cur){
                pre = pre.next;
            }
            //否则cur与pre之间有重复节点，pre的下一个节点接到cur的下一个节点，位置保持不动
            else {
                pre.next = cur.next;
            }
            //cur指针无论如何都要后移
            cur = cur.next;
        }
        return dummy.next;
        //
    }
}
