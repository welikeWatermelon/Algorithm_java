package src.array;

import java.util.ArrayList;
import java.util.*;
import static java.lang.Math.sqrt;

public class array6_2 {
    public static boolean isPrime(int num) {//소수인지 확인
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
// 뒤집고 소수 판정하기
    public static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10; //1의 자리
                res = res * 10 + t; //숫자 붙이는 과정
                tmp = tmp / 10;
            }
            if (isPrime(res)) {
                answer.add(res);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        array6_2 T = new array6_2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (Integer i : T.solution(n,arr)) {
            System.out.printf("%d ",i);
        }
    }
}
