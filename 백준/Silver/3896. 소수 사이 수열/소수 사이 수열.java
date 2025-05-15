import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inputs = new int[N];
        int max = 0;

        // 입력 받고 최댓값 추출
        for (int i = 0; i < N; i++) {
            inputs[i] = sc.nextInt();
            max = Math.max(max, inputs[i]);
        }

        int size = max * 2 + 2;
        boolean[] isPrime = new boolean[size];
        ArrayList<Integer> primeList = new ArrayList<>();

        // 에라토스테네스 단 한 번만 실행
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < size; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < size; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < size; i++) {
            if (isPrime[i]) primeList.add(i);
        }

        // 입력에 대해 처리
        for (int i = 0; i < N; i++) {
            int num = inputs[i];
            for (int j = 0; j < primeList.size() - 1; j++) {
                if (primeList.get(j) == num) {
                    System.out.println(0);
                    break;
                }
                if (primeList.get(j) < num && primeList.get(j + 1) > num) {
                    System.out.println(primeList.get(j + 1) - primeList.get(j));
                    break;
                }
            }
        }
    }
}
