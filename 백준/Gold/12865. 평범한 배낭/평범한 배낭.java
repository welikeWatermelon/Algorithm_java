import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 물건 개수
        int K = sc.nextInt(); // 가방 무게

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
                if (weights[i] <= w) { // 가방에 들어갈 수 있음
                    dp[i][w] = Math.max(
                            dp[i - 1][w], // 안담았음
                            dp[i - 1][w - weights[i]] + values[i] // 담았음
                            // i번째 물건을 넣을 것을 고려해서 현재 무게에서 물건 무게를 빼고, 그 전에 담겨있던
                            // 최대 가치를 가져와서 현재 물건의 가치와 더하는 것
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println(dp[N][K]);

    }
}
