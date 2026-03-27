import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int INF = Integer.MAX_VALUE;
    public static ArrayList<Node>[] graph;
    public static int[] dist;

    public static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        // graph 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dijk(A);

        System.out.println(dist[B]);
    }

    public static void dijk(int start) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int curIdx = nowNode.idx;
            int curCost = nowNode.cost;

            if (dist[curIdx] < curCost) {
                continue;
            }

            for (Node next : graph[curIdx]) {
                int nextIdx = next.idx;
                int nextCost = next.cost;

                int newCost = curCost + nextCost;

                if (dist[nextIdx] > newCost) {
                    dist[nextIdx] = newCost;
                    pq.add(new Node(nextIdx, newCost));
                }
            }
        }
    }
}
