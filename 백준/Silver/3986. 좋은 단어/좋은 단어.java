import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            Stack<Character> st = new Stack<>();
            if(str.length()%2==1) continue;
            for (int j = 0; j < str.length(); j++) {
                if (st.size() == 0) { //무조건 하나 넣어줘야함
                    st.add(str.charAt(j));
                } else if (st.peek() == str.charAt(j)) {
                    st.pop();
                } else {
                    st.add(str.charAt(j));
                }
            }
            if(st.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}
