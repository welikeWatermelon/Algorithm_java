import java.util.Scanner;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] checked;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        checked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String st = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = st.charAt(j) - '0';
            }
        }

        for (int i = 0; i < M; i++) {
            if (arr[0][i] == 0 && !checked[0][i]) { //이어져 있는거면 무시됨
                DFS(0, i);
                //DFS 시작 -> 경로 체크
            }
        }

        int flag = 0;
        for (int i = 0; i < M; i++) {
            if (checked[N - 1][i]) {
                System.out.println("YES");
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            System.out.println("NO");
        }


    }

    // 이 DFS는 경로만 check 해줄거임
    //
    // 기저조건이 필요 없는 이유는
    // 조건에 만족하지 않으면 알아서 DFS로 빠지지 않고, 끝까지 나와서 종료될 것이기 때문
    public static void DFS(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny]==0 && !checked[nx][ny]) {
                checked[nx][ny] = true;
                DFS(nx, ny);
            }

        }


    }
}
