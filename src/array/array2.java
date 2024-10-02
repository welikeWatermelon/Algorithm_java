package src.array;

import java.util.Scanner;

public class array2 {
    private static int solution(int n, int[] arr) {
        int answer=0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i]>max) {
                answer++;
                max = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        array2 T = new array2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
