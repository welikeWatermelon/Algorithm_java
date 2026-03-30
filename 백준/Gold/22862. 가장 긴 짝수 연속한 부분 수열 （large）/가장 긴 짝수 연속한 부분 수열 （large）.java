import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // S에서 원하는 위치에 있는 수를 골라 최대 K번 삭제 가능
        int[] S = new int[N];
        ArrayList<Integer> odd = new ArrayList<>(); // 홀수의 인덱스가 들어있음

        int oddCnt = 0;
        int evenCnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            S[i] = num;
        }
        int i=0, j = 1;
        if (N == 1) {
            System.out.println(S[i] % 2 == 0 ? 1 : 0);
            return;
        }

        if (S[i] % 2 == 0) {
            evenCnt++;
        } else {
            oddCnt++;
        }

        int maxEven = evenCnt;

        while(i<j){
            if (oddCnt > K) {
                if (S[i] % 2 == 0) {
                    evenCnt--;
                } else {
                    oddCnt--;
                }
                i++;

            }else{
                if (j >= N) {
                    break;
                }
                if (S[j] % 2 == 0) {
                    evenCnt++;
                    maxEven = Math.max(maxEven, evenCnt);
                } else {
                    oddCnt++;
                }
                j++;
            }
        }

        System.out.println(maxEven);

    }
}
