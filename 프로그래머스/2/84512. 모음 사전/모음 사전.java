class Solution {
        public static int cnt;
    public static boolean[] checked;
    public static String[] arr = {"A","E","I","O","U"};
    public static String answerStr = "";
    public int solution(String word) {
        return comb(0,word);
    }

    public static int comb(int depth,String word) {
        if (word.equals(answerStr)) {
            return cnt;
        }
        if (depth == 5) {
            return -1;
        }

        for (int i = 0; i < 5; i++) {
            answerStr += arr[i];
            cnt++;
            int result = comb(depth + 1,word);
            if (result != -1) { // 찾은 경우 즉시 반환
                return result;
            }
            answerStr = answerStr.substring(0, answerStr.length() - 1);
        }

        return -1;
    }
}