import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 듣도 못한 사람을 HashSet에 저장 (탐색 O(1))
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        // 2. 보도 못한 사람을 확인하며 교집합 찾기
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                result.add(name);
            }
        }

        // 3. 사전순 정렬 (문제 조건)
        Collections.sort(result);

        // 4. 출력 최적화
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}