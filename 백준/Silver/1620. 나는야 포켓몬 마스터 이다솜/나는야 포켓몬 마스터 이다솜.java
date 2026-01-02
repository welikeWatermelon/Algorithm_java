import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> nameToNum = new HashMap<>();
        String[] numToName = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            String idx = String.valueOf(i);
            nameToNum.put(name, idx);
            numToName[i] = name;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String query = br.readLine();

            if (Character.isDigit(query.charAt(0))) {
                int idx = Integer.parseInt(query);
                sb.append(numToName[idx]).append("\n");
            } else {
                sb.append(nameToNum.get(query)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
