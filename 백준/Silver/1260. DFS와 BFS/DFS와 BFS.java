import java.util.*;

public class Main {
    public static int N, M, V;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visitedDFS;
    public static boolean[] visitedBFS;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();  // 정점의 개수
        M = sc.nextInt();  // 간선의 개수
        V = sc.nextInt();  // 시작 정점

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 각 정점의 인접 리스트 정렬 (작은 번호 우선 방문)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 탐색
        visitedDFS = new boolean[N + 1];
        DFS(V);
        System.out.println();  // DFS 출력 후 줄바꿈

        // BFS 탐색
        visitedBFS = new boolean[N + 1];
        BFS(V);
    }

    // DFS 구현 (재귀)
    public static void DFS(int v) {
        visitedDFS[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < graph.get(v).size(); i++) {
            int next = graph.get(v).get(i);
            if (!visitedDFS[next]) {
                DFS(next);
            }
        }
    }

    // BFS 구현 (큐 사용)
    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visitedBFS[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < graph.get(node).size(); i++) {
                int next = graph.get(node).get(i);
                if (!visitedBFS[next]) {
                    visitedBFS[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
