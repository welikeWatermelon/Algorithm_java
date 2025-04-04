import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            switch (tmp[0]) {
                case "push_front":
                    d.addFirst(Integer.parseInt(tmp[1]));
                    break;
                case "push_back":
                    d.addLast(Integer.parseInt(tmp[1]));
                    break;
                case "pop_front":
                    sb.append(d.isEmpty() ? -1 : d.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(d.isEmpty() ? -1 : d.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(d.size()).append("\n");
                    break;
                case "empty":
                    sb.append(d.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(d.isEmpty() ? -1 : d.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(d.isEmpty() ? -1 : d.peekLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
