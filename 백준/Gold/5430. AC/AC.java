import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<String> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");
            while (st.hasMoreTokens()) {
                deque.add(st.nextToken());
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char cmd : command.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else { // 'D'인 경우
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    // 뒤집힌 상태에 따라 앞이나 뒤에서 삭제
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
