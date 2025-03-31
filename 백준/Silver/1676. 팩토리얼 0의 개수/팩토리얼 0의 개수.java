import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static int five, two;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N+1];

//        int num = fact(N);
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            findZeroFive(i);
        }

        System.out.println(Math.min(five,two));
    }

//    public static int fact(int n) {
//        if (arr[n] != 0) {
//            return arr[n];
//        }
//
//        if (n == 1 || n == 0) {
//            return 1;
//        }
//
//        return arr[n] = n * fact(n - 1);
//    }

    public static void findZeroFive(int n) {
        int tmp = n;
        while (tmp %2 == 0 || tmp%5 == 0) {
            if (tmp % 5 == 0) {
                five++;
                tmp/=5;
            }

            if (tmp % 2 == 0) {
                two++;
                tmp/=2;
            }
        }
    }

}

// 이 코드 int 범위를 벗어남

