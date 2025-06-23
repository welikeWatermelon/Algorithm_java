import java.util.*;

class Hack {
    int to; // 목적지 컴퓨터
    int time; // 걸리는 시간

    Hack(int to, int time) {
        this.to = to;
        this.time = time;
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt(); // 컴퓨터 개수
            int d = sc.nextInt(); // 의존성 개수
            int c = sc.nextInt(); // 처음 해킹당한 컴퓨터

            // 인접 리스트
            List<List<Hack>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                int a = sc.nextInt(); // a가 감염됨
                int b = sc.nextInt(); // b가 감염되어야만
                int s = sc.nextInt(); // b -> a 로 s초 걸림

                graph.get(b).add(new Hack(a, s)); // b가 감염되면 a가 감염됨
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[c] = 0;

            PriorityQueue<Hack> pq = new PriorityQueue<>(Comparator.comparingInt(h -> h.time));
            pq.add(new Hack(c, 0));

            while (!pq.isEmpty()) {
                Hack cur = pq.poll();
                int now = cur.to;
                int cost = cur.time;

                if (cost > dist[now]) continue;

                for (Hack next : graph.get(now)) {
                    if (dist[next.to] > dist[now] + next.time) {
                        dist[next.to] = dist[now] + next.time;
                        pq.add(new Hack(next.to, dist[next.to]));
                    }
                }
            }

            int cnt = 0;
            int maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    cnt++;
                    maxTime = Math.max(maxTime, dist[i]);
                }
            }

            System.out.printf("%d %d\n", cnt, maxTime);
        }
    }
}
