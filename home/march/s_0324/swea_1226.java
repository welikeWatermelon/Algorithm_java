package s_0324;

import java.util.Scanner;

public class swea_1226 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N, startX, startY,endX, endY;
    public static boolean[][] checked;
    public static int[][] arr;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            checked = new boolean[16][16];
            sc.next();
            arr = new int[16][16];
            for (int i = 0; i < 16; i++) {
                char[] tmp = sc.next().toCharArray();
                for (int j = 0; j < 16; j++) {
                    arr[i][j] = tmp[j] - '0';
                    if (arr[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }
            checked[startX][startY] = true;

            if (DFS(startX, startY)) {
                System.out.printf("#%d %d\n", t, 1);
            } else {
                System.out.printf("#%d %d\n", t, 0);
            }

        }
    }

    public static boolean DFS(int x, int y) {


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=16 || ny>=16 || arr[nx][ny]==1) continue;

            if (arr[nx][ny] == 3) {
                return true;
            }

            if (arr[nx][ny]==0 && !checked[nx][ny]) {
                checked[nx][ny] = true;
                if(DFS(nx,ny)) return true;
            }

        }

        return false;
    }
}
