import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        boolean[][] checked = new boolean[N][M];
        ArrayList<Integer> cntArr = new ArrayList<>();
        int num = 0;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int mx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !checked[i][j]) {
                    checked[i][j] = true;
                    num++;
                    cnt = 1;
                    DFS(arr, N, M, i, j, cntArr,checked);
                    mx = Math.max(mx, cnt);
                }
            }
        }

        System.out.println(num);
        System.out.println(mx);

    }

    public static void DFS(int[][] arr, int N, int M,int x, int y,ArrayList<Integer> cntArr, boolean[][] checked) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1 && !checked[nx][ny]) {
                checked[nx][ny] = true;
                DFS(arr,N,M,nx,ny,cntArr,checked);
                cnt++;
            }
        }
    }
}
