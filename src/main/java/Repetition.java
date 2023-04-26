import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//在数组中找出重复的数字
public class Repetition {

    public static Integer[]  solution(int arr[]){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //hash表中若没有，则放入，若有则累加
            if(!hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],1);
            }else {
                hashMap.put(arr[i],hashMap.get(arr[i])+1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer key:hashMap.keySet()
             ) {
            if (hashMap.get(key)>1){
                list.add(key);
            }
        }

        return list.toArray(new Integer[list.size()]);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] eachNum = line.split(" ");
        int arr[] = new int[eachNum.length];
        for (int i = 0; i < eachNum.length; i++) {
            arr[i] = Integer.parseInt(eachNum[i]);
        }
        Integer arr2[] = solution(arr);
        for (Integer val: arr2
             ) {
            System.out.print(val+" ");
        }
    }
}
