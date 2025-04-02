import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt(); // 건물의 개수
            int K = sc.nextInt(); // 건물간의 건설 순서 규칙의 총 게수


            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            int[] D = new int[N + 1]; // 건물 당 걸리는 시간 1부터 ~ N까지
            int[] inDegree = new int[N + 1]; // 위상차수 배열
            int[] minTime = new int[N + 1]; // 건물 짓는데 최소 시간 배열

            for (int i = 1; i <= N; i++) {
                D[i]= sc.nextInt(); // 건물 당 걸리는 시간 1~N
            }

            for (int i = 1; i <= K; i++) {
                int before = sc.nextInt();
                int after = sc.nextInt();
                graph.get(before).add(after); // 그래프 등록 before -> after
                inDegree[after]++; // 위상차수 증가
            }

            int W = sc.nextInt(); //이거 완료하는데 최소 얼마나 걸림?
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    minTime[i] = D[i];
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int start = q.poll(); //
//                minTime[start] += D[start]; // 건물 하나만 지을 때 걸리는 시간을 더해줘 (start 건물)
                for (int c : graph.get(start)) {
                    inDegree[c]--;
                    minTime[c] = Math.max(minTime[start], minTime[c]);
                    if (inDegree[c] == 0) {
                        minTime[c] += D[c]; // 자기 시간 추가
                        q.add(c);
                    }
                }
            }


            System.out.println(minTime[W]);
        }
    }
}

//건물 W를 건설완료 하는데 드는 최소 시간을 출력한다
