package LinkedList;


import java.util.Scanner;

/*
* 翻转指定范围[m,n]内的链表
* */
public class ReverseList4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //行输入在前，否则会有缓存
        String[] strInput = scanner.nextLine().split(" ");
        int k = scanner.nextInt();
        int j = scanner.nextInt();
        ListNode head = new ListNode(Integer.parseInt(strInput[0]));
        //创建临时变量做链表指针，不要动head
        ListNode cur = head;
        for (int i = 1; i < strInput.length; i++) {
            cur.next = new ListNode(Integer.parseInt(strInput[i]));
            cur = cur.next;
        }
        ListNode temp = head;
        System.out.println("翻转前链表为:");
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println(" ");

        ListNode result = ReverseList4.reverseBetween(head, k,j);
        ListNode curr = result;
        System.out.println(k + "个一组翻转后链表为:");
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义head之前的假节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //虚拟前指针
        ListNode pre = dummy;

        //找到要翻转的子链表的起始位置
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        //要翻转的子链表的头结点
        ListNode start = pre.next;
        //要翻转的子链表的后继节点
        ListNode end = start;

        //找到要翻转的子链表的结束位置
        for (int i = m; i < n && end != null; i++) {
            end = end.next;
        }

        //断开子链表
        ListNode next = end.next;
        end.next = null;

        //翻转子链表
        pre.next = reverse(start);

        //重新连接子链表和原链表
        start.next = next;

        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
