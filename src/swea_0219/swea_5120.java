package swea_0219;

import java.util.ArrayList;
import java.util.Scanner;

public class swea_5120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt(); //
            int K = sc.nextInt();

            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }

            int newM = 0;
            int idx=0;
            for (int k = 0; k < K; k++) {
                idx = (idx+M)% (arr.size());
                arr.add(idx,0);
                int a ;
                if(idx-1<0) a = arr.get(arr.size() - 1);
                else a = arr.get(idx - 1);
                int b = arr.get(idx);
                arr.set(idx, a + b);
            }
            if (arr.size() >= 10) {
                System.out.printf("#%d", t);
                for (int i = arr.size() - 1; i > arr.size() - 11; i--) {
                    System.out.printf(" %d", arr.get(i));
                }
                System.out.println();
            } else {
                System.out.printf("#%d", t);
                for (int i = arr.size() - 1; i >= 0; i--) {
                    System.out.printf(" %d", arr.get(i));
                }
                System.out.println();
            }
        }
    }
}
