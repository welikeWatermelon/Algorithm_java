import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int r, c, d;
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        clean();
        System.out.println(cnt);
    }

    public static void clean() {
        while (true) {
            // 1. 현재 칸 청소
            if (map[r][c] == 0) {
                map[r][c] = 2;
                cnt++;
            }

            boolean moved = false;

            // 2. 주변 4칸 확인
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            // 3. 후진
            int back = (d + 2) % 4;
            int bx = r + dx[back];
            int by = c + dy[back];

            if (map[bx][by] == 1) break; // 벽이면 종료

            r = bx;
            c = by;
        }
    }
}
