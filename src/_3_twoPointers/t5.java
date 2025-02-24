package src._3_twoPointers;

import java.util.Scanner;

//런타임오류
public class t5 {
    static int[] sumArr;
    public static int solution(int n) {
        int answer=0;
        int[] arr = new int[n/2+1];
        for (int i = 0; i < n/2+1; i++) {
            arr[i] = i + 1;
        }
        sumArr = new int[n / 2 + 1];
        sumArr[0] = arr[0];

        for (int i = 1; i < n / 2 + 1; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = i + 1; j < n / 2 + 1; j++) {
                if (distanceSum(j,i)>n) {
                    break;
                } else if (distanceSum(j, i) == n) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        t5 T = new t5();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(T.solution(n));
    }

    public static int distanceSum(int end, int start) {
        if (start == 0) {
            return sumArr[end];
        }
        return sumArr[end] - sumArr[start - 1];
    }
}
