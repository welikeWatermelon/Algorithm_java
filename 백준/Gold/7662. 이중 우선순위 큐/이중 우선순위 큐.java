import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            // TreeMap은 항상 오름차순

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    // 값 삽입: (값, 개수) 형태로 저장
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else { // op.equals("D")
                    if (map.isEmpty()) continue;

                    // n이 1이면 최댓값(lastKey), -1이면 최솟값(firstKey)
                    int key;
                    
                    if (n == 1) {
                        key = map.lastKey();
                    }else{
                        key = map.firstKey();
                    }

                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                        // 덮어쓰기
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}