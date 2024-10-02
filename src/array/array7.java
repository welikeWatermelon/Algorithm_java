package src.array;

import java.util.Scanner;

public class array7 {
    public static int solution(int n, int[] arr) {
        int answer = 0;
        int r = 0; //반복 횟수

        for (int i : arr) {
            if (i == 1) {
                r += 1;
                answer += r;
            }
            if (i == 0) {
                r = 0;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        array7 T = new array7();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
