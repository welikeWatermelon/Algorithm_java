import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int INF = 100000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] dist = new int[N + 1][N + 1];

        // 거리배열 초기화하기
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 1; i <= N; i++) {
            dist[i][i] = 0;
        }

        // 입력된 간선 정보 저장
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            dist[from][to] = Math.min(dist[from][to], cost); // a -> b 에서 중복된게 있을 때, 최솟값으로
//            dist[from][to] = cost;
        }

        // 플로이드 워셜 핵심
        for (int k = 1; k <= N; k++) { // 들릴 곳
            for (int i = 1; i <= N; i++) { // 시작
                for (int j = 1; j <= N; j++) { // 도착
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
