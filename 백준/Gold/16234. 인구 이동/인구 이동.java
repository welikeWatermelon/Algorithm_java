import java.util.*;

public class Main {
    public static int N, L, R;
    public static int[][] arr;
    public static boolean[][] checked;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static List<int[]> openWhere;
    public static int sum,cnt;
    public static int flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        int answer = 0;
        while (true) {
            checked = new boolean[N][N];
            boolean move = false; // 이번 턴에 이동 발생 여부

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!checked[i][j]) {
                        openWhere = new ArrayList<>();
                        sum = arr[i][j];
                        cnt = 1;
                        checked[i][j] = true;
                        openWhere.add(new int[]{i, j});
                        DFS(i, j);

                        if (openWhere.size() > 1) {
                            ave(sum / cnt);
                            move = true;
                        }
                    }
                }
            }

            if (!move) break; // 이동이 없으면 종료
            answer++;
        }
        System.out.println(answer);
    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N
                    && !checked[nx][ny] && isOpen(x, y, nx, ny)) {
                sum += arr[nx][ny];
                cnt += 1;
                checked[nx][ny]=true;
                openWhere.add(new int[]{nx,ny});
                DFS(nx, ny);
            }
        }
    }

    public static boolean isOpen(int x, int y, int nx, int ny){
        int sub = Math.abs(arr[x][y]-arr[nx][ny]);
        if (sub <= R && sub >= L) {
            return true;
        }
        return false;
    }

    public static void ave(int average){
        for (int[] c : openWhere) {
            arr[c[0]][c[1]]=average;
        }
    }
}
