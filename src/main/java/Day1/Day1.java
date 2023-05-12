package Day1;

import java.util.Scanner;
class MyStack{
    //存储数据
    int[] data;
    //栈中元素个数
    int size = 0;
    //栈的最大容量
    int maxSize;
    //栈顶指针
    int top = 0;
    public MyStack(int maxSize){
        this.maxSize = maxSize;
        this.data = new int[maxSize];
    }
    public  void push (int x){
        if (size==maxSize){
            //已达到最大容量
            System.out.println("error");
        }else {
            data[top++]=x;
            size++;
        }
    }
    public void pop(){
        if (size==0){
            System.out.println("栈中已无其他元素");
        }else {
            //打印栈顶元素
            System.out.println(data[--top]);
        }
    }
    public void top(){
        if (size!=0){
            System.out.println(data[top-1]);
        }else {
            System.out.println("栈中已无其他元素");;
        }
    }
}
public class Day1 {

    public static void main(String...args) {
        Scanner scan = new Scanner(System.in) ;
        int n = Integer.parseInt(scan.nextLine()) ;//获取总的操作次数
        MyStack s = new MyStack(n) ;//因为压栈操作的次数一定小于总的操作次数，因此将栈的容量大小设置为 n 一定保险
        while(scan.hasNextLine()) {//获取每一次操作
            String str = scan.nextLine() ;
            String arr[] = str.split(" ") ;
            if(arr[0].equals("push")) {
                s.push(Integer.parseInt(arr[1])) ;
            } else if(arr[0].equals("pop")) {
                s.pop() ;
            } else {
                s.top() ;
            }
        }
    }

}
