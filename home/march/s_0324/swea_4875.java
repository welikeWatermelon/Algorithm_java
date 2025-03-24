package s_0324;

import java.util.Scanner;

public class swea_4875 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] checked;
    public static int startX,startY,endX,endY,N,flag;
    public static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        startX=0;
        startY=0;
        endX=0;
        endY=0;
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            checked = new boolean[N][N];
            sc.nextLine();
            arr = new int[N][N];
            flag = 0;
            for (int i = 0; i < N; i++) {
                char[] tmp = sc.next().toCharArray();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = tmp[j] - '0';
                    if (arr[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }
            DFS(startX, startY);
            if (flag == 1) {
                System.out.printf("#%d %d\n", t, flag);
            } else {
                System.out.printf("#%d %d\n", t,0);
            }
        }
    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 3) {
                flag = 1;
                return;
            }

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny]==0 && !checked[nx][ny]) {
                checked[nx][ny] = true;
                DFS(nx, ny);
                checked[nx][ny] = false;
            }
        }
    }
}
