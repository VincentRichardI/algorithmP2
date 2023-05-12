package LinkedList;

import java.util.Scanner;

/*
* k个一组翻转链表，空间复杂度O(1)
* */
public class ReverseList3 {

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

        ListNode result = ReverseList3.KGroupReverse(head, k);
        ListNode curr = result;
        System.out.println(k + "个一组翻转后链表为:");
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

    }

    public static ListNode KGroupReverse(ListNode head, int k) {
        //如果为空链表，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        //定义head之前的假节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //虚拟前指针
        ListNode pre = dummy;
        //虚拟后指针
        ListNode end = dummy;

        while (end.next != null) {
            //找到每次的翻转位置
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //k>要翻转的长度时，不操作
            if (end == null) {
                break;
            }
            //在断开前记录断开位置
            ListNode next = end.next;
            //断开
            end.next = null;
            //要翻转的子链表
            ListNode start = pre.next;
            //翻转后的子链表
            pre.next = reverse(start);
            //翻转后start为子链表末端，与之前记录的断开位置重新连接
            start.next = next;
            //下次的pre，end指针从start处开始
            end = start;
            pre = start;
        }

        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //保存cur的next节点
            ListNode tempNode = cur.next;
            //改变cur的next指针，指向上一个节点
            cur.next = pre;
            //移动pre的指针到cur
            pre = cur;
            //移动cur的指针到tempNode
            cur = tempNode;
        }

        return pre;
    }

}