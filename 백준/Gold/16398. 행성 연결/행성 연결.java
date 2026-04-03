import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    public static ArrayList<Node>[] graph;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i == j) {
                    continue;
                }
                graph[i].add(new Node(j, cost));
            }
        }


        long totalCost = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.idx]) continue; // PQ에는 동일한 노드가 서로 다른 가중치로 여러 번 들어갈 수 있음.
            // 가장 짧은 것이 먼저 나와서 방문 처리가 되었음에도, 나중에 나오는 더 긴 간선이 중복 계산되는 것을 막아야함

            int curIdx = cur.idx;
            int curCost = cur.cost;
            visited[curIdx] = true;
            totalCost += curCost;

            for (Node next : graph[curIdx]) {
                if(visited[next.idx]) continue;

                pq.add(new Node(next.idx, next.cost));
            }

        }

        System.out.println(totalCost);


    }
}
