import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int tmp = sc.nextInt();
            if (set.contains(tmp)) {
                sb.append(1+"\n");
            } else {
                sb.append(0+"\n");
            }
        }
        System.out.print(sb);
    }
}
