import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            int[][] sum = new int[N][2];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            sum[0][0] = arr[0][0];
            sum[0][1] = arr[0][1];
            if (N != 1) {
                sum[1][0] = arr[0][1] + arr[1][0];
                sum[1][1] = arr[0][0] + arr[1][1];
            }


            for (int j = 2; j < N; j++) {

                sum[j][0] = Math.max(sum[j - 1][1], sum[j - 2][1]) + arr[j][0];
                sum[j][1] = Math.max(sum[j - 1][0], sum[j - 2][0]) + arr[j][1];
            }

            System.out.println(Math.max(sum[N - 1][0], sum[N - 1][1]));
        }
    }
}
