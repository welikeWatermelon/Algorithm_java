import java.util.*;

public class Main {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int N;
    public static int M;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 각 인덱스 안에 리스트 생성
        }


        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);

        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            if (visited[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)){
                if (!visited[next]){
                    visited[next]=true;
                    queue.offer(next);
                }
            }
        }
    }
}
