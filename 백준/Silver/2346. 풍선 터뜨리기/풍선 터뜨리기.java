import java.util.Deque;
import java.util.Scanner;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<int[]> deque = new ArrayDeque<>();

        // int[] = [ index , nextStep ]

        for (int i = 0; i < N; i++) {
            int[] tmp = {i + 1, sc.nextInt()};
            deque.add(tmp);
        }

        int[] tmpArr = deque.pop();
        int nextStep = tmpArr[1]; // 처음 1번을 뽑았을 때,
        System.out.print(tmpArr[0]); // 처음 1번 출력

        while (deque.size() != 1) {
            if (nextStep < 0) {
                nextStep += 1;
                for (int i = 0; i < Math.abs(nextStep); i++) {
                    deque.addFirst(deque.removeLast());
                }
                tmpArr = deque.removeLast();
                System.out.print(" " + tmpArr[0]);
                // nextStep 갱신
                nextStep = tmpArr[1];
            } else {
                nextStep -= 1;
                for (int i = 0; i < nextStep; i++) {
                    deque.addLast(deque.removeFirst());
                }
                tmpArr = deque.removeFirst();
                System.out.print(" " + tmpArr[0]);
                // nextStep 갱신
                nextStep = tmpArr[1];
            }

        }
        System.out.print(" " + deque.pop()[0]);

    }
}