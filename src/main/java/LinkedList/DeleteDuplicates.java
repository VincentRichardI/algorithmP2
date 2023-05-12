package LinkedList;

/**
 * @Author: Vincent
 * @Date: 2023/5/10 16:43
 * @Description:
 **/

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(5);
        list1.next.next.next.next=new ListNode(1);
        ListNode listNode = deleteDuplicates(list1);
        System.out.println();
    }
    public static ListNode deleteDuplicates(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        while (cur!=null && cur.next !=null){
            //如果当前节点的值等于下一节点的值
            if (cur.val == cur.next.val){
                //更改当前节点的下一指向为当前节点的下下节点
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;

        }
        return head;
    }
}
