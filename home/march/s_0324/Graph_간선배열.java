package s_0324;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph_간선배열 {

    // 문제안에 클래스를 정의하는 경우가 많음
    static class Edge{
        int A,B,W ; // 시작, 끝, 가중치

        public Edge(int a, int b, int w) {
            A = a;
            B = b;
            W = w;
        }

        // 확인용 굳이 안넣어도 됨
        @Override
        public String toString() {
            return "Edge{" +
                    "A=" + A +
                    ", B=" + B +
                    ", W=" + W +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // V, E의 개수를 입력받는다.
        int V = sc.nextInt(); // 정점의 개수 (0번 시작인지, 1번 시작인지 확인)
        int E = sc.nextInt(); // 간선의 개수

        Edge[] edges = new Edge[E]; // 간선의 배열 ( 객체 배열 )



        for (int i = 0; i < E; i++) {
            int A = sc.nextInt(); // 연결된 두개의 정점의 정보
            int B = sc.nextInt();
            int W = sc.nextInt(); // 가중치 값 / 없다면 1 저장

            edges[i] = new Edge(A, B, W); // 유향 / 무향 은 인지 하고 있을 것
        }// 간선을 입력하겠음

        /// //////////////////////////////////////////////////////////////////////////
        List<Edge> edges2 = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            edges2.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        /// //////////////////////////////////////////////////////////////////////////


        /// /////////////////////////////////////////////////////////////////////////
        // 2차원 배열을 이용하여 저장하자 ! 간선의 정보가 전부 정수일 때
        int[][] edges3 = new int[E][3];
        for (int i = 0; i < E; i++) { // [0] : 시작정점, [1] : 끝정점, [2] : 가중치
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();
            edges3[i][0] = A;
            edges3[i][1] = B;
            edges3[i][2] = W;
        }
    }
}
