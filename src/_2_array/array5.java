package src._2_array;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class array5 {
    public static int solution(int n) {
        int answer=0;
        boolean flag;
        for (int i = 2; i < n+1; i++) {
            flag = true;
            for (int j = 2; j <= sqrt(i); j++) {
                if (i % j == 0) { //소수가 아님
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        array5 T = new array5();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(T.solution(n));
    }
}

