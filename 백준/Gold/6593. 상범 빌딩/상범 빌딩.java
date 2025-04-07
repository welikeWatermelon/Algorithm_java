import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static char[][][] arr;
    public static boolean[][][] checked;
    public static int L,R, C;
    public static int startZ, startX, startY;
    public static int endZ, endX, endY;
    public static int[] dz = {0, 0, 0, 0, 1, -1}; // 남 북 동 서 상 하
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            L = sc.nextInt(); // 층
            R = sc.nextInt(); // 행
            C = sc.nextInt(); // 열
            sc.nextLine();
            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            arr = new char[L][R][C];
            checked = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String tmp = sc.nextLine();
                    for (int k = 0; k < C; k++) {
                        arr[i][j][k] = tmp.charAt(k);
                        if (arr[i][j][k] == 'S') {
                            startZ = i;
                            startX = j;
                            startY = k;
                        }

                        if (arr[i][j][k] == 'E') {
                            endZ = i;
                            endX = j;
                            endY = k;
                        }
                    }
                }
                sc.nextLine();
            }
            int answer = BFS(0);

            if (answer == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n",answer);
            }
        }
    }

    public static int BFS(int cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startZ, startX, startY,cnt});
        checked[startZ][startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowZ = now[0];
            int nowX = now[1];
            int nowY = now[2];
            int nowCnt = now[3];

            if (nowZ == endZ && nowX == endX && nowY == endY) {
                return nowCnt;
            }

            for (int i = 0; i < 6; i++) {
                int nz = nowZ + dz[i];
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nz >= 0 && nz < L && nx >= 0 && nx < R && ny >= 0 && ny < C && !checked[nz][nx][ny] && arr[nz][nx][ny] != '#') {
                    q.add(new int[]{nz, nx, ny, nowCnt + 1});
                    checked[nz][nx][ny]=true;
                }
            }

        }

        return -1;
    }
}
