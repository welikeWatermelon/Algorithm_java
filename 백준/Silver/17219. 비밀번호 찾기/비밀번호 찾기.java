import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소 수
        int M = Integer.parseInt(st.nextToken()); // 찾으려는 사이트 주소 수

        // 사이트 주소(Key)와 비밀번호(Value)를 저장할 HashMap 생성
        Map<String, String> passwordMap = new HashMap<>();

        // N개의 사이트와 비밀번호 입력 및 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            passwordMap.put(site, password);
        }

        // 결과 출력을 한 번에 모아서 하기 위한 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // M개의 쿼리에 대해 비밀번호 찾기
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            sb.append(passwordMap.get(query)).append("\n");
        }

        // 최종 결과 출력
        System.out.print(sb.toString());
    }
}