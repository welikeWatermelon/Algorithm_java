package swea_0219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class swea_5110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); //수열의 길이
            int M = sc.nextInt(); //수열의 개수
            int[][] arrs = new int[M][N];

            //배열 입력
            for (int i = 0; i < M; i++) {
                int[] arr = new int[N];
                for (int j = 0; j < N; j++) {
                    arr[j] = sc.nextInt();
                }
                arrs[i] = arr;
            }
            List<Integer> firstArr = Arrays.stream(arrs[0])
                    .boxed()
                    .collect(Collectors.toList());

            for (int i = 1; i < M - 1; i++) {
                int[] secondArr = arrs[i];

                boolean flag = true;
                int idx=-1;
                for (int j = 0; j < N; j++) {
                    //보다 큰 수를 찾으면 처리하는 코드
                    if (firstArr.get(j) > secondArr[0]) {
                        idx = j;
                        for (int k = 0; k < N; k++) {
                            firstArr.add(j + k, secondArr[k]);
                        }
                        break;
                    }
                }
                //보다 큰 수를 찾지 못하였을 때 처리하는 코드
                if (idx==-1) {
                    //그냥 붙여
                    for (int k = 0; k < N; k++) {
                        firstArr.add(secondArr[k]);
                    }
                }
            }

            //뒤에서 10개
            System.out.printf("#%d",t);
            for (int i = firstArr.size() - 1; i > firstArr.size() - 11; i--) {
                System.out.print(" "+firstArr.get(i));
            }
            System.out.println();
        }
    }
}
