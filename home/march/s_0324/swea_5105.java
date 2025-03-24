package s_0324;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_5105 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int startX=0;
        int startY=0;
        int endX=0;
        int endY=0;
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            checked = new boolean[N][N];
            sc.nextLine();
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                char[] tmp = sc.next().toCharArray();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = tmp[j] - '0';
                    if (arr[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }

                    if (arr[i][j] == 3) {
                        endX = i;
                        endY = j;
                    }
                }
            }

            System.out.printf("#%d %d\n",t,BFS(startX, startY, endX, endY, N, arr));
        }
    }

    public static int BFS(int startX, int startY, int endX, int endY, int N, int[][] arr) {
        Queue<int[][]> answerArr = new LinkedList<>();
        int[][] tmp = new int[1][3];
        tmp[0][0] = startX;
        tmp[0][1] = startY;
        tmp[0][2] = 0;
        checked[startX][startY] = true;
        answerArr.add(tmp);



        while (!answerArr.isEmpty()) {
            int[][] tmpArr = answerArr.poll();
            startX = tmpArr[0][0];
            startY = tmpArr[0][1];
            int cnt = tmpArr[0][2];

            for (int i = 0; i < 4; i++) {
                int nx = startX + dx[i];
                int ny = startY + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 0 && !checked[nx][ny]) {
                    checked[nx][ny] = true;
                    tmp = new int[1][3];
                    tmp[0][0] = nx;
                    tmp[0][1] = ny;
                    tmp[0][2] = cnt+1;
                    answerArr.add(tmp);
                }
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && endX==nx && endY == ny) {
                    return cnt;
                }
            }
        }

        return 0;
    }
}

