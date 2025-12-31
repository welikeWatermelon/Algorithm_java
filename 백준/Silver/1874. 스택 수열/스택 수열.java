import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); // 출력 최적화
        
        int nextNum = 1; // 다음에 스택에 '넣어야 할' 숫자
        
        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            
            // 1. 타겟 숫자를 만들 때까지 순서대로 Push
            // 이 while문 하나로 "스택이 비었을 때"나 "숫자를 더 채워야 할 때"가 모두 해결됩니다.
            while (nextNum <= target) {
                stack.push(nextNum++);
                sb.append("+\n");
            }
            
            // 2. 스택의 맨 위(Top)가 내가 원하는 숫자인지 확인
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 3. 스택 맨 위가 타겟보다 크다면, 타겟은 이미 스택 밑에 깔린 것임 (불가능)
                System.out.println("NO");
                return;
            }
        }
        
        System.out.print(sb);
    }
}