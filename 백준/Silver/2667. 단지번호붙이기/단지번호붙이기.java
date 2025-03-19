import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int N,cnt;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] arr;
    public static boolean[][] checked;

    //체크드 하고, 계속 카운트 세줘야함
    // 만약 카운트 다하고 만약 다음 단지로 이동할 경우 cnt = 0으로 초기화 시켜줘야함
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        checked = new boolean[N][N];
        ArrayList<Integer> answers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!checked[i][j] && arr[i][j] == 1) {
                    checked[i][j] = true;
                    cnt = 1;
                    DFS(i, j);
                    answers.add(cnt);
                }
            }
        }

        int leng = answers.size();
        System.out.println(leng);

        if (leng != 0) {
            Collections.sort(answers);
            for (int i = 0; i < leng-1; i++) {
                System.out.println(answers.get(i));
            }
            System.out.print(answers.get(leng-1));
        }

    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 1 && !checked[nx][ny]) {
                checked[nx][ny] = true;
                cnt++;
                DFS(nx, ny);
            }
        }
    }
}
