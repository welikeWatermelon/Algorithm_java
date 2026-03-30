import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 예외 처리: 1은 소수가 아니므로 경우의 수는 0
        if (N == 1) {
            System.out.println(0);
            return;
        }

        // 1. 에라토스테네스의 체로 N까지의 소수 리스트 생성
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[N + 1];
        
        // 배열 초기화: 일단 모두 소수(true)라고 가정
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체 알고리즘 적용
        for (int i = 2; i * i <= N; i++) {
            // i가 소수라면, i의 배수들은 소수가 아님(false)으로 지움
            if (isPrime[i]) {
                // i*i부터 시작하는 이유는 i*(2...i-1)은 이미 이전 주수들에 의해 지워졌기 때문
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수(true)인 인덱스만 리스트에 담기
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // 2. 투 포인터로 연속된 소수의 합이 N이 되는 경우의 수 찾기
        int i = 0, j = 0, sum = 0, cnt = 0;
        int size = primes.size();

        // 반 열린 구간 [i, j) 모델 사용
        while (true) {
            if (sum >= N) {
                // 합이 N과 같으면 경우의 수 증가
                if (sum == N) {
                    cnt++;
                }
                // 합이 N 이상이면 왼쪽(i)을 줄여서 범위를 좁혀봄
                sum -= primes.get(i++);
            } else if (j == size) {
                // 합이 N보다 작은데 오른쪽(j)이 끝에 도달하면 더 이상 가망 없음
                break;
            } else {
                // 합이 N보다 작으면 오른쪽(j)을 늘려서 합을 키움
                sum += primes.get(j++);
            }
        }

        System.out.println(cnt);
    }
}