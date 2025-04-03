import java.util.Scanner;

public class Main {
    public static int[] dx = {0, 1}; // 우 아
    public static int[] dy = {1, 0};
    public static int[][] arr;
    public static long[][] dp;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.println(DFS(0, 0));
    }

    public static long DFS(int x, int y) {

        // 도착점에 도달
        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        // 중간에 0 만나면 어디도 못감 그냥 거긴 안되는거임
        if (arr[x][y]==0) {
            return 0;
        }

        // 이미 들렸던 곳이면 바로 return
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        // 처음 계산하는 경우
        // 초기화 시키는거지
        // 만약 이게 -1이였다면 이쪽으로 오는거임
        // -1이 아니면 이미 들렸던거니까 위의 코드로 가는거지
        // return dp[x][y]
        
        dp[x][y] = 0;

        int step = arr[x][y];
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * step;
            int ny = y + dy[i] * step;
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                dp[x][y] += DFS(nx, ny);
            }
        }
        return dp[x][y];
    }
}

// 오른쪽이나 아래쪽으로만 이동해
// 0은 더 이상 진행을 막는 종착점
// 한 번 점프를 할 때, 방향을 바꾸면 안 된다
// 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.