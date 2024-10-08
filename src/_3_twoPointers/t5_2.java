package src._3_twoPointers;

import java.util.Scanner;

public class t5_2 {
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        t5_2 T = new t5_2();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(T.solution(a));
    }
}
// 연속된 자연수로 표현할수 있는지 여부를 수학적으로!
// 15를 연속된 숫자로 할수있나?
// 1,2 로 하고 [15-(1+2)]%2 == 0이라면 나눠지는거
// 1,2,3 로 하고 [15-(1+2+3)]%3 == 0 이라면 나눠지는거
