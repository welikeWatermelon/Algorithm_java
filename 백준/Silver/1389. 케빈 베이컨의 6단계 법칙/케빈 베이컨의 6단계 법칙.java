import java.util.*;

public class Main {
    public static int N,M;
    public static boolean[] checked;
    public static List<Integer>[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 유저의 수
        M = sc.nextInt(); // 친구 관계 수
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from].add(to);
            graph[to].add(from);
        }

        int mn = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            checked = new boolean[N + 1];
            if (mn > BFS(i)) {
                mn = BFS(i);
                idx = i;
            }
        }

        System.out.println(idx);


    }

    public static int BFS(int x){
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[] checked = new boolean[N + 1];
        q.add(new int[]{x, 0});
        checked[x] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int start = tmp[0];
            int cnt = tmp[1];
            answer += cnt;

            for (int t : graph[start]) {
                if (!checked[t]) {
                    checked[t] = true;
                    q.add(new int[]{t, cnt + 1});
                }
            }
        }
        return answer;
    }
}
