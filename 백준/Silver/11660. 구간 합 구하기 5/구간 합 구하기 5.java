import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j] = sc.nextInt();
            }
        }



        int[][] sumArr = makeSum(nums, N);


        for (int i = 0; i < M; i++) {
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            
            int result = sumArr[endX][endY] - sumArr[startX - 1][endY] - sumArr[endX][startY - 1] + sumArr[startX - 1][startY - 1];

            System.out.println(result);
        }
    }

    public static int[][] makeSum(int[][] nums, int N) {
        int[][] sumArr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + nums[i-1][j-1];
            }
        }


        return sumArr;
    }
}
