import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static int N, M;
    public static List<Node>[] graph;
    static int[] dist;
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;  // INF로 초기화
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Node(v, w));
        }

        int start = sc.nextInt();
        int end =sc.nextInt();
        dijkstra(start);
        System.out.println(dist[end]);

        // 거리 출력
//        for (int i = 1; i <= N; i++) {
//            if (dist[i] == INF) {
//                System.out.println("INF");
//            } else {
//                System.out.println(dist[i]);
//            }
//        }
    }


    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0)); // 자기자신

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;

            if(cur.weight > dist[now]) continue;

            for (Node next : graph[now]) {
                if (dist[next.to] > dist[now] + next.weight) {
                    dist[next.to] = dist[now] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}
