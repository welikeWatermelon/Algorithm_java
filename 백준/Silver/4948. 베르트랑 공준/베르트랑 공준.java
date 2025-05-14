import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int N = sc.nextInt();

            int size = 2*N+1;
            if (N == 0) {
                break;
            }
            boolean[] checked = new boolean[size];

            for (int i = 2; i < size; i++) {
                checked[i] = true;
            }


            for (int i = 2; i*i < size; i++) {
                if (checked[i]) {
                    for (int j = i*i; j < size; j += i) {
                        checked[j]=false;
                    }
                }
            }


            int cnt=0;
            for (int i = N+1; i <= N * 2; i++) {
                if (checked[i]) {
                    cnt++;
                }
            }

            System.out.println(cnt);

        }

    }
}