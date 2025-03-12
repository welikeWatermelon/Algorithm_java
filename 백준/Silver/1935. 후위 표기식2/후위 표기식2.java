import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 피연산자 개수
        sc.nextLine();
        String str = sc.nextLine(); //전체 식
        Stack<Double> st = new Stack<>();
        int[] numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }

        //======================================
        //로직


        HashMap<Character, Integer> map = new HashMap<>();
        // HashMap<Character, Integer>로 받아
        // for문으로 HashMap을 채워줘
        // Character는 A : 65
        int firstchar = 64;
        for (int i = 0; i < N; i++) {
            char tmpChar = (char)(++firstchar);
            map.put(tmpChar, numArr[i]);
        }



        // 스택에 넣는 과정
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) != '*' && str.charAt(i) != '/' && str.charAt(i) != '+' && str.charAt(i) != '-') {
                st.add((double)(map.get(str.charAt(i))));
                //str.charAt(i) : i번째 문자를 얻었어
                //map.get(c) : c의 벨류값 얻어 -> 스택에 들어갈 숫자
            } else if (str.charAt(i) == '*') {
                double b = st.pop();
                double a = st.pop();
                st.add(a * b);
            }else if (str.charAt(i) == '/') {
                double b = st.pop();
                double a = st.pop();
                st.add(a / b);
            }else if (str.charAt(i) == '+') {
                double b = st.pop();
                double a = st.pop();
                st.add(a + b);
            }else {
                double b = st.pop();
                double a = st.pop();
                st.add(a - b);
            }
        }

        System.out.printf("%.2f",st.pop());
    }//백준 제출용
}