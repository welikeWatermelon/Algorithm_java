import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 파티 가는데 구함 (자신의 마을 -> X 마을)
// 각 마을마다 다익스트라를 구해서 파티마을까지 가는데 최소 거리를 각각 넣는다 int[] goParty에다가 넣는다 ->
// 각 마을마다 하는건 시간 에바 아님? 이건 플롣이드워셜 써야하는거 아님?
//
// 근데 N번 다익스트라를 해도 되거든? 근데 역방향 다익스트라 라는게 있다?
// 순방향 그래프를 반대로 생각해서 한점에 모이는 경우를 반대로 한점에서 시작하는 경우로 생각하는거야
// 즉, partyVillage 에서 각 N의 마을로 가는 최소 경우를 구하는거지

// 2. 파티에서 오는데 구함 (X마을 -> 자신의 마을)
// 파티마을에서 각 집까지 오는 다익스트라를 구한다 int[] goHome에다가 넣는다 -> 이건 다익스트라 한번이면 완성됨
// 3. goHome과 goParty를 각각 더한다
// 4. 가장 큰 값 출력
public class Main {
    public static class Node implements Comparable<Node>{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static int N,M,X;
    public static int INF = Integer.MAX_VALUE;
    public static List<Node>[] graph;
    public static List<Node>[] againstGraph;
    public static int[] dist, againstDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        againstDist = new int[N + 1];
        graph = new ArrayList[N+1];
        againstGraph = new ArrayList[N+1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            againstGraph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF);
        Arrays.fill(againstDist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            againstGraph[v].add(new Node(u, w));
        }

        dijk(X, dist, graph);
        dijk(X, againstDist, againstGraph);

        int max = 0;
        for (int i = 0; i <= N; i++) {
            int sumDist = dist[i] + againstDist[i];
            if (max < sumDist) {
                max = sumDist;
            }
        }

        System.out.println(max);
    }

    public static void dijk(int start, int[] dist, List<Node>[] graph) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curIdx = curNode.idx;
            int curCost = curNode.cost;

            if (dist[curIdx] < curCost) {
                continue;
            }

            for (Node node : graph[curIdx]) {
                int nextIdx = node.idx;
                int nextCost = node.cost;

                int newCost = curCost + nextCost;

                if (dist[nextIdx] > newCost) {
                    dist[nextIdx] = newCost;
                    pq.add(new Node(nextIdx, newCost));
                }
            }
        }
    }
}
