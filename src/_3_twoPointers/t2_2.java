package src._3_twoPointers;

import java.util.*;

public class t2_2 {
    public static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            }
            else if (a[p1]<b[p2]) p1++;
            else p2++;
        }
        return answer;
    }

    public static void main(String[] args) {
        t2_2 T = new t2_2();
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
