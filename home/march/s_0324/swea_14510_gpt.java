package s_0324;

import java.util.*;

public class swea_14510_gpt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] trees = new int[N];
            int maxHeight = 0;

            for (int i = 0; i < N; i++) {
                trees[i] = sc.nextInt();
                maxHeight = Math.max(maxHeight, trees[i]);
            }

            List<Integer> diff = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int gap = maxHeight - trees[i];
                if (gap > 0) diff.add(gap);
            }

            int oneCount = 0; // 필요한 1짜리 물주기 개수
            int twoCount = 0; // 필요한 2짜리 물주기 개수

            for (int d : diff) {
                oneCount += d % 2;
                twoCount += d / 2;
            }

            int answer = 0;

            if (twoCount >= oneCount) {
                // 1, 2를 교차로 배치할 수 있음
                // 예: [1][2][1][2]...[2][2][2]
                answer = oneCount * 2 - 1 + (twoCount - oneCount);
            } else {
                // 1짜리가 더 많으면, 교차 배치가 안 됨 → 3일에 2번 1짜리 해야 됨
                // 예: [1][1][2][1][1][2]...
                int rest = oneCount - twoCount;
                answer = twoCount * 2 + rest * 2 - 1;
            }

            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
