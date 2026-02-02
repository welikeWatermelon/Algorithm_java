import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] minDp = new int[3];
        int[] maxDp = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                minDp[0] = maxDp[0] = x1;
                minDp[1] = maxDp[1] = x2;
                minDp[2] = maxDp[2] = x3;

            } else {
                int prevMax0 = maxDp[0];
                int prevMax1 = maxDp[1];
                int prevMax2 = maxDp[2];

                int prevMin0 = minDp[0];
                int prevMin1 = minDp[1];
                int prevMin2 = minDp[2];

                
                maxDp[0] = Math.max(prevMax0, prevMax1) + x1;
                maxDp[1] = Math.max(prevMax0, Math.max(prevMax1,prevMax2)) + x2;
                maxDp[2] = Math.max(prevMax1, prevMax2) + x3;


                minDp[0] = Math.min(prevMin0, prevMin1) + x1;
                minDp[1] = Math.min(prevMin0, Math.min(prevMin1,prevMin2)) + x2;
                minDp[2] = Math.min(prevMin1, prevMin2) + x3;
            }
            
        }

        System.out.println(Math.max(Math.max(maxDp[0],maxDp[1]),maxDp[2])+" "+Math.min(Math.min(minDp[0],minDp[1]),minDp[2]));
    }
}
