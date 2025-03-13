import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int cnt = 0;

        // Stack 리스트 초기화
        List<Stack<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new Stack<>());
        }

        for (int i = 0; i < N; i++) {
            int string = sc.nextInt() - 1;
            int fret = sc.nextInt();
            Stack<Integer> stack = list.get(string);

            // 더 높은 프렛을 유지하기 위해 낮은 프렛 제거
            while (!stack.isEmpty() && stack.peek() > fret) {
                stack.pop();
                cnt++;
            }

            // 같은 프렛이 아닐 경우에만 추가
            if (stack.isEmpty() || stack.peek() < fret) {
                stack.push(fret);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
