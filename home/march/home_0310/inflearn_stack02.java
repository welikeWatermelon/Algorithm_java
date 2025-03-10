package home_0310;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class inflearn_stack02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> st = new Stack<>();
        Stack<Character> answer = new Stack<>();
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c != ')') {
                st.add(c);
            } else {
                while (st.pop() != '(') ;
            }
        }
//
//        while(!st.isEmpty()){
//            answer.add(st.pop());
//        }
//
//        while (!answer.isEmpty()) {
//            System.out.print(answer.pop());
//        }
        for (char c : st) {
            System.out.print(c);
        }
    }
}
