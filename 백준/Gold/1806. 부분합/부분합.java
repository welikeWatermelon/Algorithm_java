import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열 길이
        int S = sc.nextInt(); // 목표 합
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < N; end++) {
            sum += arr[end];

            while (sum >= S) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start++];
            }
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
