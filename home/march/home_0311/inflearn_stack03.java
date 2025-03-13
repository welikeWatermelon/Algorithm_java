package home_0311;

import java.util.Scanner;
import java.util.Stack;

public class inflearn_stack03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> st = new Stack<>();

        String str = sc.next();
        for (String c : str.split("")) {
            if (!c.equals("+") && !c.equals("/") && !c.equals("*") && !c.equals("-")) {
                st.add(c);
            } else {
                if (c.equals("+")) {
                    int b = Integer.parseInt(st.pop().toString());
                    int a = Integer.parseInt(st.pop().toString());
                    int answer = a+b;
                    st.add(String.valueOf(answer));
                }else if (c.equals("-")) {
                    int b = Integer.parseInt(st.pop().toString());
                    int a = Integer.parseInt(st.pop().toString());
                    int answer = a-b;
                    st.add(String.valueOf(answer));
                } else if (c.equals("*")) {
                    int b = Integer.parseInt(st.pop().toString());
                    int a = Integer.parseInt(st.pop().toString());
                    int answer = a * b;
                    st.add(String.valueOf(answer));
                } else {
                    int b = Integer.parseInt(st.pop().toString());
                    int a = Integer.parseInt(st.pop().toString());
                    int answer = a / (int)b;
                    st.add(String.valueOf(answer));
                }
            }
        }

        System.out.println(st.pop());


    }
}
