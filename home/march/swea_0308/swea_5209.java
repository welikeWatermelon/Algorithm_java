package swea_0308;

import java.util.Scanner;

public class swea_5209 {
    public static int[][] arr;
    public static int mn, N, cost,lastCost;
    public static boolean[] checked;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N][N];
            mn = Integer.MAX_VALUE;
            checked = new boolean[N];
            cost = 0;
            lastCost=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            work(0);
            System.out.printf("#%d %d\n",t,mn);
        }
    }

    public static void work(int depth){
        // min보다 큰 값이 나오면 컷해야함

        if(cost>mn) return;

        if (depth == N) {
            mn = Math.min(mn,cost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!checked[i]){ // i번째 열이(공장이) 제품을 선택 안했다면
                checked[i] = true;

                cost += arr[depth][i];
                work(depth + 1);
                cost -= arr[depth][i];
                checked[i] = false;
            }
       }
    }
}
