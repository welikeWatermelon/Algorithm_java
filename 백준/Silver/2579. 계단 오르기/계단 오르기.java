import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 한 번에 한 계단 or 두 계단 오를 수 있음
// 연속된 세 개의 계단을 모두 밟으면 안됨 (시작점은 포함 X)
// 마지막 도착 계단은 반드시 밟아야함

// 계단마다 점수가 있는데
// 점수의 총합의 최대를 구하라

// dp[i] 는 i까지 오를 때, 최대 점수라고 정의하자

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine()); // 계단 수
        int[] stepScore = new int[cnt + 1]; // 계단의 점수
        int[][] dp = new int[301][3];

        for (int i = 1; i <= cnt; i++) {
            stepScore[i] = Integer.parseInt(br.readLine());
        }

        dp[1][0] = 0;
        dp[1][1] = stepScore[1];
        dp[1][2] = 0;

        // dp[i][0] : i번째 안밟음
        // dp[i][0] : i번째 밟음 (연속 1번)
        // dp[i][0] : i번째 밟음 (연속 2번)

        for (int i = 2; i <= cnt; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = stepScore[i] + dp[i - 1][0]; // 연속 1번
            dp[i][2] = stepScore[i] + dp[i - 1][1]; // 연속 2번
        }

        System.out.println(Math.max(dp[cnt][1],dp[cnt][2]));

    }
}
