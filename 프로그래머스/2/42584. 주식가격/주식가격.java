import java.util.ArrayList;

class Solution {
     public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < prices.length-1; i++) {
            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    cnt++;
                } else {
                    cnt+=1;
                    break;
                }
            }
            tmp.add(cnt);
        }
                 tmp.add(0);
        answer = tmp.stream().mapToInt(i->i).toArray();
        return answer;
    }
}