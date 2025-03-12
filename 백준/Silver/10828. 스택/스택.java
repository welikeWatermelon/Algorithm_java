import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[10000];
        int idxP = 0; // 스택의 크기 (0이면 empty)

        int N = Integer.parseInt(br.readLine()); // 명령 개수

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" "); // 공백 기준으로 명령어 분리

            String command = input[0];

            if (command.equals("push")) {
                int pushNum = Integer.parseInt(input[1]);
                arr[idxP++] = pushNum;
            } else if (command.equals("top")) {
                sb.append(idxP == 0 ? "-1\n" : arr[idxP - 1] + "\n");
            } else if (command.equals("size")) {
                sb.append(idxP).append("\n");
            } else if (command.equals("empty")) {
                sb.append(idxP == 0 ? "1\n" : "0\n");
            } else if (command.equals("pop")) {
                sb.append(idxP == 0 ? "-1\n" : arr[--idxP] + "\n");
            }
        }

        System.out.print(sb.toString()); // 최종 결과 한 번에 출력
    }
}
