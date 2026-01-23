import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max = 0, maxVal = 0;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxVal = Math.max(maxVal, board[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;
                checkT(i, j); // DFS로 못 만드는 'ㅜ' 모양 체크
            }
        }

        System.out.println(max);
    }

    static void dfs(int r, int c, int depth, int sum) {
        // 남은 칸을 모두 최댓값으로 채워도 현재 max보다 작으면 탐색 종료
        if (sum + (4 - depth) * maxVal <= max) return;

        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    static void checkT(int r, int c) {
        int count = 0;
        int sum = board[r][c];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                count++;
                sum += board[nx][ny];
                min = Math.min(min, board[nx][ny]);
            }
        }

        // 인접한 칸이 3개면 'ㅜ' 모양 완성
        if (count == 3) {
            max = Math.max(max, sum);
        }
        // 인접한 칸이 4개면 그 중 가장 작은 값을 하나 빼서 'ㅜ' 모양 완성
        else if (count == 4) {
            max = Math.max(max, sum - min);
        }
    }
}