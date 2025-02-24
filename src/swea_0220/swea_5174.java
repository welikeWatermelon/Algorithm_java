package swea_0220;

import java.util.Scanner;

public class swea_5174 {
    static int[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int E = sc.nextInt(); //간선의 개수
            int N = sc.nextInt(); //루트 노드

            int[][] arr = new int[N+1][2];
            int max = 0;
            for (int i = 1; i <= E; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                max = Math.max(max, arr[i][0]);
            }

            int[][] Parr = new int[max][3];

        }
    }

}
