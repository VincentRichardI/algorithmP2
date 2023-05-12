package Day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

//在长度为n+1的数组中找出重复数字，数组中数字<n
public class Repetition2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrLength = scanner.nextInt();
        int[] ints = new int[arrLength];
        Random random = new Random();
        for (int i = 0; i <arrLength ; i++) {
            ints[i] = random.nextInt(arrLength);
        }
        System.out.println("随机生成的数组为:");
        for (int item:ints
             ) {

            System.out.print(item+" ");
        }
        Integer[] result = solution(ints);
        System.out.println("重复的数字为：");
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
