import java.util.ArrayList;

class Solution {
        public static int[] solution(int[] answers) {
        int[] answer;
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int sc[] = new int[3];

        for (int i = 0; i < answers.length; i++) {
            int dn1 = i%5;
            int dn2 = i%8;
            int dn3 = i%10;
            if (answers[i] == num1[dn1]) {
                sc[0]++;
            }
            if (answers[i] == num2[dn2]) {
                sc[1]++;
            }
            if (answers[i] == num3[dn3]) {
                sc[2]++;
            }
        }

        int mx = Math.max(sc[0], Math.max(sc[1], sc[2]));
        ArrayList<Integer> tmpAns = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (sc[i] == mx) {
                tmpAns.add(i+1);
            }
        }

        answer = tmpAns.stream().mapToInt(i->i).toArray();
        return answer;
    }
}