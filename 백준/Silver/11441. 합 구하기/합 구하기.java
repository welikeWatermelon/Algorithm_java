import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int[] sumArr = makeSum(nums, N);

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sumArr[end] - sumArr[start-1]);
        }

    }

    public static int[] makeSum(int[] nums, int N) {
        int[] sumArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i-1] + nums[i-1];
        }


        return sumArr;
    }
}
