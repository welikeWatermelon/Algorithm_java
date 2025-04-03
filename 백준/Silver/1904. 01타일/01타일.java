import java.util.Scanner;

public class Main {
    public static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N + 1];
        System.out.println(fibo(N));

    }

    public static int fibo(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }

        if (n == 1) {
            return dp[1] = 1;
        }
        if (n == 2) {
            return dp[2] = 2;
        }

        return dp[n] =  (fibo(n - 2)+ fibo(n - 1))%15746;
    }
}

// 타일 : 0 또는 1이 쓰여있음
// 동주가 0이 쓰여진 타일들을 붙여서 한쌍으로 00 타일들을 만들었음
// 결국 현재 1 하나만으로 이주러진 타일 또는 0타일을 두개 붙인 한쌍의 00 타일들만 남음
// N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.)
// N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.
// 우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다.

// dp[n] = dp[n-2] -> n-2자리수에 00을 더하거나 11만 더할 수 있음
//         + dp[n-1]

// 1 : 1    1
// 2 : 2    11  00
// 3 : 3    100 001 111
// 4 : 5    0011 0000 1001 1100 1111
// 5 : 8    00111 10011 11100 11001 11111  10000  00100 00001