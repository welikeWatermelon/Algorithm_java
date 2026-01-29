import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(pow(A, B, C));
    }

    public static long pow(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }
        long temp = pow(A, B / 2, C);

        if (B % 2 == 1) {
            return (temp * temp % C) * (A % C) % C;
        }

        return temp * temp % C;
    }
}