import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// n : 500
// 대나무 양은 1,000,000 보다 작거나 같은 자연수
// 2초
// n^2 끄떡없음

// 돼지판다는 현재 먹은것보다 더 많이 먹기 위해 움직임
// 1. 처음에 어떤 지점에 풀어 놓아야 하는지 -> n^2 (250,000)
// 2. 어떤 곳으로 이동시켜야 최대한 많은 칸을 방문할 지

// 목적은 최대한 많은 칸을 이동하는 것
// 제한 사항은
// 1. 처음 위치를 바꿀 수 있음.
// 2. 숫자가 현재 위치보다 큰 쪽으로만 이동함


// 한 곳에 풀었다고 가정 (x,y)
// dp[x][y]는 x,y에서 갈 수 있는 최대 움직임
// 주변을 탐색하며 진행 dp[x][y] = Math.max(dp[x+1][y],dp[x-1][y],dp[x][y-1],dp[x][y+1]) + 1
// -> dp[x][y] = 1로 넣고, for문을 돌리며 dp를 업데이트 하도록 하자
// 그럼 dp는 언제 업데이트 해줘야하나? -> dfs 돌랴? bfs돌려? 재귀로 들어가야하니까 dfs 사용해보자,,



public class Main {
    public static int n;
    public static int[][] map;
    public static int[][] dp;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dfsResult = dfs(i, j);
                if (max < dfsResult) {
                    max = dfsResult;
                }
            }
        }

        System.out.println(max);

    }

    public static int dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (dp[x][y] == 0) {
            return 0;
        }

        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (map[x][y] < map[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
            }
        }

        return dp[x][y];
    }
}
