import java.util.ArrayList;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int N = progresses.length;

        int[] tmpArr = new int[N];

        for (int i = 0; i < N; i++) {
            tmpArr[i] = (int)(Math.ceil((100 - progresses[i]) / (double) speeds[i]));
        }

        // 7 3 9
        int cnt = 1;

        int max = tmpArr[0];

        ArrayList<Integer> tmpAnswer = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (max < tmpArr[i]) { //A 뒤에 꺼가 더 클 경우
                tmpAnswer.add(cnt);
                max = tmpArr[i];
                cnt=1;
            } else { //B 뒤에꺼가 더 작거나 같을 때
                cnt++;
            }

            if (i == N - 1) {
                tmpAnswer.add(cnt);
                break;
            }
        }


        answer = tmpAnswer.stream().mapToInt(l -> l).toArray();
        return answer;
    }
}