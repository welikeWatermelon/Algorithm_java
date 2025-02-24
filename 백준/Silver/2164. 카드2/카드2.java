
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> cards = new LinkedList<>();
        //순서는 1번(제일 위)부터 N번까지 카드가 있음
        //제일 위에 있는 카드를 버림
        //제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김
        for (int i = 1; i <= N; i++) {
            cards.add(i);
        }

        while (cards.size()!=1) {
            cards.poll();
            cards.add(cards.poll());
        }
        System.out.println(cards.peek());
    }
}
