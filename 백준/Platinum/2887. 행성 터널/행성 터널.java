import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //  터널을 총 N-1개 건설해서 모든 행성이 서로 연결되게 하려고 한다
    // -> MST를 만들겠다

    public static class Planet {
        int id; // 행성 번호
        int x, y, z;

        public Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static class Node implements Comparable<Node>{
        int start;
        int end;
        int dist;

        public Node(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }

    public static int[] parent;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        List<Planet> planets = new ArrayList<>();

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = i;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new Planet(id, x, y, z));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();


        planets.sort(Comparator.comparingInt(p -> p.x));
        for (int i = 0; i < N - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i+1);
            int dist = Math.abs(p1.x - p2.x);
            pq.add(new Node(p1.id, p2.id, dist));
        }

        planets.sort(Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < N - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i+1);
            int dist = Math.abs(p1.y - p2.y);
            pq.add(new Node(p1.id, p2.id, dist));
        }

        planets.sort(Comparator.comparingInt(p -> p.z));
        for (int i = 0; i < N - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i+1);
            int dist = Math.abs(p1.z - p2.z);
            pq.add(new Node(p1.id, p2.id, dist));
        }

        long totalDist = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (find(node.start) == find(node.end)) {
                continue;
            }

            union(node.start, node.end);
            totalDist += node.dist;
        }

        System.out.println(totalDist);
    }

    public static int find(int x){
        if(parent[x]==x) return x;
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
