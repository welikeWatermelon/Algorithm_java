package src._3_twoPointers;

import java.util.Scanner;

public class t4_2 {
    public static int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        // 증가하고 더하고 확인
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if(sum==m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        t4_2 T = new t4_2();
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[2];
        for (int i = 0; i < 2; i++) {
            a[i]=scanner.nextInt();
        }
        int n = a[0];
        int m = a[1];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(n, m, arr));

    }
}
/*
다시해야함 생각이 안남
 */