package Day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoDimFind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            strings.add(line);
            if (line.isEmpty()){
                break;
            }
        }
        int toFind = Integer.parseInt(strings.get(0));
        strings.remove(0);
        strings.remove("");

        int twoDSize = strings.get(0).split(" ").length;
        int[][] inputArrs = new int[strings.size()][twoDSize];

        for (int i = 0; i < strings.size(); i++) {
            int[] intArrs = Arrays.stream(strings.get(i).split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            inputArrs[i] = intArrs;
        }

        System.out.println("输入的二维数组为:");
        for (int[] eachArr:inputArrs
             ) {
            for (int item: eachArr
                 ) {
                System.out.print(item+" ");
            }
            System.out.println();
        }

        System.out.println(solution(inputArrs,toFind));

    }

    public static boolean solution(int[][] inputArrs,int toFind) {
        boolean flag = false;
        //i行j列
        int i = 0;
        int j = inputArrs.length-1;
            //1.从右上角开始，当前值比toFind大则列左移
        while (i < inputArrs.length && j > 0) {
            if (inputArrs[i][j] > toFind) {
                j--;
            } else if (inputArrs[i][j] < toFind) {
                i++;
            } else if (inputArrs[i][j] == toFind) {
                flag = true;
                break;
            }

        }
        return flag;
    }
}
