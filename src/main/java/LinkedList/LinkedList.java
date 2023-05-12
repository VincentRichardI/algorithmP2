package LinkedList;

import org.w3c.dom.NodeList;

public class LinkedList {
    ListNode head;
    public LinkedList(){
        this.head = null;
    }

    public void addNode(int val){
        if (head==null){
            head= new ListNode(val);
        }else {
            ListNode cur = head;
            if (cur.next!=null){
                cur = cur.next;
            }
            cur.next= new ListNode(val);
        }
    }

    public void delNode(int val){
        //1.如果head为null，则return空
        if (head==null){
            return;
        }
        else {
            ListNode cur = head;
            //2.如果要删除的元素就是head，则head指针后移
            if (cur.val == val){
                cur=cur.next;
            }else {
                //3.否则，不断后移(下一个节点不为空，当前节点的下一个节点值不为val)找到要删除的元素，删除
                while(cur.next!=null && cur.next.val !=val){
                    cur = cur.next;
                }
                if (cur.next!=null){
                    cur.next = cur.next.next;
                }
            }
        }
    }

    public void printList(){
        if (head==null){
            System.out.println("当前链表为空");
        }else {
            ListNode cur = head;
            while (cur!=null){
                System.out.print(cur.val+"->");
                cur = cur.next;
            }
            System.out.println("");
        }
    }
}

