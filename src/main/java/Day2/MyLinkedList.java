package Day2;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
        this.next = null;
    }
}

public class MyLinkedList {
    private  ListNode head;

    public MyLinkedList(){
        this.head = null;
    }

    public void addNode(int val){
        //若当前头部为null,直接连
        if (head==null){
            head = new ListNode(val);
        }else {
            //不为空时，则当前节点为head
            ListNode curNode = head;
            //若head的next指针不为空，则用循环连起来
            while (curNode.next!=null){
                curNode = curNode.next;
            }
            //最后把传入的连起来
            curNode.next = new ListNode(val);
        }
    }
    public void delNode(int val){
        if (head == null){
            return;
        }
        //如果头节点就是要删除的节点,更改next指针
        if (head.val==val){
            head=head.next;
        }else {
            ListNode cur = head;
            //在链表的节点中找到要删除的元素
            while (cur.next!=null && cur.next.val !=val){
                cur=cur.next;
            }
            //找到以后，把待删除的元素后一个元素接上
            if (cur.next != null){
                cur.next = cur.next.next;
            }
        }
    }

    public void printList(){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val+ "->");
            cur = cur.next;
        }
        System.out.println();
    }
}

class Test{
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(4);
        myLinkedList.addNode(5);
        myLinkedList.addNode(1);
        myLinkedList.addNode(9);
        myLinkedList.printList();
        myLinkedList.delNode(1);
        myLinkedList.printList();
    }
}

