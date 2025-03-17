import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if (65 <= c && c <= 90) { // 피연산자 일 경우
                answer+=c;
            } else if (c == ')') { // 닫힘 일 경우
                while (stack.peek() != '(') {
                    answer += stack.pop();
                }
                stack.pop(); // 열림 빼주기
            }else if(c=='('){
                stack.push(c);
            }
            else if (stack.isEmpty()) { //연산자 비어있을 경우
                stack.push(c);
            } else { // 스택이 안비어있고, 연산자일 경우
                // 새로 들어오는거 <= 있던거
                // 작은게 들어올 경우
                while (!stack.isEmpty() && map.get(c) <= map.get(stack.peek())) {
                    answer += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}


// ( 일 경우 들어갈때는 굉장히 강하지만 나올땐 우선 순위 0
// +,- 일 경우 우선 순위 1
// *,/ 일 경우 우선 순위 2
// 피연산자는 바로 결과에 붙여줘
// 스택에 있는 연산자가 다음 연산자보다 우선순위가 높거나 같을 경우 스택 pop
// 스택에 있는 연산자가 다음 연산자보다 우선순위가 작을경우 연산자 push


