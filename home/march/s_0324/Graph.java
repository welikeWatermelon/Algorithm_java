package s_0324;

import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // V, E의 개수를 입력받는다.
        int V = sc.nextInt(); // 정점의 개수 (0번 시작인지, 1번 시작인지 확인)
        int E = sc.nextInt(); // 간선의 개수

        int[][] adjArr = new int[V][V]; // 만약 시작정점이 1이라면 V+1로 만들기 (이때는 0번 인덱스는 버리는것임)

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt(); // 연결된 두개의 정점의 정보
            int B = sc.nextInt();
            int W = sc.nextInt(); // 가중치 값 / 없다면 1을 저장하기

            adjArr[A][B] = 1; // 가중치가 없다면 1을 있다면 W 저장
            adjArr[B][A] = 1; // 유향이라면 해당 코드는 작성하면 안된다.

//            adjArr[A][B] = adjArr[B][A] = W; // 이렇게 작성도 가능

            // 유향 / 가중치 / 변수에 저장도 싫어 (비권장) -> 그래프 마스터하면 한번은 써보자
//            adjArr[sc.nextInt()][sc.nextInt()] = sc.nextInt();

        }// 간선을 입력하겠음

    }
}
