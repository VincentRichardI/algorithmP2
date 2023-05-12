package LinkedList;

/*
 * 判断链表中是否有环
 * 输入:1->3->5->7->9
 * 表示链表接到索引为2处，即1->3->5->7->9->5->7->9 ...
 * */
public class ReverseList6 {
    public static void main(String[] args) {

    }

    public static boolean isLoop(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode low = head;
        while(fast != null && fast.next != null){
            if (fast==low){
                return true;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return false;
    }
}
