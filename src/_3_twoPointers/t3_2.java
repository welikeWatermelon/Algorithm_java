package src._3_twoPointers;

import java.util.Scanner;

public class t3_2 {
    public static int solution(int n, int k, int[] arr) {
        int max = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        max = sum;
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            max = Math.max(max, sum);
        }

        return max;
    }
    public static void main(String[] args) {
        t3_2 T = new t3_2();
        Scanner scanner = new Scanner(System.in);
        int[] k = new int[2];
        for (int i = 0; i < 2; i++) {
            k[i] = scanner.nextInt();
        }
        int n = k[0];
        int m = k[1];

        int[] Arr = new int[n];
        for (int i=0; i < n; i++) {
            Arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, m, Arr));
    }
}
