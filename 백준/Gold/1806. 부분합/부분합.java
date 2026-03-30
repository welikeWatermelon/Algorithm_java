import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// s 이상 되는 것 중 가장 짧은 것을 구하라
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0, j = 0, sum = 0, minCnt = Integer.MAX_VALUE;
        while (i<=j) {
            if (s > sum) {
                if (j == n) {
                    break;
                }
                sum += arr[j];
                j++;
            } else {
                minCnt = Math.min(j-i, minCnt);
                sum -= arr[i];
                i++;
            }
        }

        System.out.println(minCnt==Integer.MAX_VALUE ? 0 : minCnt);

    }
}
