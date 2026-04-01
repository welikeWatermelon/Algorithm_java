import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int E;
    public static ArrayList<Node>[] graph;
    public static int INF = 200000000;

    public static class Node implements Comparable<Node>{
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        int[] distU = new int[N + 1];
        int[] distV = new int[N + 1];

        // 그래프 설정
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        Arrays.fill(distU, INF);
        Arrays.fill(distV, INF);

        distU[u] = 0;
        distV[v] = 0;

        dijk(u, distU);
        dijk(v, distV);

        int startU = distU[1];
        int startV = distV[1];

        int mid = distU[v];

        int endV = distV[N];
        int endU = distU[N];

        int min = Math.min(startU + mid + endV, startV + mid + endU);
        if (min >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
        // 최대 200,000,000 -> 모든 간선을 더해도 2억이니까 int 가능이지 또한 INF를 안넘잖아
    }

    public static void dijk(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curIdx = curNode.idx;
            int curDist = curNode.dist;

            if (dist[curIdx] < curDist) {
                continue;
            }

            for (Node nextNode : graph[curIdx]) {
                int nextIdx = nextNode.idx;
                int nextDist = nextNode.dist;
                if (dist[nextIdx] > curDist + nextDist) {
                    dist[nextIdx] = curDist + nextDist;
                    pq.add(new Node(nextIdx, curDist + nextDist));
                }

            }
        }
    }
}
