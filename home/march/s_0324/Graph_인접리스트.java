package s_0324;

import java.util.*;

import java.util.Scanner;

public class Graph_인접리스트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // V, E의 개수를 입력받는다.
        int V = sc.nextInt(); // 정점의 개수 (0번 시작인지, 1번 시작인지 확인)
        int E = sc.nextInt(); // 간선의 개수

        List<Integer>[] adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        } // 미리 리스트 객체를 전부 생성해 두어야 한다.


        for (int i = 0; i < E; i++) {
            int A = sc.nextInt(); // 연결된 두개의 정점의 정보
            int B = sc.nextInt();

            // 가중치를 같이 저장하고 싶다!
            // 1. class 이용 저장
            // 2. int[] 이용 저장
            adjList[A].add(B);
            adjList[B].add(A); // 무향이라면 필요 없음



        }// 간선을 입력하겠음

    }
}
