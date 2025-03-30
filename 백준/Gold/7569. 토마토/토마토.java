import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][][] arr;
    public static int N,M,H;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[] dz = {1, -1,0};
    //    public static ArrayList<int[]> isOne;
    // 1이 있는 배열을 넘겨주고, 모두 queue에 넣자
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 열
        N = sc.nextInt(); // 행
        H = sc.nextInt();
        int startX=0;
        int startY=0;
        arr = new int[H][N][M];
        ArrayList<int[]> isOne = new ArrayList<>();
        for (int z = 0; z < H; z++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[z][i][j] = sc.nextInt();
                    if (arr[z][i][j] == 1) {
                        isOne.add(new int[]{z, i, j, 0});
                    }
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
            int cnt = tmp[3];
            answer = cnt;
            for(int z=0; z<2; z++) {
                int nz = tmp[0] + dz[z];
                if (nz >= 0 && nz < H) {
                    if (arr[nz][tmp[1]][tmp[2]] == 0) {
                        arr[nz][tmp[1]][tmp[2]] = 1;
                        q.add(new int[]{nz, tmp[1], tmp[2], cnt + 1});
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = tmp[1] + dx[i];
                int ny = tmp[2] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[tmp[0]][nx][ny] == 0) {
                    arr[tmp[0]][nx][ny] = 1;
                    q.add(new int[]{tmp[0],nx, ny, cnt + 1});
                }
            }

        }
        return answer;
    }

    public static boolean isThereZero() {
        for (int z = 0; z < H; z++)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[z][i][j] == 0) {
                        return true;
                    }
                }
            }
        return false;
    }
}
