package Day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Rep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arrStr = str.split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        Integer[] result = solution(arr);
        for (int each:result
             ) {
            System.out.print(each+" ");
        }

    }

    public static Integer[] solution(int[] arr){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int item:arr
             ) {
            if (hashMap.get(item)==null){
                hashMap.put(item,1);
            }else {
                hashMap.put(item,hashMap.get(item).intValue()+1);
            }
        }
        for (int key:hashMap.keySet()
             ) {
            if (hashMap.get(key)>1){
                integers.add(key);
            }
        }
        int size = integers.size();
        Integer[] result = integers.toArray(new Integer[size]);
        return result;
    }
}
