package swea_0219;

import java.util.ArrayList;
import java.util.Scanner;

public class swea_5108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int N = sc.nextInt(); //원소 갯수
            int M = sc.nextInt(); //추가 횟수
            int L = sc.nextInt(); //출력할 인덱스

            //배열 입력
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }

            //추가 (횟수만큼 반복)
            for (int m = 0; m < M; m++) {
                int addIdx = sc.nextInt();
                int addNum = sc.nextInt();
                arr.add(addIdx, addNum);
            }

            System.out.printf("#%d %d\n",t,arr.get(L));

        }
    }
}
