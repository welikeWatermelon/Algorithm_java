package src._2_array;

import java.util.Scanner;

public class array5_2 {
    public static int solution(int n) {
        int answer=0;
        int[] arr = new int[n+1]; //자동으로 0으로 초기화됨
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (arr[i] == 0) {
                answer += 1;
                for (int j = i; j < n+1; j=j+i) {
                    arr[j] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        array5_2 T = new array5_2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(T.solution(n));
    }
}

