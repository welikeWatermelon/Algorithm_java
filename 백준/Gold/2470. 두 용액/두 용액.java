import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int i = 0, j = N - 1, sum = arr[i] + arr[j];
        int answerI = 0;
        int answerJ = N-1;
        int answerSum = Math.abs(sum);

        while (i < j) {
            if(j-i==1) break;
            if (sum > 0) {
                j--;
                sum = arr[j] + arr[i];
                if (answerSum > Math.abs(sum)) {
                    answerSum = Math.abs(sum);
                    answerI = i;
                    answerJ = j;
                }
            } else if (sum == 0) {
                answerI = i;
                answerJ = j;
                break;
            } else {
                i++;
                sum = arr[j] + arr[i];
                if (answerSum > Math.abs(sum)) {
                    answerSum = Math.abs(sum);
                    answerI = i;
                    answerJ = j;
                }
            }
        }
        System.out.print(arr[answerI]+ " " + arr[answerJ]);
    }
}
