import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
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

    static List<Node>[] graph;
    static int INF = 987654321;
    static int[] dist;
    static int[] distP1;
    static int[] distP2;
    static int V;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();

        // 그래프 초기화 생성
        graph = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        dist = new int[V + 1];
        distP1 = new int[V + 1];
        distP2 = new int[V + 1];


        // 그래프 설정
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));

        }

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        int[] from1 = dijkstra(1);     // 1에서 출발한 거리 배열
        int[] fromP1 = dijkstra(p1);   // p1에서 출발한 거리 배열
        int[] fromP2 = dijkstra(p2);   // p2에서 출발한 거리 배열


        int d1 = from1[p1];
        int d2 = from1[p2];
        int p1p2 = fromP1[p2];
        int p1N = fromP1[V];
        int p2p1 = fromP2[p1];
        int p2N = fromP2[V];

        int total1 = d1 + p1p2 + p2N;
        int total2 = d2 + p2p1 + p1N;

        if (d1 >= INF || p1p2 >= INF || p2N >= INF) total1 = INF;
        if (d2 >= INF || p2p1 >= INF || p1N >= INF) total2 = INF;

        int answer = Math.min(total1, total2);
        System.out.println(answer >= INF ? -1 : answer);
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;

            if (cur.weight > dist[now]) continue;

            for (Node next : graph[now]) {
                if (dist[next.to] > dist[now] + next.weight) {
                    dist[next.to] = dist[now] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist; // 이게 핵심! 거리 배열을 리턴!
    }

}

// 1번 정점에서 N번 정점으로 최단 거리로 이동해야함
// 주어진 임의의 2개의 정점(p1, p2)을 통과해야함

// 총 두가지 경우의 수를 구해야함

// <1>
// p1 까지 가는 거리
// p1에서 다시 다익스트라
// p1 -> p2
// p2에서 N까지 가는 다익스트라

// <2>
// p2 까지 가는 거리
// p2에서 다시 다익스트라
// p2 -> p1
// p1에서 N까지 가는 다익스트라

// <1>과 <2>의 거리를 비교하여 최솟값으로 해야함


// 1. 1에서의 다익스트라를 구함
// 2. p1까지의 거리 d1, p2까지의 거리 d2 를 각각 구함
// 3. p1에서의 다익스트라를 구한 뒤, p2까지의 거리를 구함 (p1p2)
// 4. p2에서 다익스트라를 구한 뒤, N까지의 거리를 구함  (p2N)
// 5. p2에서의 다익스트라를 구한 뒤, p1까지의 거리를 구함 (p2p1)
// 6. p1에서 다익스트라를 구한 뒤, N까지의 거리를 구함 (p1N)

// Math.min(d1+p1p2+p2N,d2+p2p1+p1N) 하면됨