import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 방향성이 없는 그래프가 주어진다.
    // 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다.
    // 조건 1. 최단 경로
    // 조건 2. 임의로 주어진 두 정점은 반드시 통과
    // 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다.
    // 하지만 반드시 최단 경로로 이동해야 한다


    // 아니면 v1 에서 다익스트라 하면 1번까지 가는거, v2까지 가는거 N까지 가는거 구함  (v1ToS, v1ToV2, v1ToE)
    // v2에서 다익스트라하면 1번까지 가는거, v2까지 가는거, N까지 가는거 구함 (v2ToS, v2ToV1, v2ToE)
    // 즉, v1과 v2에서 각각 다익스트라를 한번 씩 하면 됨


    public static int INF = Integer.MAX_VALUE;
    public static int[] v1Dist, v2Dist;
    public static int N;
    public static ArrayList<Node>[] graph;


    public static class Node implements Comparable<Node>{
        int idx,cost;

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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        v1Dist = new int[N + 1];
        v2Dist = new int[N + 1];

        Arrays.fill(v1Dist, INF);
        Arrays.fill(v2Dist, INF);

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i <E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dijk(v1, v1Dist);
        dijk(v2, v2Dist);

        int v1ToS = v1Dist[1];
        int v1ToV2 = v1Dist[v2];
        int v1ToE = v1Dist[N];

        int v2ToS = v2Dist[1];
        int v2ToE = v2Dist[N];

        if (v1ToS == INF || v1ToV2 == INF || v1ToE == INF || v2ToS == INF || v2ToE == INF) {
            System.out.println(-1);
            return;
        }

        int min = Math.min(v1ToS + v1ToV2 + v2ToE, v2ToS + v1ToV2 + v1ToE);
        System.out.println(min);

    }

    public static void dijk(int start, int[] dist) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curIdx = node.idx;
            int curCost = node.cost;

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
