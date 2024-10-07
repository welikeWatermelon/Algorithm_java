package src.array;
//다시 해야한다

import java.util.Arrays;
import java.util.Scanner;

public class array8_2 {
    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j : arr) {
                if (arr[i] < j) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        array8_2 T = new array8_2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(T.solution(n, arr)[i]+1 +" ");
        }

    }
}
