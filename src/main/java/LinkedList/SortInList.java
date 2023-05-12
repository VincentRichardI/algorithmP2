package LinkedList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Vincent
 * @Date: 2023/5/9 16:25
 * @Description:
 * 升序链表，空间复杂度O（n），时间复杂度O（logn）
 **/

public class SortInList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(9);
        list1.next=new ListNode(3);
        list1.next.next=new ListNode(7);
        list1.next.next.next=new ListNode(-2);
        list1.next.next.next.next=new ListNode(5);
        ListNode head = sortInList(list1);
        System.out.println();
    }

    public static ListNode sortInList(ListNode head){
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        Integer[] arrs = list.toArray(new Integer[list.size()]);
        Integer[] result = quickSort(arrs, 0, arrs.length - 1);
        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        for (int i = 0; i < result.length; i++) {
            cur.next = new ListNode(result[i]);
            cur = cur.next;
        }

        return dummy.next;
    }

    public static Integer[] quickSort(Integer[] arrs,int left,int right){
        if (left>right){
            return null;
        }
        int pivot = left;
        int i = left;
        int j = right;

        while (i<j){
            //右边先移动，直到找到比pivot小
            while (arrs[j]>=arrs[pivot] && i<j ){
                j--;
            }
            //左边再移动，直到直到比pivot大
            while (arrs[i]<=arrs[pivot] && i<j){
                i++;
            }
            //交换位置
            if (i<j){
                int temp = arrs[i];
                arrs[i] = arrs[j];
                arrs[j] = temp;
            }
        }
        //相遇时，pivot与arrs[i]交换
        int temp = arrs[pivot];
        arrs[pivot] = arrs[i];
        arrs[i] = temp;
       quickSort(arrs,left,i-1);
       quickSort(arrs,j+1,right);
        return arrs;
    }
}
