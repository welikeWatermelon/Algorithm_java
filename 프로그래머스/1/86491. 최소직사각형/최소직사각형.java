class Solution {
        public static int solution(int[][] sizes) {
        int mx0 = 0, mx1 = 0;
        for (int[] card : sizes) {
            mx0 = Math.max(mx0, Math.max(card[0], card[1]));
            mx1 = Math.max(mx1, Math.min(card[0], card[1]));
        }
        return mx0 * mx1;

    }
}