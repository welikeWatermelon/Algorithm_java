import java.util.Scanner;

public class Main {
    public static long B;
    public static int N;
    public static int[][] matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = sc.nextLong();

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt() % 1000;
            }
        }
        int[][] answer = multiplication2(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println(answer[i][N-1]);
        }

    }
    public static int[][] multiplication(int[][] arr1, int[][] arr2){

        int[][] tmp = new int[N][N];

        for (int a = 0; a < N; a++) { // 행
            for (int b = 0; b < N; b++) { // 열
                int sum = 0;
                for (int j = 0; j < N; j++) { // 이제 곱한다
                    sum += (arr1[a][j] * arr2[j][b]); // arr1은 행 고정, arr2는 열 고정
                    sum %= 1000;
                }
                tmp[a][b] = sum;
            }
        }

        return tmp;

    }

    public static int[][] multiplication2(long n) {

        if (n == 1) {
            return matrix;
        }

        int[][] half = multiplication2(n / 2);
        int[][] tmp = multiplication(half, half);

        if (n % 2 == 0) {
            return tmp;
        } else {
            return multiplication(tmp, matrix);
        }
    }
}
