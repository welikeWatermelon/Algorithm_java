import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:                           // push front
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:                           // push back
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:                           // pop front
                    out.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
                    break;
                case 4:                           // pop back
                    out.append(dq.isEmpty() ? -1 : dq.pollLast()).append('\n');
                    break;
                case 5:                           // size
                    out.append(dq.size()).append('\n');
                    break;
                case 6:                           // empty
                    out.append(dq.isEmpty() ? 1 : 0).append('\n');
                    break;
                case 7:                           // front
                    out.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
                    break;
                case 8:                           // back
                    out.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
                    break;
            }
        }
        System.out.print(out.toString());
    }
}
