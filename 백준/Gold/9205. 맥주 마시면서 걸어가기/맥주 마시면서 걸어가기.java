import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static int n; // 편의점 수
    static Point[] points; // 0: 집, 1~n: 편의점, n+1: 도착지
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트케이스 개수

        while (t-- > 0) {
            n = sc.nextInt();
            points = new Point[n + 2]; // 집 + 편의점 n개 + 도착지
            visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points[i] = new Point(x, y);
            }

            // BFS 실행
            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // 시작점(집)
        visited[0] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            // 도착지에 도달한 경우
            if (now == n + 1) return true;

            for (int i = 0; i < n + 2; i++) {
                if (!visited[i] && canGo(points[now], points[i])) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return false;
    }

    static boolean canGo(Point a, Point b) {
        int dist = Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
        return dist <= 1000; // 맥주로 이동 가능한 거리
    }
}
