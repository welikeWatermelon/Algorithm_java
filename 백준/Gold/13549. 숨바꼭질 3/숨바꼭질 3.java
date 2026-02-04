import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static int k;

    public static class place implements Comparable<place>{
        int x;
        int cnt;

        public place(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }


        @Override
        public int compareTo(place o) {
            return cnt - o.cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        int cnt = 0;

        bfs(n,0);
    }

    public static void bfs(int n, int cnt){
        PriorityQueue<place> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[100001];
        pq.add(new place(n, 0));
        while (true) {
            place nowPlace = pq.poll();
            int nowX = nowPlace.x;
            int nowCnt = nowPlace.cnt;

            if (nowX < 0 || nowX > 100000 || visited[nowX]) continue;
            visited[nowX] = true;

            if (nowX == k) {
                System.out.println(nowCnt);
                return;
            }

            if (nowX * 2 <= 100000 && !visited[nowX * 2]) {
                pq.add(new place(nowX * 2, nowCnt));
            }
            if (nowX + 1 <= 100000 && !visited[nowX + 1]) {
                pq.add(new place(nowX + 1, nowCnt + 1));
            }
            if (nowX - 1 >= 0 && !visited[nowX - 1]) {
                pq.add(new place(nowX - 1, nowCnt + 1));
            }

        }
    }
}
