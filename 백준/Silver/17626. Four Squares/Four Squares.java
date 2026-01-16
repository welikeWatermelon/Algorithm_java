import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int minVal = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                minVal = Math.min(minVal, dp[i - j * j]);
            }

            dp[i] = minVal + 1;
        }

        System.out.println(dp[n]);
    }
}