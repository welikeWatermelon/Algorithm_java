import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속한 한 개 이상의 수를 뽑았을 때,
// 같은 수가 여러 번 등장하지 않는 경우의 수를 구하라

// 슬라이딩 윈도우 크기가 계속 변해야함 (1부터 N까지) -> O(N)
// 그 안에서 중복 확인하며 돌아야함 (최악의 경우 N인데 10,000,000,000 -> 10^10 불가
// 그럼 중간에 점프를 할까? 만약 안에 중복되는게 있어. 그럴경우 바로 점프
// N-2번 -> N-3번 -> N-4 -> .. 2번
// -> (1 + N)N / 2 -> 1/2 * N^2 -> 5*10^9 -> 불가
//

// 여기 핵심 생각은 right가 가리키는 숫자를 끝으로 하는 새로운 조합은 (right-left + 1) 이라는 것
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

        boolean[] isUsed = new boolean[100001];

        // left는 처음 고정
        int left = 0;
        long totalCount = 0;

        for (int right = 0; right < N; right++) {

            // 왼쪽 이동 (중복이 제거될떄까지)
            while (isUsed[arr[right]]) {
                isUsed[arr[left]] = false;
                left++;
            }

            isUsed[arr[right]] = true;
            totalCount += (right - left + 1);
        }

        System.out.println(totalCount);


    }
}
