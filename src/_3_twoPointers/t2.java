package src._3_twoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class t2 {
    public static Integer[] solution(int n, int m, Integer[] nArr, Integer[] mArr) {
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(nArr));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(mArr));
        set1.retainAll(set2);

        Integer[] answer = set1.toArray(new Integer[0]);
        // Set 객체의 toArray() 메소드를 이용하면, Set 객체를 배열로 변환할 수 있습니다.
        //파라미터로는, 변환될 배열 객체를 넘겨주면 되는데,
        //이때 배열의 크기를 0으로 지정하면 자동으로 배열의 크기가 지정됩니다.

        Arrays.sort(answer);

        return answer;
    }
    public static void main(String[] args) {
        t2 T = new t2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] nArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        Integer[] mArr = new Integer[m];
        for (int j = 0; j < m; j++) {
            mArr[j] = scanner.nextInt();
        }

        for (int i : T.solution(n,m,nArr,mArr)) {
            System.out.print(i + " ");
        }
    }
}
