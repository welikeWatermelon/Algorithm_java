import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashSet<String> hs = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) {
                hs.add(name);
            } else {
                hs.remove(name);
            }
        }

        List<String> list = new ArrayList<>(hs);

        Collections.sort(list, Collections.reverseOrder());

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }
}
