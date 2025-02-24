package swea_IM_problems;

import java.util.Scanner;

public class swea_IM_1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] nArr = new int[N];
            int[] mArr = new int[M];

            for (int i = 0; i < N; i++) {
                nArr[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                mArr[i] = sc.nextInt();
            }

            System.out.printf("#%d %d\n",t,solution(nArr,mArr,N,M));
        }
    }

    public static int solution(int[] nArr, int[] mArr, int N, int M) {
        int max = Integer.MIN_VALUE;

        if (N > M) {
            for (int i = 0; i <= Math.abs(N - M); i++) {
                int gopsem = 0;
                for (int j = 0; j < M; j++) {
                    gopsem += nArr[i+j]*mArr[j];
                }
                max = Math.max(max, gopsem);
            }
        }else {
            for (int i = 0; i <= Math.abs(N - M); i++) {
                int gopsem = 0;
                for (int j = 0; j < N; j++) {
                    gopsem += nArr[j]*mArr[i+j];
                }
                max = Math.max(max, gopsem);
            }
        }
        return max;
    }
}
