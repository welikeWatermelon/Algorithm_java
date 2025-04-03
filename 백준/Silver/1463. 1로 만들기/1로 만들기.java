import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();



        // 1,2,3번중 어떤 거를 써야하는지 순서가 중요한 문제임
        // 최소의 경우의 수를 필요로 함
        // dp 배열에 저장하면서 최솟값을 찾아야겠지?
        // ㄱ

        int[] dp = new int[X+1];
        dp[X] = 0;
        for (int i = 0; i < X; i++) {
            dp[i] = 1000000;
        }

        for (int x=X; x>=1; x--) {
            if (x % 3 == 0) { // 1번
                dp[x/3]= Math.min(dp[x/3],dp[x]+1); //   3으로 나누지 않고, 다른방법으로 갔을 때 / 3으로 나눴을 때
                // 9 -> 3 으로 갈 때, 9->8->4->3 / 9->3   ---> 4 / 2 둘 중 최솟값으로 갱신
            }

            if (x % 2 == 0) { // 2번
                dp[x/2] = Math.min(dp[x/2],dp[x]+1);
            }

            dp[x - 1] = Math.min(dp[x - 1], dp[x] + 1); // 3번
        }

        System.out.println(dp[1]);
    }
}



// X가 3으로 나누어 떨어지면, 3으로 나눈다.
// X가 2로 나누어 떨어지면, 2로 나눈다.
// 1을 뺀다.


// 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
// 연산을 사용하는 횟수의 최솟값을 출력하시오.