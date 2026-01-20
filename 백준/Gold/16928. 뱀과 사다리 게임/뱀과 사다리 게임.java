import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[] dice = {1, 2, 3, 4, 5, 6};
    public static boolean[] checked = new boolean[101];
    public static int[] Ladder = new int[101];
    public static int[] Snake = new int[101];
    public static int[] dist = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Ladder[start] = end;
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Snake[start] = end;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        checked[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == 100) {
                System.out.println(dist[100]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if(next>100) continue;

                if(Ladder[next]!=0 ) next = Ladder[next];
                else if (Snake[next] != 0) next = Snake[next];

                if (!checked[next]) {
                    checked[next] = true;
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }


    }


    // 최솟값은 bfs로 풀어야함
    public static int dfs(int start, int cnt){
        // 조건에 만족했을 때 어떻게 빠져나오지?
        // 빠져나오는건 알겠는데 어떻게 최솟값을 보장하지?
        if (start == 100) {
            return cnt;
        }

        // 사다리였을 때
        if (Ladder[start] != 0) {
            return dfs(Ladder[start], cnt);
        }

        // 뱀이였을 때
        if (Snake[start] != 0) {
            return dfs(Snake[start], cnt);
        }

        for (int i = 0; i < 6; i++) {
            int next = start + dice[i];
            if (!checked[next]) {
                checked[next] = true;
                return dfs(next, cnt++);
            }
        }

        return 0;
    }
}
