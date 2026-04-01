import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // X마을에서 각 집으로 가는 것 : 그래프 방향을 순방향으로, X에서 다익스트라 graphGoToHome
    // 각 집에서 X마을까지 가는 것 : 그래프 방향을 반대로 돌리고, X에서 다익스트라 graphGoToX
    public static class Node implements Comparable<Node>{
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

    public static ArrayList<Node>[] graphGoToHome;
    public static ArrayList<Node>[] graphGoToX;
    public static int[] distGoToHome;
    public static int[] distGoToX;
    public static int N,M,X;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graphGoToHome = new ArrayList[N + 1];
        graphGoToX = new ArrayList[N + 1];


        for (int i = 0; i <= N; i++) {
            graphGoToHome[i] = new ArrayList<>();
            graphGoToX[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graphGoToHome[start].add(new Node(end, cost));
            graphGoToX[end].add(new Node(start, cost));
        }

        distGoToHome = new int[N + 1];
        distGoToX = new int[N + 1];
        Arrays.fill(distGoToHome, INF);
        Arrays.fill(distGoToX, INF);

        distGoToHome[X] = 0;
        distGoToX[X] = 0;

        dijk(X, distGoToHome, graphGoToHome);
        dijk(X, distGoToX, graphGoToX);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(distGoToHome[i] + distGoToX[i], max);
        }

        System.out.println(max);

    }
    public static void dijk(int start, int[] dist, ArrayList<Node>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int idx = curNode.idx;
            int cost = curNode.cost;

            if (dist[idx] < cost) {
                continue;
            }

            for (Node nextNode : graph[idx]) {
                int nextIdx = nextNode.idx;
                int nextCost = nextNode.cost;
                if (dist[nextIdx] > cost + nextCost) {
                    dist[nextIdx] = cost + nextCost;
                    pq.add(new Node(nextIdx, cost+nextCost));
                }
            }
        }
    }
}
