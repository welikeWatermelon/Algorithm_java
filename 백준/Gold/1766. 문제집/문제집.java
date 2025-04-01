import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        // graph 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 순서 저장
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int to = sc.nextInt();
            graph.get(start).add(to);
            inDegree[to]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        // 0인 경우 큐에 넣어주기
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
            for (int c : graph.get(u)) {
                inDegree[c]--;
                if (inDegree[c] == 0) {
                    q.add(c);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result.get(i)+" ");
        }


    }
}
