package s_0324;

import java.util.Scanner;

public class swea_1227 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N, startX, startY,endX, endY;
    public static boolean[][] checked;
    public static int[][] arr;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            N = 100;
            checked = new boolean[N][N];
            sc.next();
            arr = new int[N][N];
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
            if(nx<0 || ny<0 || nx>=N || ny>=N || arr[nx][ny]==1) continue;

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
