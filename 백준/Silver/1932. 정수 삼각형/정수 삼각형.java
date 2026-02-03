import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][];
        int[][] sum = new int[n][];

        arr[0] = new int[1];
        sum[0] = new int[1];

        arr[0][0] = Integer.parseInt(br.readLine());
        sum[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            arr[i] = new int[i + 1];
            sum[i] = new int[i + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + arr[i][j];
                } else if (j == i) {
                    sum[i][j] = sum[i - 1][j - 1] + arr[i][j];
                } else {
                    sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + arr[i][j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(sum[n - 1][i], max);
        }

        System.out.println(max);

    }
}
