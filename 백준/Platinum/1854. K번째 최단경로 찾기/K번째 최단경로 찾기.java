import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

// 항상 최단경로로만 이동하는 것은 별로 좋아하지 않는다.
// 하지만 너무 시간이 오래 걸리는 경로도 그리 매력적인 것만은 아니어서
// 적당한 타협안인 k번째 최단경로'를 구하길 원한다.  ( 1<=k<=100 )
// 1<=N<=1,000  0 <= m < 250,000, mk<=3,000,000

// 시작은 1번 도시 ( 두 도로의 시작점과 도착점이 모두 같은 경우는 없음 )

public class Main {

    public static int INF = Integer.MAX_VALUE;
    public static int n,k;
    public static PriorityQueue<Integer>[] dist;
    public static List<Node>[] graph;

    public static class Node implements Comparable<Node>{
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 도시 개수
        int m = Integer.parseInt(st.nextToken()); // 도시간에 존재하는 도로 수
        k = Integer.parseInt(st.nextToken()); // k번째 최단 경로

        graph = new ArrayList[n + 1];
        dist = new PriorityQueue[n+1];

        for (int i = 0; i <= n; i++) {
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }




        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }


        dijk(1);

        for (int i = 1; i <= n; i++) {
            System.out.println(dist[i].size() == k ? dist[i].peek() : -1);
        }


        // <출력>
        // n개의 줄을 출력한다. i번째 줄에 1->i 로 가는 k 번쨰 최단 경로의 소요시간
        // i -> i 도시로 가는 최단경로는 0이지만, k번째 최단경로는 0이 아닐 수 있음
        // k번째 최단 경로가 존재하지 않으면 -1 을 출력
        // 최단경로에 같은 정점이 여러 번 포함되어도 됨

        // 1번째 최단경로는 구할 수 있음
        // 근데 2번째는 어떻게 구하지? ->
    }

    public static void dijk(int start) {
        dist[start].add(0);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curIdx = curNode.idx;
            int curTime = curNode.time;

            if (dist[curIdx].size() == k && dist[curIdx].peek() < curTime) {
                continue;
            }

            for (Node next : graph[curIdx]) {
                int nextIdx = next.idx;
                int nextTime = next.time;

                int newTime = curTime + nextTime;
                if (dist[nextIdx].size() < k || dist[nextIdx].peek() > newTime) {
                    if (dist[nextIdx].size() == k) {
                        dist[nextIdx].poll();
                    }
                    dist[nextIdx].add(newTime);
                    pq.add(new Node(nextIdx, newTime));
                }
            }
        }
    }


}
