import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }

    }

    public static ArrayList<Node>[] graph;
    public static int V;
    public static int E;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, cost));
        }

        int totalCost = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // 부모가 같다면 (연결되어있으니) 패스
            if(find(node.start) == find(node.end)) continue;

            //아니라면
            union(node.start, node.end);
            totalCost += node.cost;
        }

        System.out.println(totalCost);
    }


    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[x] = y;
        }
    }
}
