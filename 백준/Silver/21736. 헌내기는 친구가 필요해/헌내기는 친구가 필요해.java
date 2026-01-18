import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static char[][] arr;
    public static int N;
    public static int M;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int cnt;
    public static boolean[][] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        checked = new boolean[N][M];
        int nowX = 0;
        int nowY = 0;

        for (int i = 0; i < N; i++) {
            String now = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = now.charAt(j);
                if (arr[i][j] == 'I') {
                    nowX = i;
                    nowY = j;
                }

            }
        }

        dfs(nowX, nowY);
        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }

    }

    public static void dfs(int nowX, int nowY) {

        checked[nowX][nowY] = true;

        if (arr[nowX][nowY] == 'P') {
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = nowX + dx[i];
            int ny = nowY + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] != 'X' && !checked[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
