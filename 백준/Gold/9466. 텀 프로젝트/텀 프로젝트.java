import java.util.Scanner;

public class Main {
    static int[] select;
    static int[] visited; // 0: 방문 전, 1: 방문 중, 2: 방문 완료
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            int N = sc.nextInt();
            select = new int[N + 1];
            visited = new int[N + 1];
            cnt = 0;

            for (int i = 1; i <= N; i++) {
                select[i] = sc.nextInt();
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }

            System.out.println(N - cnt); // 팀에 못 들어간 사람 수 출력
        }
        sc.close(); // 스캐너 닫기
    }

    static void dfs(int cur) {
        visited[cur] = 1; // 방문 중
        int next = select[cur];

        if (visited[next] == 0) {
            dfs(next);
        } else if (visited[next] == 1) {
            // 사이클 발생! 사이클 길이 세기
            cnt++;
            for (int i = next; i != cur; i = select[i]) {
                cnt++;
            }
        }

        visited[cur] = 2; // 방문 완료
    }
}
