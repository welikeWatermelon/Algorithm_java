import java.util.*;

class Node implements Comparable<Node> {

    int now; // 컴퓨터
    int c; // 통신 시간
// 방향은 양방향

    public Node(int now, int c) {
        this.now = now;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return this.c - o.c;
    }
}

public class Main {
    public static int N, M;
    public static int[] dist,answer;
    public static ArrayList<ArrayList<Node>> arr;
    public static int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점의 수
        M = sc.nextInt(); // 주어진 간선의 수
        // 정답으로는 N-1개가 나와야함
        dist = new int[N + 1];
        Arrays.fill(dist,INF);

        dist[1] = 0;
        arr = new ArrayList<>(); // !!! 초기화 추가

        answer = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr.get(u).add(new Node(v, w));
            arr.get(v).add(new Node(u, w)); // **양방향** 연결
        }

        dikj();

        System.out.println(N-1);
        for (int i = 2; i <= N; i++) {
            if(dist[i]==INF) continue;
            System.out.printf("%d %d\n",i,answer[i]);
        }
    }

    public static void dikj() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int current = now.now;
            int currentDist = now.c;

            if (currentDist > dist[current]) {
                continue;
            }

            for (Node next : arr.get(current)) {
                int cost = dist[current] + next.c;
                if (cost < dist[next.now]) {
                    dist[next.now] = cost;
                    answer[next.now] = current;
                    pq.offer(new Node(next.now, cost));
                }
            }
        }
    }
}

// 1번 컴퓨터는 보안 시스템을 설치할 슈퍼컴퓨터
// 즉, 다익스트라임

// 최소 개수의 회선만을 복구해야 한다.

// 네트워크를 복구한 후에 서로 다른 두 컴퓨터 간에 통신이 가능하도록 복구해야 한다.
// 즉, 모두 연결되어있어야함

// 해커에게 공격을 받았을 때 보안 패킷을 전송하는 데 걸리는 시간도 중요한 문제
// 슈퍼컴퓨터가 다른 컴퓨터들과 통신하는데 걸리는 최소 시간이,
// 원래의 네트워크에서 통신하는데 걸리는 최소 시간보다 커져서는 안 된다

// 즉, 최소비용만 하여 노드들을 연결해야함
