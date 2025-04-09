import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        long[] arr = new long[K]; // int -> long
        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextLong(); // 랜선 길이 최대 2^31-1 이므로 long
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long left = 1;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
            }

            if (count >= N) {
                answer = mid; // 가능한 길이 저장
                left = mid + 1; // 더 긴 길이도 가능할 수 있음
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
