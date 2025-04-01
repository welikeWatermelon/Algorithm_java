import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // graph 입력
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] buildTime = new int[N + 1]; // 건물 짓는 시간 리스트
        int[] inDegree = new int[N + 1]; // 위상차수

        int[][] buildInform = new int[N + 1][3];
        // [ buildTime, inDegree ]


        for (int i = 1; i <= N; i++) {
            String[] tmp = sc.nextLine().split(" "); // 입력 받아
            buildTime[i] = Integer.parseInt(tmp[0]); // 걸리는 시간 넣어

            // 선행 건물이 여러개일 수 있어서 이렇게 해줘야함
            for (int j = 1; j < tmp.length - 1; j++) {
                int pre = Integer.parseInt(tmp[j]); // 걸리는 시간과 -1 제외하고 나머지 입력 받을 준비
                graph.get(pre).add(i); // 그래프를 선행 참고해서 넣어줌
                inDegree[i]++; // 해당 위상차수 +1
            }
        }


        // buildInform 만들어주기
        for (int i = 0; i < N + 1; i++) {
            buildInform[i][0] = buildTime[i];
            buildInform[i][1] = inDegree[i];
            buildInform[i][2] = i;
        }


        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];

        // result에는 걸리는 시간을 넣어두되, inDegree가 0인 것들은 q에 인덱스를 넣어줘
        for (int i = 1; i <= N; i++) {
            result[i] = buildTime[i];
            if (inDegree[i] == 0) q.offer(i);
        }


        while (!q.isEmpty()) {
            int now = q.poll(); // inDegree가 0인 점
            for (int next : graph.get(now)) { // now가 선행인 간선들을 뽑아줌
                // 아래 코드는 최대 치로 갱신해 주는 것
                // 이유로는
                // 1(1) -> 2(2) -> 3(3) : 6
                // 4(10) -> 3(3) : 14 중 최댓값을 내기 위해서
                result[next] = Math.max(result[next], result[now] + buildTime[next]);
                inDegree[next]--;
                if (inDegree[next] == 0) q.offer(next);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}
// 여러 개의 건물을 동시에 지을 수 있다.
// 건물 건설중일 때, 다른 건물 지어야함
// 각 건물을 짓는데 걸리는 시간 / 그 건물을 짓기 위한 선행건물 번호