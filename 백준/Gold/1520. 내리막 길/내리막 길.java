import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[][] map;
    public static int[][] dp;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0,0));
    }

    public static int DFS(int x, int y) {

        if (x == M - 1 && y == N - 1) {
            return 1;
        }
        // 다른 값이 설정 되었다면
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (dp[x][y] == 0) {
            return 0;
        }

        // 이제 dp[x][y]가 -1인 즉, 초기화 상태라면
        // 계산을 해줘야함
        dp[x][y] = 0;
        // 이제 x,y 상황 계산 시작임
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            if (map[x][y] > map[nx][ny]) {
                dp[x][y] += DFS(nx, ny);
            }
        }
        return dp[x][y];
    }
}
