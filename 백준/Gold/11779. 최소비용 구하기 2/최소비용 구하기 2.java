import java.util.*;

class NodeC implements Comparable<NodeC>{
    int idx;
    int distance;

    NodeC(int idx, int distance){
        this.idx = idx;
        this.distance = distance;
    }


    @Override
    public int compareTo(NodeC o) {
        return Integer.compare(this.distance, o.distance);
    }
}

public class Main {

    public static int n;
    public static int m;
    public static List<List<NodeC>> graph = new ArrayList<>();
    public static int[] dist;
    public static int INF = 987654321;
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[n + 1];
        parent = new int[n + 1];

        Arrays.fill(dist,INF);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new NodeC(v, w));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start);

        Stack<Integer> st = new Stack<>();
        int curr = end;
        while (curr != 0) {
            st.push(curr);
            curr = parent[curr];
        }


        System.out.println(dist[end]);
        System.out.println(st.size());
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<NodeC> pq = new PriorityQueue<>();
        pq.add(new NodeC(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            NodeC nowNode = pq.poll();
            int idx = nowNode.idx;
            int distance = nowNode.distance;
            if (dist[idx] < distance) {
                continue;
            }

            for (NodeC neighbor : graph.get(idx)) {
                if (dist[neighbor.idx] > dist[idx] + neighbor.distance) {
                    dist[neighbor.idx] = dist[idx] + neighbor.distance;
                    parent[neighbor.idx] = idx;
                    pq.add(new NodeC(neighbor.idx, dist[neighbor.idx]));
                }
            }
        }
    }
}
