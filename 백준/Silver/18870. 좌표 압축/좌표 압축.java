import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = B[i] = Integer.parseInt(st.nextToken());
        }

        // O(N log N)
        Arrays.sort(B);

        // O(N)
        int uniqueCount = 0;
        if (N > 0) {
            int j = 0;
            for (int i = 1; i < N; i++) {
                if (B[j] != B[i]) {
                    B[++j] = B[i];
                }
            }
            uniqueCount = j + 1; // 실제 데이터의 개수
        }

        // O(N log N)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int index = Arrays.binarySearch(B, 0, uniqueCount, A[i]);
            sb.append(index).append(" ");
        }

        System.out.println(sb.toString());
    }
}