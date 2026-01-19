import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] cntArr = new int[10];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int sortCnt = 0;
        int answer = 0;

        for (int right = 0; right < N; right++) {
            if (cntArr[arr[right]] == 0) {
                sortCnt ++;
            }
            
            cntArr[arr[right]]++;

            while (sortCnt>2) {
                cntArr[arr[left]]--;
                if (cntArr[arr[left]] == 0) {
                    sortCnt--;
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }
        System.out.println(answer);
    }
}
