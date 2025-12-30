import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] arr = new int[N][N];
        boolean[][] check = new boolean[N][N];
        int group = 0;
        ArrayList<Integer> cntAnswer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    cntAnswer.add(dfs(i, j, arr, check));
                    group++;
                }
            }
        }

        // 출력
        System.out.println(group);
        Collections.sort(cntAnswer);
        for (int i = 0; i < cntAnswer.size(); i++) {
            System.out.println(cntAnswer.get(i));
        }

    }

    public static int dfs(int i, int j, int[][] arr, boolean[][] check){
        check[i][j] = true;
        int count = 1;

        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + i;
            int ny = dy[k] + j;
            if (nx < N && ny < N && nx >= 0 && ny >= 0 && arr[nx][ny] == 1 && !check[nx][ny]) {
                count+= dfs(nx, ny, arr, check);
            }
        }

        return count;
    }
}
