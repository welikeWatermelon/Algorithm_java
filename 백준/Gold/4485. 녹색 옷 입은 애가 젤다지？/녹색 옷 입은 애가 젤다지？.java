import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = 0;
        while (true) {
            test ++;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                return;
            }
            int[][] map = new int[N][N];
            boolean[][] checked = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.printf("Problem %d: %d\n",test, bfs(0, 0, map, N, checked));

        }
    }

    public static int bfs(int startX, int startY, int[][] map, int N, boolean[][] checked) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, map[startX][startY]));

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int curX = nowNode.x;
            int curY = nowNode.y;
            int curCost = nowNode.cost;

            if (curX == N - 1 && curY == N - 1) {
                return curCost;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N ) continue;
                if(checked[nextX][nextY]) continue;

                pq.add(new Node(nextX, nextY, curCost + map[nextX][nextY]));
                checked[nextX][nextY] = true;
            }
        }

        return -1;
    }
}
