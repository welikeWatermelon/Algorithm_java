package swea_0219;

import java.util.ArrayList;
import java.util.Scanner;

public class swea_5122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Test = sc.nextInt();
        for (int t = 1; t <= Test; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int L = sc.nextInt();

            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
//                sc.next();
            }

            //여기서 처리
            for (int i = 0; i < M; i++) {
                String ip = sc.next();
                // I i a: i인덱스에 a삽입 후 뒤로 밀기 (중간에 추가)
                if (ip.equals("I")) {
                    int idx = sc.nextInt();
                    int num = sc.nextInt();
                    arr.add(idx, num);
                }

                // D : 인덱스 자리 지우고, 한칸씩 앞으로 (중간에 삭제)
                else if (ip.equals("D")) {
                    int idx = sc.nextInt();
                    arr.remove(idx);
                }

                // C i a : 인덱스 i를 a로 바꾼다 (중간에 변경)
                else {
                    int idx = sc.nextInt();
                    int num = sc.nextInt();
                    arr.set(idx, num);
                }
            }

//            System.out.println("#" + t + " " + arr.get(L));
            if(L>arr.size()) {
                System.out.printf("#%d %d\n",t,-1);
                continue;
            }

            System.out.printf("#%d %s\n",t,arr.get(L));

        }
    }
}
