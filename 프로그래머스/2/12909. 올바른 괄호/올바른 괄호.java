import java.util.Stack;

class Solution {
    boolean solution(String s) {
        int len = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            st.push(s.charAt(i));
        }

        int cnt = 0;
        boolean flag = true;
        
        while (!st.empty()) {
            if (st.peek() == ')') {
                st.pop();
                cnt++;
            } else if (st.peek() == '(' && cnt > 0) {
                st.pop();
                cnt--;
            } else {
                flag = false;
                break;
            }
        }
        
        if(cnt>0) flag=false;

        return flag;
    }
}