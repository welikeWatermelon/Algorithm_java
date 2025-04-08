import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;

        int start  = 0;
        int end = 0;
        while (start!=N && end!=N) {
            int tmpAns = 0;
            for (int i = start; i <= end; i++) {
                tmpAns += arr[i];
            }
            if (tmpAns == M) {
                answer++;
                start++;
                end++;
            } else if (tmpAns < M) {
                end++;
            } else {
                start++;
            }
        }

        System.out.println(answer);

        // A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수
        // 부분합이 M이 되는 경우가 몇가지?
    }
}