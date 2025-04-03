import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        int[] square = new int[(int) Math.sqrt((double) N)];
        for (int i = 0; i < square.length; i++) {
            square[i] = i+1;
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = 987654321;
        }

        for (int i = 0; i < square.length; i++) {
            for (int j = square[i]*square[i]; j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[j - square[i] * square[i]] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
