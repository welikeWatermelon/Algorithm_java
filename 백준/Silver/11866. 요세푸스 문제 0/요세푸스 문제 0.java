import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람 수
        int K = sc.nextInt(); // K번째 제거

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;

        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size(); // 다음 제거 대상 인덱스
            // K-1 : 시작이 0이니까 -1 해준것
            // index 계속 갱신
            sb.append(list.remove(index));
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
