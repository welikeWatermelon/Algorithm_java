import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    // 1. 두 점을 정한다
    // 2. 연결한다.
    // 가장 길게 연결하려면 중간 노드가 아니라 끝 노드들끼리 연결되어야함
    // 따라서 위의 방법은 비효율적

    // 1. 끝 노드들만 찾는 것
    // 2. 해당 노드끼리 가장 가까운 거리 찾는 것 - BFS
    
    // 임의의 점에서 dfs를 돌려 가장 멀리있는게 지름 끝 점중 하나
    // 해당 끝 점에서 dfs를 돌리면 다른 한점이 나옴 + 거리

    public static boolean[] visited;
    public static ArrayList<ArrayList<Node>> graph;
    public static int N;
    public static int maxDist = Integer.MIN_VALUE;
    public static int farthestNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N+1];

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        dfs(1, 0);

        visited = new boolean[N + 1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);


    }

    public static void dfs(int current, int dist){

        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = current;
        }

        visited[current] = true;

        for (int i = 0; i < graph.get(current).size(); i++) {
            Node nextNode = graph.get(current).get(i);
            int next = nextNode.next;
            int nextDist = nextNode.weight;
            if (!visited[next]) {
                dfs(next, nextDist + dist);
            }
        }

    }
}
