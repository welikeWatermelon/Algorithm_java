package src.array;

import java.util.Scanner;

public class array9 {
    public static int solution(int n, int[][] arr) {
        int sum;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[i][j]; //행의 합
            }
            if (sum > max) {
                max = sum;
            }
        }

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[j][i]; //열의 합
            }
            if (sum > max) {
                max = sum;
            }
        }

        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][i];
        }
        if (sum > max) {
            max = sum;
        }

        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][n-i-1];
        }
        if (sum > max) {
            max = sum;
        }
        return max;
    }
    public static void main(String[] args) {
        array9 T = new array9();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(T.solution(n,arr));
    }
}
