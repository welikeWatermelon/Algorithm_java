package src._2_array;

import java.util.Scanner;

public class array4_2_refac {
    public static int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        array4_2_refac T = new array4_2_refac();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i : T.solution(n)) {
            System.out.print(i+" ");
        }
    }
}
