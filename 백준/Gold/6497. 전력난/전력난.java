import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static int[] parent;
    public static class Edge{
        int u;
        int v;
        int c;

        public Edge(int u, int v, int c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }
    }

    public static boolean[] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if (N == 0 && M == 0) {
                break;
            }
            checked = new boolean[N];
            setParent(N);
            ArrayList<Edge> edges = new ArrayList<>();
            long totalPrice = 0;
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int c = sc.nextInt();
                totalPrice += c;
                edges.add(new Edge(u, v, c));
            }

            edges.sort(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return Integer.compare(o1.c, o2.c);
                }
            });

            long total = 0;
            int cnt = 0;

            for (Edge e : edges) {
                if (findParent(e.u) != findParent(e.v)) {
                    union(e.u, e.v);
                    total += e.c;
                    cnt++;
                }

                if (cnt == N - 1) {
                    break;
                }
            }

            System.out.println(totalPrice-total);

        }
    }


    public static void setParent(int N) {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    public static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int x, int y) {
        int root_x = findParent(x);
        int root_y = findParent(y);
        if (root_x < root_y) {
            parent[root_y] = root_x;
        } else {
            parent[root_x] = root_y;
        }
    }
}
