import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] colors;
    static boolean isBipartite;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {

            isBipartite = true;
            int V = sc.nextInt();
            int E = sc.nextInt();

            graph = new ArrayList[V + 1];
            colors = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph[a].add(b);
                graph[b].add(a);
            }

            for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) {
                    dfs(i, 1);
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    public static void dfs(int node, int color) {
        colors[node] = color;

        for (int neighbor : graph[node]) {
            if (colors[neighbor] == 0) {
                dfs(neighbor, -color);
            } else if (colors[neighbor] == color) {
                isBipartite = false;
                return;
            }
        }
    }
}