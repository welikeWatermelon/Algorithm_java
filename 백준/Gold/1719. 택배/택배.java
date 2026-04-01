import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] ans;
    public static ArrayList<Node>[] graph;
    public static int[] dist;
    public static int INF = 100000000;

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

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ans = new int[n+1][n+1];

        graph = new ArrayList[n + 1];


        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        for (int i = 1; i <= n; i++) {
            dist = new int[n + 1];
            Arrays.fill(dist,INF);
            dist[i] = 0;
            dijk(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) sb.append("- ");
                else sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);



    }

    public static void dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int curIdx = nowNode.idx;
            int curCost = nowNode.cost;

            if (dist[curIdx] < curCost) {
                continue;
            }

            for (Node nextNode : graph[curIdx]) {
                int nextIdx = nextNode.idx;
                int nextCost = nextNode.cost;

                if (dist[nextIdx] > nextCost + curCost) {
                    dist[nextIdx] = nextCost + curCost;
                    if (curIdx == start) {
                        ans[start][nextIdx] = nextIdx;
                    } else {
                        ans[start][nextIdx] = ans[start][curIdx];
                    }
                    pq.add(new Node(nextIdx, nextCost + curCost));
                }
            }
        }
    }
}
