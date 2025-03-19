import java.util.Scanner;

public class Main {
    public static int N, p1Cnt, p2Cnt;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        char[][] p1 = new char[N][N];
        char[][] p2 = new char[N][N];
        boolean[][] checked1 = new boolean[N][N];
        boolean[][] checked2 = new boolean[N][N];

        // p1, p2 입력
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < N; j++) {
                p1[i][j] = tmp.charAt(j);
                if (p1[i][j] == 'R') {
                    p2[i][j] = 'G';
                } else {
                    p2[i][j] = p1[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!checked1[i][j]) {// 방문 안했으면 돌아야함
                    p1Cnt++;
                    DFS(i, j, p1,checked1);
                }
                if (!checked2[i][j]) {
                    p2Cnt++;
                    DFS(i, j, p2, checked2);
                }
            }
        }

        System.out.println(p1Cnt + " " + p2Cnt);

    }

    public static void DFS(int x, int y, char[][] arr, boolean[][] checked) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !checked[nx][ny] && arr[nx][ny] == arr[x][y] ) {
                checked[nx][ny] = true;
                DFS(nx, ny, arr,checked);
            }
        }
    }
}
