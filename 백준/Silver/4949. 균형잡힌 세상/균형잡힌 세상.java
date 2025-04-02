import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out:
        while (true) {
            String tmp = sc.nextLine();
            if (tmp.equals(".")) {
                break;
            }

            char[] arr = tmp.toCharArray();
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(') {
                    st.add(arr[i]);
                } else if (arr[i] == '[') {
                    st.add(arr[i]);
                } else if (arr[i] == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        System.out.println("no");
                        continue out;
                    }
                    st.pop();
                } else if (arr[i] == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        System.out.println("no");
                        continue out;
                    }
                    st.pop();
                }
            }
            if (st.size() != 0) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}
