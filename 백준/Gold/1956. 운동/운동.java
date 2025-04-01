import java.util.Scanner;

public class Main {
    public static final int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] graph = new int[V+1][V+1];
        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int to = sc.nextInt();
            graph[start][to] = sc.nextInt();
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = INF;
                }
            }
        }

//        for (int i = 0; i <= V; i++) {
//            graph[i][i] = 0;
//        }


        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (graph[i][k] != 0 && graph[k][j] != 0) {
                        graph[i][j] = Math.min(graph[i][k] + graph[k][j],graph[i][j]);
                    }
                }
            }
        }



        int mn = INF;
        for (int i = 1; i <= V; i++) {
            if (graph[i][i] < mn) {
                mn = graph[i][i];
            }
        }


        if (mn == INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(mn);

    }

    // 사이클 중 최소 비용을 찾는 문제
    // 두 노드가 서로 가리키는 경우도 순환으로 간주
}
