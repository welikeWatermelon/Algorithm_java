package swea_IM_problems;

import java.util.Scanner;

public class swea_IM_4613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            // 첫째줄 무조건 W
            // 마지막줄 무조건 R
            // 중간에 최소한 한줄 이상 B
            char[][] arr = new char[N][M];

            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }


            // 2번째줄부터 ~ 마지막-1 번째 줄까지 탐색
            // B를 K번째 줄로 지정하고, 2~K 까지 W,B 중에 적은 횟수로
            // K+1 ~ N까지 R,B 중에 적은 횟수로
            // K는 B로 시작할 처음 위치

            // 0~K 까지 흰색
            // K~@@ 까지 블루
            // @@~M 까지 레드
            int min = Integer.MAX_VALUE;
            int last = N-2;
            for (int K = 1; K <= N-1; K++) {
                int cnt = 0;
                //White
                for (int i = 0; i < K; i++) {
                    for(int j=0; j<M; j++){
                        if(arr[i][j]!='W') cnt++;
                    }
                }



                while(last>=K){
                    //Blue
                    int tmpCnt  = 0;
                    for (int i = K; i <= last; i++) {
                        for(int j=0; j<M; j++){
                            if(arr[i][j]!='B'){
                                tmpCnt++;
                            }
                        }
                    }

                    //Red
                    for (int i = last+1; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (arr[i][j] != 'R') {
                                tmpCnt++;
                            }
                        }
                    }
                    last--;
                    min = Math.min(min, cnt+tmpCnt);

                }
            }
            System.out.printf("#%d %d",t,min);
        }
    }
}
