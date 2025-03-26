import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int K = sc.nextInt();
        arr = new int[N][M];
        for (int k = 0; k < K; k++) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int b1 = sc.nextInt();
            int b2 = sc.nextInt();
            for (int i = a1; i < b1; i++) {
                for (int j = a2; j < b2; j++) {
                    arr[i][j] = 1;
                }
            }
        }
        ArrayList<Integer> cnt = new ArrayList<>();
        int allCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    cnt.add(DFS(i,j,1));
                    allCnt++;
                }
            }
        }

        Collections.sort(cnt);
        System.out.println(allCnt);
        for (int c : cnt) {
            System.out.print(c + " ");
        }



    }

    public static int DFS(int i, int j, int cnt) {
        arr[i][j] = 1;
        for (int s = 0; s < 4; s++) {
            int nx = i + dx[s];
            int ny = j + dy[s];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny]==0) {
                arr[nx][ny]=1;
                cnt = DFS(nx, ny, cnt + 1);
            }
        }
        return cnt;
    }
}
