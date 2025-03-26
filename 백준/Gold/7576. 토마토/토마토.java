import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static int N,M;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
//    public static ArrayList<int[]> isOne;
    // 1이 있는 배열을 넘겨주고, 모두 queue에 넣자
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 열
        N = sc.nextInt(); // 행
        int startX=0;
        int startY=0;
        arr = new int[N][M];
        ArrayList<int[]> isOne = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    isOne.add(new int[]{i, j,0});
                }
            }
        }
        int answer = BFS(isOne);
        if (isThereZero()) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }

    public static int BFS(ArrayList<int[]> isOne) {
        Queue<int[]> q = new LinkedList<>();
        for (int[] tmpArr : isOne) {
            q.add(tmpArr);
        }

        int answer=-1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cnt = tmp[2];
            answer = cnt;
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    q.add(new int[]{nx, ny, cnt + 1});
                }
            }

        }
        return answer;
    }

    public static boolean isThereZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
