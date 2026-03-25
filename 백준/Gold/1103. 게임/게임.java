import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 게임을 오래 하는게 목표
// 1. 바깥으로 가면 끝
// 2. 구멍에 빠지지 않으며 오래 가는 것이 목표 (중간에 갈 때 구멍은 무시함)
// 최대 몇 번의 동전을 움직일 수 있는지 구해라

// 만약 무한번 움직일 수 있다면 -1 출력 -> 전의 위치 A와 후의 위치 B가 왔다갔다 하면 무한번 (근데 사이에도 많은 과정이 있을수도 있지.
// 이건 (x,y)에서 시작해서 다시 (x,y)로 가게 된다면 무한 상황
// (x,y)에서 굳이 시작을 안해도 visited = true인 곳을 간다면 바로 -1 출력

// 그게 아니라면 정답 출력

// 0,0 에서 시작
// N,M < 50
// 각 숫자는 1~9

// DFS, BFS 다 상관없을 듯
// 이것도 메모이제이션 같은데?
// dp와 메모이제이션은 다른건가?
//
// Top-Down 방식 먼저 해보자 -> DFS로 갈거임
// 해당 칸의 수를 num 이라고 하고

// 네 방향으로 num 만큼 이동
// 해당 위치가 범위 밖이거나 구멍이면 +1
// 해당 위치가 숫자면 dp[x][y] = dfs(nx,ny) + 1

// dfs(x,y)의 return값은  dp[x][y]



public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N, M;
    public static char[][] board;
    public static int[][] dp;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                dp[i][j] = -1;
            }
        }

        visited[0][0] = true;

        int tmpAnswer = DFS(0, 0);

        System.out.println(tmpAnswer);

    }

    public static int DFS(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int num = board[x][y] - '0';

        // 시작
        visited[x][y] = true;
        dp[x][y] = 0;
        int maxDist = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * num;
            int ny = y + dy[i] * num;

            // 빠지면 1 반환
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny]=='H') {
                maxDist = Math.max(maxDist, 0);
                continue;
            }


            if (visited[nx][ny]) {
                // 이 때 이 재귀깊이까지 왔어도 전의 DFS까지 다 없애고 나가고 싶은데? 그러지 않으면 계속 수가 증가할 수도 있는거 아님?
                return -1; // -> -1의 전파
                // 또는 System.exit(0)을 쓰면 프로그램 종료. 근데 프로그램이 종료되는게 아니라 함수만 종료되야하는거 아님? ㅇㅇ -> 비추
                // 또는 예외처리하고 main에서 try-catch로 잡아줌
            }


            int t = DFS(nx,ny);
            if (t == -1) {
                return -1;
            }
            maxDist = Math.max(maxDist, t);
        }
        dp[x][y] = maxDist + 1;
        visited[x][y] = false;

        return dp[x][y];
    }
}
