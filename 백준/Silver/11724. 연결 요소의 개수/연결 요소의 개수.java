import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static boolean[] checked;

    public static void main(String[] args) throws IOException {
        //  Scanner 대신 BufferedReader + StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        checked = new boolean[N + 1];
        checked[0] = true;

        //  간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        int cnt = 0;
        while (isAllTrue() != -1) {
            cnt++;
            int idx = isAllTrue();
            DFS(idx);
        }

        System.out.println(cnt);
    }

    public static void DFS(int idx) {
        checked[idx] = true; // 자기 자신 방문 처리 빠졌으므로 추가
        for (int i = 1; i <= N; i++) {
            if (arr[idx][i] == 1 && !checked[i]) {
                DFS(i);
            }
        }
    }

    public static int isAllTrue() {
        for (int i = 1; i <= N; i++) {
            if (!checked[i]) {
                return i;
            }
        }
        return -1;
    }
}
