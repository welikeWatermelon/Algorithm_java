import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Long[] arr = new Long[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr[1]=1L; // 1
        arr[2]=1L; // 2
        arr[3]=1L; // 3
        arr[4]=2L; // 4
        arr[5]=2L; // 5

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            System.out.println(triangle(n));
        }
    }

    public static long triangle(int n) {
        if (arr[n] != null) {
            return arr[n];
        }

        arr[n] = triangle(n - 1) + triangle(n - 5);
        return arr[n];
    }
}
