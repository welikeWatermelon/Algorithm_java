package swea_0220;

import java.util.Scanner;

public class swea_5176_2 {
    static int[] tree; // 완전 이진 트리를 배열로 표현
    static int index;  // 중위 순회 시 현재 인덱스

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            tree = new int[N + 1]; // 1-based 인덱스 트리
            index = 0;

            inorderFill(1, N); // 1번 노드부터 트리 채우기

            int rootValue = tree[1]; // 루트 노드 값
            int midValue = tree[N / 2]; // N/2 번째 노드 값

            System.out.println("#" + t + " " + rootValue + " " + midValue);
        }
        sc.close();
    }

    // 중위 순회하며 값 채우기 (오름차순 저장)
    static void inorderFill(int node, int N) {
        if (node > N) return; // 범위 초과 시 종료

        inorderFill(2 * node, N);  // 왼쪽 서브트리 방문
        tree[node] = ++index;       // 현재 노드에 값 저장
        inorderFill(2 * node + 1, N); // 오른쪽 서브트리 방문
    }
}