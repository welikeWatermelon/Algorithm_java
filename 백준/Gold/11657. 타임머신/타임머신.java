import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.
    // 다익스트라임
    // 근데 C<0 으로봐서 음수간선이 있음
    // 음수 순환도 발생할 수 있다.
    // 그래서 벨반포드로 가야한다.
    // 벨만포드는 모든 경우를 다 보는 것이다.
    // 우선 간선리스트로 진행한다.
    // from cost to 로 나타내고,
    // dist[]는 시작 점에서 거리를 나타냄
    // dist[from] 이 INF면 cost to는 볼 필요도 없음. 해당 거리를 못지나갈거니까
    // 그게 아니라면 업데이트 시켜줘야지

    public static class Edge{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static int INF = 200000000;
    public static int N,M;
    public static long[] dist;
    public static ArrayList<Edge> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N + 1];
        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Edge edge = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(edge);
        }

        Arrays.fill(dist, INF);
        boolean flag = belman(1);

        if (flag) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    public static boolean belman(int start) {
        dist[start] = 0;
        for (int i = 1; i <= N; i++) {
            for (Edge edge : list) {
                if (dist[edge.from] == INF) continue;

                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;

                    if(i==N) return true;
                }
            }
        }
        return false;
    }
}
