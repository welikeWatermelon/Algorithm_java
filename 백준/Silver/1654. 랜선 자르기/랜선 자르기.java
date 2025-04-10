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
    boolean over = false;

    for (int i = 0; i < K; i++) {
        count += arr[i] / mid;
        if (count >= N) { // 이때는 답이 될 수 있으므로 break만!
            over = true;
            break;
        }
    }

    if (over) {
        answer = mid;     // 이 경우 정답 가능성 있음!!
        left = mid + 1;   // 더 긴 길이 탐색
    } else {
        right = mid - 1;
    }
}


        System.out.println(answer);
    }
}
