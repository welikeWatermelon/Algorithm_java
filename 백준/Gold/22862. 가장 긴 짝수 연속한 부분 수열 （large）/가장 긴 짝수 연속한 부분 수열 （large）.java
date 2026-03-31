import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열 길이
        int K = Integer.parseInt(st.nextToken()); // 최대 횟수
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int oddCnt = 0;
        int evenCnt = 0;
        int maxEvenCnt = 0;

        while (j < N) {
            if (oddCnt == K+1) {
                if (arr[i] % 2 == 0) {
                    evenCnt--;
                    i++;
                } else {
                    oddCnt--;
                    i++;
                }
            }else{
                if (arr[j] % 2 == 0) {
                    evenCnt++;
                    j++;
                } else {
                    oddCnt++;
                    j++;
                }
            }
            maxEvenCnt = Math.max(maxEvenCnt, evenCnt);
        }

        System.out.println(maxEvenCnt);
    }
}
