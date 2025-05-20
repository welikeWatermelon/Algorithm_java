import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;   // 인접 리스트
    static int[] parent;                 // 부모를 저장할 배열
    static boolean[] visited;           // 방문 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력받기
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        bfs(1); // 루트 노드부터 BFS 시작!!!

        // 2번 노드부터 N번 노드까지의 부모 출력!!!
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;
                    q.add(next);
                }
            }
        }
    }
}
