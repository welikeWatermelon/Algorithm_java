package tree;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1231 {
    static String[] word;
    static int[] child1;
    static int[] child2;
    static int lth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            lth = sc.nextInt();
            sc.nextLine();
            word = new String[lth + 1];
            child1 = new int[lth + 1];
            child2 = new int[lth + 1];
            for (int i = 1; i <= lth; i++) {
                String[] input = sc.nextLine().split(" ");
                word[i] = input[1];
                if (input.length == 3) {
                    child1[i] = Integer.parseInt(input[2]);
                } else if (input.length == 4) {
                    child1[i] = Integer.parseInt(input[2]);
                    child2[i] = Integer.parseInt(input[3]);
                }
            }
            System.out.print("#"+t+" ");
            inOrder(1);
            System.out.println();

//            System.out.println(Arrays.toString(word));
//            System.out.println(Arrays.toString(child1));
//            System.out.println(Arrays.toString(child2));

        }
    }

    public static void inOrder(int index) {
        if(index>lth) return;
        inOrder(index * 2);
        System.out.print(word[index]);
        inOrder(index * 2+1);
    }

}
