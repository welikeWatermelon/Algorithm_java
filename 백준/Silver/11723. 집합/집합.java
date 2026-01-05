import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> arr = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("all")) {
                for (int k = 1; k <= 20; k++) arr.add(k);
            } else if (order.equals("empty")) {
                arr.clear();
            } else {
                int num = Integer.parseInt(st.nextToken());

                switch (order) {
                    case "add":
                        arr.add(num);
                        break;
                    case "remove":
                        arr.remove(num);
                        break;
                    case "check":
                        sb.append(arr.contains(num) ? 1 : 0).append("\n");
                        break;
                    case "toggle":
                        if (arr.contains(num)) {
                            arr.remove(num);
                        } else {
                            arr.add(num);
                        }
                        break;
                }
            }
        }
        System.out.print(sb);
    }
}