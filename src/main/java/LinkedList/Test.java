package LinkedList;

/**
 * @Author: Vincent
 * @Date: 2023/5/8 14:24
 * @Description:
 **/

import java.util.List;

/**
 * @ClassName Test
 * @Author Vincent
 * @Description 
 * @Date 2023/5/8 15:39
 **/

class Test{
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next=new ListNode(3);
        list1.next.next=new ListNode(5);

        ListNode cur = list1;
        while (cur != null){
            cur = cur.next;

        }
        System.out.println("");
    }
}
