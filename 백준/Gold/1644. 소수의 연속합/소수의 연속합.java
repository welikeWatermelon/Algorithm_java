import java.util.ArrayList;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        // 1. 소수 구하기 N 까지 구하기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> decimal = new ArrayList<>();

        boolean[] tmp = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            tmp[i]=true;
        }

        // 에라토스테네스 채

        for (int i = 2; i * i <= N; i++) {
            if (tmp[i]) {
                for (int j = i*i; j <= N; j += i) {
                    tmp[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (tmp[i]) {
                decimal.add(i);
            }
        }

        // 2. 투포인터 이용
        int start = 0;
        int end = 0;
        int cnt = 0;
        int sum = 0;

        while (true){
            if (sum >= N) {
                sum -= decimal.get(start++);
            } else if (end==decimal.size()) {
                break;
            } else {
                sum += decimal.get(end++);
            }

            if (sum == N) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}