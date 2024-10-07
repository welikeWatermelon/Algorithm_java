package src.twoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class t1 {
    public static int[] solution(int n, int m, int[] nArr, int[] mArr) {
        int[] newArr = new int[n + m];
        System.arraycopy(nArr, 0, newArr, 0, n);
        System.arraycopy(mArr, 0, newArr, n, m);

        Arrays.sort(newArr);

        return newArr;
    }

    public static void main(String[] args) {
        t1 T = new t1();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] mArr = new int[m];
        for (int j = 0; j < m; j++) {
            mArr[j] = scanner.nextInt();
        }

        for (int i : T.solution(n,m,nArr,mArr)) {
            System.out.print(i + " ");
        }
    }
}
