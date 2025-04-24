import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int INF = 1000000000; // 무한을 의미하는 값
    static int N, M; // N: 정점 수, M: 간선 수
    static int[][] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점
        int M = sc.nextInt(); // 간선
        int X = sc.nextInt(); // 목적지

        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(); // 출발
            int v = sc.nextInt(); // 도착
            int w = sc.nextInt(); // 가중치
            dist[u][v] = Math.min(dist[u][v], w); // 중복 간선 처리
        }

        // 플로이드-워셜 핵심 로직
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            int sum = 0;
            sum += dist[i][X];
            sum += dist[X][i];
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}


// 각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야 한다.
// 하지만 이 학생들은 워낙 게을러서 최단 시간에 오고 가기를 원한다.

// 이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다.
// N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.

// X에서 각 마을까지 걸리는 거리를 다익스트라로 구하여 해당 List에 넣어주고

// 각 마을에서 X까지 오는데 걸리는 최소 거리를 다익스트라로 구하여 List에 넣어줌

// 이럴바엔 그냥 다익스트라로 하는게 아니라 벨만포드로 하는게 낫지않나??

