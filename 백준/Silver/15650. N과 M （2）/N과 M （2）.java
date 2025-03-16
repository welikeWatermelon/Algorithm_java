import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static int[] answer;
    public static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        answer = new int[M];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }

        comb(0, 0);

        
    }
    
    public static void comb(int idx,int sidx) {
        if (sidx == M) {
            for (int i = 0; i < M; i++) {
                System.out.printf("%d ",answer[i]);
            }
            System.out.println();
            return;
        }

        if (idx == N) {
            return;
        }

        answer[sidx] = arr[idx];
        comb(idx + 1, sidx + 1); //그 전에꺼 받고 다음으로 이동
        comb(idx + 1, sidx); //그 전에꺼 안받고 무시했다
    }
}