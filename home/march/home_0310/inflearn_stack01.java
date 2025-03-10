package home_0310;

import java.util.Scanner;
import java.util.Stack;

public class inflearn_stack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> st = new Stack<>();
        boolean flag = true;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                st.add('(');
            } else {
                if (st.isEmpty()) {
                    System.out.println("NO");
                    flag = false;
                    break;
                } else {
                    st.pop();
                }
            }
        }

        if(flag){
            if (st.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }
}
