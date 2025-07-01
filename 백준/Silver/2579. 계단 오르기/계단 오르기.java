import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] score = new int[N + 1];
        int[] maxScore = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            score[i] = sc.nextInt();
        }

        maxScore[1] = score[1];
        if (N >= 2) maxScore[2] = score[1] + score[2];
        if (N >= 3) maxScore[3] = Math.max(score[1], score[2]) + score[3];

        for (int i = 4; i <= N; i++) {
            maxScore[i] = Math.max(maxScore[i - 2], maxScore[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(maxScore[N]);
    }
}
