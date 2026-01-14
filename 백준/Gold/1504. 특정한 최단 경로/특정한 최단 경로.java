import java.util.*;

class NodeB implements Comparable<NodeB> {
    int idx;
    int dist;

    NodeB(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(NodeB other) {
        return Integer.compare(this.dist, other.dist);
    }
}

public class Main {
    public static int N;
    public static int E;
    public static List<List<NodeB>> graph = new ArrayList<>();
    public static int INF = 100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();


        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();

            graph.get(u).add(new NodeB(v, c));
            graph.get(v).add(new NodeB(u, c));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int[] dist1 = dijkstra(1);
        int[] dist2 = dijkstra(v1);
        int[] dist3 = dijkstra(v2);

        long answer1 = dist1[v1] + dist2[v2] + dist3[N];
        long answer2 = dist1[v2] + dist3[v1] + dist2[N];

        long finalResult = Long.min(answer1, answer2);

        if (finalResult >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(finalResult);
        }

    }


    public static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<NodeB> pq = new PriorityQueue<>();
        pq.add(new NodeB(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            NodeB nowNode = pq.poll();

            if (dist[nowNode.idx] < nowNode.dist) {
                continue;
            }

            for (NodeB neighbor : graph.get(nowNode.idx)) {
                if (dist[neighbor.idx] > dist[nowNode.idx] + neighbor.dist) {
                    dist[neighbor.idx] = dist[nowNode.idx] + neighbor.dist;
                    pq.add(new NodeB(neighbor.idx, dist[neighbor.idx]));
                }
            }
        }

        return dist;
    }
}
