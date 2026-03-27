import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 45656
        // 이 수는 인접한 모든 자리의 차이가 1임. 계단 수
        // N이 주어질 때, 길이가 N인 계단수가 총 몇개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아님
        // 첫째줄에 정답을 1,000,000,000 나눈 나머지

        // 1자리수면 1~9 9개임
        // 2자리수면 (10 12), (21 23) ~ (87 89), 98

        // 각 자리수
        long[][] dp = new long[N+1][10];
        // 이걸 어떻게 정의해야하나? dp[n][j] : n자리수고 마지막 숫자가 j임

        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % 1000000000;
            for (int j = 1; j < 9; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % 1000000000;
            }
            dp[i][9] = dp[i - 1][8] % 1000000000;
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i]) % 1000000000;
        }

        System.out.println(answer);
    }
}
