import java.util.*;

public class Main {
    public static int N, futureNightX, futureNightY;
    public static int[][] arr;
    public static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static boolean[][] checked;
    public static boolean[] visitedDFS;
    public static boolean[] visitedBFS;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  // 테스트의 개수
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt(); // 체스판 한 변의 길이
            arr = new int[N][N];
            int nowNightX = sc.nextInt();
            int nowNightY = sc.nextInt();
            futureNightX = sc.nextInt();
            futureNightY = sc.nextInt();
            checked = new boolean[N][N];
            checked[nowNightX][nowNightY] = true;
            if (nowNightX == futureNightX && nowNightY == futureNightY) {
                System.out.println(0);
            } else {
                BFS(nowNightX, nowNightY);
            }
        }
    }

    public static void BFS(int nowNightX, int nowNightY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{nowNightX, nowNightY,0});
        while (!q.isEmpty()) {
            int[] nowPlace = q.poll();
            if (nowPlace[0] == futureNightX && nowPlace[1] == futureNightY) {
                System.out.println(nowPlace[2]);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = nowPlace[0] + dx[i];
                int ny = nowPlace[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !checked[nx][ny]) {
                    checked[nx][ny] = true;
                    q.add(new int[]{nx, ny,nowPlace[2]+1});
                }
            }
        }

    }
}
