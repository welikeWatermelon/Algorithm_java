import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        // 전의 숫자들의 합이 윗칸에 있으면, 그 아래 칸은 자동으로 채울 수 있음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] maxSum = new int[3];
        int[] minSum = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxSum[0] = x;
                minSum[0] = x;
                maxSum[1] = y;
                minSum[1] = y;
                maxSum[2] = z;
                minSum[2] = z;
                continue;
            }

            int beforeMaxSumX = maxSum[0];
            int beforeMaxSumY = maxSum[1];
            int beforeMaxSumZ = maxSum[2];

            int beforeMinSumX = minSum[0];
            int beforeMinSumY = minSum[1];
            int beforeMinSumZ = minSum[2];

            maxSum[0] = Math.max(beforeMaxSumX, beforeMaxSumY) + x;
            maxSum[1] = Math.max(Math.max(beforeMaxSumX, beforeMaxSumY),beforeMaxSumZ) + y;
            maxSum[2] = Math.max(beforeMaxSumY, beforeMaxSumZ) + z;

            minSum[0] = Math.min(beforeMinSumX, beforeMinSumY) + x;
            minSum[1] = Math.min(Math.min(beforeMinSumX, beforeMinSumY),beforeMinSumZ) + y;
            minSum[2] = Math.min(beforeMinSumY, beforeMinSumZ) + z;
        }

        System.out.println(Math.max(Math.max(maxSum[0], maxSum[1]), maxSum[2]) + " " + Math.min(Math.min(minSum[0], minSum[1]), minSum[2]));
    }
}
