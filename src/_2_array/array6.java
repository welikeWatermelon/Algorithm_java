package src._2_array;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class array6 {
    public static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> finalAnswer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = String.valueOf(arr[i]);
            str = new StringBuilder(str).reverse().toString();
            answer.add(Integer.parseInt(str));
        }

        for (Integer i : answer) {
            boolean flag = true;
            for (int j = 2; j <= sqrt(i); j++) {
                if (i % j == 0) { //소수가 아니면
                    flag = false;
                    break;
                }
            }
            if (i == 1) {
                continue;
            }
            if (flag) {
                finalAnswer.add(i);
            }
        }
        return finalAnswer;
    }
    public static void main(String[] args) {
        array6 T = new array6();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (Integer i : T.solution(n,arr)) {
            System.out.printf("%d ",i);
        }
    }
}
