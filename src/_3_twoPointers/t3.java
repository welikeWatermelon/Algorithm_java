package src._3_twoPointers;

import java.util.Scanner;

public class t3 {
    public static int solution(int n, int m, int[] Arr) {
        int max=0;
        int[] sumArr = new int[n];
        sumArr[0] = Arr[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + Arr[i];
        }

        for (int i = m; i <= (n - m-1); i=i+m) {
            if (sumArr[i]-sumArr[i-m] > max) {
                max = sumArr[i+m-1]-sumArr[i];
            }
        }

        return max;
    }
    public static void main(String[] args) {
        t3 T = new t3();
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
