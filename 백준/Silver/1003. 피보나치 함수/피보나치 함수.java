import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<int[]> fibo_zero_one = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            for (int j = 0; j <= N; j++) {
                fibo_zero_one.add(null);
            }

            int[] answer = fibonacci(N);
            System.out.println(answer[0]+" "+answer[1]);
        }
    }

    public static int[] fibonacci(int N){
        if (fibo_zero_one.get(N) != null) {
            return fibo_zero_one.get(N);
        }else{
            if (N == 0) {
                fibo_zero_one.set(0, new int[]{1, 0});
                return fibo_zero_one.get(N);
            } else if (N == 1) {
                fibo_zero_one.set(1, new int[]{0, 1});
                return fibo_zero_one.get(N);
            } else {
                int[] arr1 = fibonacci(N - 1);
                int[] arr2 = fibonacci(N - 2);
                int[] arrN = {arr1[0] + arr2[0], arr1[1] + arr2[1]};
                fibo_zero_one.set(N, arrN);
                return fibo_zero_one.get(N);
            }
        }
    }
}
