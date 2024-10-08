package src._3_twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class t1_2 {
    public static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                answer.add(a[p1++]);
            } else{
                answer.add(b[p2++]);
            }
        }
        while (p1 < n) {
            answer.add(a[p1++]);
        }
        while (p2 < m) {
            answer.add(b[p2++]);
        }

        return answer;
    }

    public static void main(String[] args) {
        t1_2 T = new t1_2();
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
