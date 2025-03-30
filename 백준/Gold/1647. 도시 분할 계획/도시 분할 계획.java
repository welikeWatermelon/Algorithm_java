import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    // 마을의 이장은 마을을 두 개의 분리된 마을로 분할할 계획을 가지고 있다
    // 각 분리된 마을 안에 있는 임의의 두 집 사이에 경로가 항상 존재해야 한다
    // 마을에는 집이 하나 이상 있어야 한다.
    // 일단 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있다.
    // 각 분리된 마을 안에서 임의의 두 집 사이에 경로가 항상 존재하게 하면서 길을 더 없앰
    // 길의 유지비의 합을 최소
    public static int[] parents;

    public static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int c;

        public Edge(int u, int v, int c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.c, other.c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();

            edges.add(new Edge(u, v, c));
        }
        Collections.sort(edges);

        setParent(N);

        int totalCost = 0;
        int maxEdgeCost = 0;

        for (Edge e : edges) {
            if (getParent(e.u) != getParent(e.v)) {
                union(e.u, e.v);
                totalCost += e.c;
                maxEdgeCost = Math.max(maxEdgeCost, e.c);
            }
        }
        System.out.println(totalCost - maxEdgeCost);

    }

    public static void setParent(int N) {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int getParent(int n) {
        if (parents[n] == n) {
            return n;
        }
        return parents[n] = getParent(parents[n]);
    }

    public static void union(int x, int y) {
        int root_x = getParent(x);
        int root_y = getParent(y);
        if (root_x < root_y) {
            parents[root_y] = root_x;
        } else {
            parents[root_x] = root_y;
        }
    }
}
