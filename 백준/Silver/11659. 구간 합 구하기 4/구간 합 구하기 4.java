import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt(); 

        int[] arr = new int[N + 1];      // 원본 배열 
        int[] prefix = new int[N + 1];   // 누적합 배열

        // 입력과 동시에 누적합 계산
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // 구간 합 출력
        for (int m = 0; m < M; m++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(prefix[j] - prefix[i - 1]);
        }

        sc.close();
    }
}
