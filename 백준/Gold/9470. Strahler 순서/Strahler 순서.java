import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt(); // 테스트 케이스 번호
            int M = sc.nextInt(); // 노드의 수
            int P = sc.nextInt(); // 간선의 수

            // 그래프 생성
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            ArrayList<ArrayList<Integer>> orderList = new ArrayList<>();

            int[] inDegree = new int[M + 1]; // 위상차수 생성

            // graph 초기화
            for (int i = 0; i <= M; i++) {
                graph.add(new ArrayList<>());
            }

            // orderList 초기화
            for (int i = 0; i <= M; i++) {
                orderList.add(new ArrayList<>());
            }

            for (int i = 1; i <= P; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                graph.get(u).add(v);
                inDegree[v]++;
            }



            Queue<Integer> q = new LinkedList<>();
            int[] Order = new int[M + 1];

            // in
            for (int i = 1; i <= M; i++) {
                if (inDegree[i] == 0) {
                    q.add(i);
                    Order[i] = 1;
                }
            }

            while (!q.isEmpty()) {
                int start = q.poll();
                int beforeOrder = Order[start];
                for (int c : graph.get(start)) {
                    inDegree[c]--;
                    orderList.get(c).add(beforeOrder); // 추가해야함
                    if (inDegree[c] == 0) {
                        // 나머지에 저장되어 있던 애들 중 최대 값 혹은, 최대가 많을 때 그 순서 +1 로 표현해야함
                        int o = findOrder(orderList.get(c));
                        Order[c] = o;
                        // 그걸 Order[c]에 적어야함
                        q.add(c);
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i <= M; i++) {
                if (answer < Order[i]) {
                    answer = Order[i];
                }
            }

            System.out.printf("%d %d\n",K,answer);
        }
    }

    public static int findOrder(ArrayList<Integer> tmp){
        int mx = 0;
        for (int c : tmp) {
            if (mx < c) {
                mx = c;
            }
        }

        int cnt = 0;
        for (int c : tmp) {
            if (mx == c) {
                cnt ++;
            }
        }

        if (cnt >= 2) { // mx값이 2 이상이면..
            return mx + 1;
        } else {
            return mx;
        }
    }
}

// 들어오는 모든 강 중에서 Strahler 순서가 i인 강이 1개이면 순서는 i, 2개 이상이면 순서는 i+1이다.
// 순서1 과 순서2 가 만나면 순서 2로 됨
// 순서1 과 순서2와 순서2 가 만나면 순서 2+1 -> 3으로 됨
// 순서2와 순서2가 만나면 순서3이 됨


// 들어오는 순서(i)가 기존에 갖고 있던 순서와 같다면 -> i+1로 저장
// 들어오는 순서(i)가 기존에 갖고 있던 순서와 다르다면 -> Math.max(기존,들어온거)