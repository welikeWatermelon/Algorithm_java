import java.util.*;

public class Main {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static long N;
    public static long M;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();


        rec(N,1);

        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }

    public static void rec(long num, int cnt){
        if (num == M) {
            answer = Math.min(answer,cnt);
            return;
        }

        if (num > M) {
            return;
        }

        rec(num*2,cnt+1);
        rec(num * 10 + 1, cnt + 1);
    }
}

