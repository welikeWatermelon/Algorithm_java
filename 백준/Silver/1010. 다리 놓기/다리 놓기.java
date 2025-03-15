import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static BigInteger[] tmp = new BigInteger[31];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        tmp[0] = BigInteger.ONE;
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if (N > N) {
                System.out.println(fact(N).divide(fact(M).multiply(fact(N - M))));
            } else if (N < M) {
                System.out.println(fact(M).divide(fact(N).multiply(fact(M - N))));
            } else {
                System.out.println(1);
            }
        }
    }

    public static BigInteger fact(int N) {
        if (N == 1) {
            return BigInteger.ONE;
        }
        if(tmp[N] != null) {
            return tmp[N];
        }

        tmp[N] = BigInteger.valueOf(N).multiply(fact(N - 1));
        return tmp[N];
    }
}
