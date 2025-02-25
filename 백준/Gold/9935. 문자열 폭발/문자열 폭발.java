
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String removeStr = br.readLine();
        int strLen = str.length();
        int removeStrLen = removeStr.length();

        Stack<Character> stack = new Stack<>();
        StringBuilder allall = new StringBuilder(); //전체 문자열

        for (int i = 0; i < strLen; i++) { //스택 쌓아주는 과정, 쌓아주면서 비교할거임
            stack.push(str.charAt(i));

            if (stack.size() >= removeStrLen) {
                int cnt = 0;
                for (int j = 0; j<removeStrLen ; j++) {
                    if (stack.get(stack.size()-removeStrLen+j) == removeStr.charAt(j)) {
                        cnt++;
                    }else{
                        break;
                    }
                }
                if (cnt == removeStrLen) {
                    for (int j = 0; j < removeStrLen; j++) {
                        stack.pop();
                    }
                }
            }

        }

        for (int i = 0; i < stack.size(); i++) {
            allall.append(stack.get(i));
        }



        if (allall.length() != 0) {
            System.out.println(allall);
        } else {
            System.out.println("FRULA");
        }

    }
}