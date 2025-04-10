import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 나무 개수
        int M = sc.nextInt(); // 가져가야하는 나무 길이

        long[] arr = new long[N]; // int -> long
        long max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong(); // 랜선 길이 최대 2^31-1 이므로 long
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long left = 0;
        long right = max;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sumTree = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0) {
                    sumTree += arr[i] - mid;
                }
            }

            if (sumTree >= M) {
                answer = Math.max(answer, mid);
                left = mid+1;
            } else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

//  높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다.
//  예를 들어, 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자.
//  상근이가 높이를 15로 지정했다면, 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고,
//  상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다.
//  총 7미터를 집에 들고 간다

// 나무를 필요한 만큼만 집으로 가져가려고 한다.


// 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값