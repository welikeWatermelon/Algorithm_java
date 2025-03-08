import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> qu = new LinkedList<>();

        // 큐에 (우선순위, 인덱스) 저장
        for (int i = 0; i < priorities.length; i++) {
            qu.add(new int[]{priorities[i], i});
        }

        int cnt = 0; // 몇 번째로 출력되는지 카운트

        while (!qu.isEmpty()) {
            int[] current = qu.poll(); // 현재 꺼낸 문서 (우선순위, 인덱스)
            boolean hasHigherPriority = false;

            // 큐 안에 현재보다 우선순위가 높은 게 있는지 확인
            for (int[] doc : qu) {
                if (doc[0] > current[0]) { // 더 높은 우선순위가 존재하면
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                // 우선순위가 높은 게 있으면 다시 큐에 넣기
                qu.add(current);
            } else {
                // 현재 문서가 인쇄됨
                cnt++;

                // 우리가 찾는 문서면 정답 반환
                if (current[1] == location) {
                    return cnt;
                }
            }
        }

        return answer;
    }
}