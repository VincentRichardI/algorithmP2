package Day2;

import java.util.Scanner;

/*
* 替换字符串中的空格
* */
public class ReplaceSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String result="";
        for (Character c:str.toCharArray()
             ) {
            if (c.equals(' ')){
                result+="%";
            }else {
                result+=c;
            }
        }
        System.out.println(result);
    }
}
