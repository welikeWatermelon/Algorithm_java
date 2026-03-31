import java.io.*;
import java.util.*;

// 눈덩이 N개
// 각 눈덩이 지름 Hi
// 하나의 눈사람은 두 개의 눈덩이로 구성되고
// 눈덩이 하나를 아래에 두고 그 눈덩이보다 크지않은 다른 눈덩이를 쌓아 올림
// 눈사람의 키 : 두 눈덩이의 지름의 합
//
// 눈덩이 N개중 서로 다른 4개를 골라 눈사람을 각각 1개씩 만드려고 함
// 두 눈 사람의 키의 차이가 작은거 구하는것

// 눈사람 크기는 long으로 해야 안전함 (최대 크기 10억임 - 근데 상관 없을듯 21억까진데 20억까지가 최대임.int로 하자)
// 네개의 눈 덩이를 골라야함 nC4? -> n^4 = 200,000,000,000  -> 2 * 10^11 -> 절대 안됨

// 두 덩이를 고르고, nC2 -> 360,000
// 여기서 한번의 순환으로 최적의 두덩이를 고르는건? 오름차순으로 정렬한다고 해도 이웃한 두개를 집는건 최적일까? 3 7 15 가 있다고 치고 18과 가깝게 만들어야 한다면 3 15가 최적임. 즉, 이웃 한 것 고를 수 없음

// 정렬시키고 연속된 네개를 고르는건?
//  1 2 9 20 25 100 20000 20001 20002 있다고 가정
// (21,15) , (31,29), (109,45), (20020,125), (20026, 20100), (20102, 40001)
// 이것도 불가능
//

// N^3 은? 216,000,000/6 = 36,000,000 -> 3.6*10^7 이니까 가능
// N^2 를찾고 N을 찾아보자
// 오름차순 정리
// 두개 선택 (N^2) - A
// 두 개 안에서 두개를 찾는데, 이 두개는 A의 합과 최적으로 되게끔 (차이가 최소개 되게끔 찾아야함)


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

        int minSub = Integer.MAX_VALUE;
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 3; j < N; j++) {

                int firstSum = arr[i] + arr[j];
                int left = i+1;
                int right = j-1;
                while (left < right) {
                    int secondSum = arr[left] + arr[right]; // 1. 현재 Elsa 합 계산
                    int diff = secondSum - firstSum;       // 2. 차이 계산

                    minSub = Math.min(minSub, Math.abs(diff)); // 3. 최솟값 갱신

                    // 4. 차이에 따라 포인터 이동 (이동 후에는 while 조건에 의해 left < right 검증됨)
                    if (diff > 0) {
                        right--;
                    } else if (diff < 0) {
                        left++;
                    } else {
                        System.out.println(0); // 차이가 0이면 즉시 종료
                        return;
                    }
                }
            }
        }
        System.out.println(minSub);


    }
}
