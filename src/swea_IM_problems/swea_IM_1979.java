package swea_IM_problems;

import java.util.Scanner;

public class swea_IM_1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Test = sc.nextInt();
        for (int t = 1; t <= Test; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            // k가 들어가기 위해서는 k개의 칸이 있어야하고, 그 다음에 0이 오거나, 길이에 끝나야한다.
            // 0을 만나면 그다음 1이 될때 다시 카운트 해야한다
            // cnt==K이고, 그 다음의 숫자가 0혹은 idx가 끝에 걸쳐야한다. ex. K=3 , 0 0 1 1 1
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                int cntCK = 0;
                int cntRK = 0;
                for (int j = 0; j < N; j++) {
                    //행 검사
                    if (arr[i][j] == 1) {
                        cntCK++;
                    }
                    if (arr[i][j] == 0) {
                        cntCK=0;
                    }

                    if (cntCK == K) {
                        //idx가 끝에 걸치는 경우
                        if (j == N - 1) {
                            cnt++;
                        }
                        //그 다음의 숫자가 0
                        else if (j + 1 < N && arr[i][j + 1] == 0) {
                            cnt++;
                        }
                    }

                    //열 검사
                    if (arr[j][i] == 1) {
                        cntRK++;
                    }
                    if (arr[j][i] == 0) {
                        cntRK=0;
                    }

                    if (cntRK == K) {
                        //idx가 끝에 걸치는 경우
                        if (j == N - 1) {
                            cnt++;
                        }
                        //그 다음의 숫자가 0
                        else if (j + 1 < N && arr[j + 1][i] == 0) {
                            cnt++;
                        }
                    }

                }
            }
            System.out.printf("#%d %d\n", t, cnt);
        }
    }
}
