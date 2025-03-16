import java.util.Scanner;
//min보다 차이가 작으면 그 결과 값을 min에 계속 갱신
public class Main {
    public static int[] sour;
    public static int[] bitter;
    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sour = new int[N];
        bitter = new int[N];
        for (int i = 0; i < N; i++) {
            sour[i] = sc.nextInt();
            bitter[i] = sc.nextInt();
        }

        comb(0, 1, 0);
        System.out.println(min);

        
    }
    
    public static void comb(int idx, int s, int bit) {
        if (bit!= 0 && Math.abs(s-bit)<min) {
            min = Math.abs(s - bit);
        }

        if (idx == N) {
            return;
        }
        
        comb(idx + 1, s*sour[idx],bit+bitter[idx]); //그 전에꺼 받고 다음으로 이동, 현재꺼 받는거
        comb(idx + 1, s,bit); //지금꺼 안받고 무시했다 , 현재꺼 더하지 말고 넘겨

    }
}