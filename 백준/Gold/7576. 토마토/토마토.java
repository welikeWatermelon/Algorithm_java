import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int N;
    public static int M;

    public static int[][] arr;
    public static boolean[][] visited;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        arr = new int[N][M];
        visited = new boolean[N][M];

        ArrayList<int[]> finishTomato = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tomato = sc.nextInt();
                arr[i][j] = tomato;
                if (tomato == 1) {
                    finishTomato.add(new int[]{i, j,0});
                    visited[i][j] = true;
                }
            }
        }

        int cnt = bfs(finishTomato);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }

    public static int bfs(ArrayList<int[]> finishTomato){
        Queue<int[]> q = new LinkedList<>();
        q.addAll(finishTomato);

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] nowTomato = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nowTomato[0] + dx[i];
                int ny = nowTomato[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = 1;
                    cnt = nowTomato[2] + 1;
                    q.add(new int[]{nx, ny, cnt});
                }
            }
        }
        return cnt;
    }
}
