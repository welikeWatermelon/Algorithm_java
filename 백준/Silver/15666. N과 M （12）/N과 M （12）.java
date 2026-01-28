import java.util.*;

public class Main {
    public static int N,M;
    public static HashSet<Integer> tmpArr;
    public static List<Integer> arr;
    public static int[] answer;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        tmpArr = new HashSet<>();
        answer = new int[M];

        for (int i = 0; i < N; i++) {
            tmpArr.add(sc.nextInt());
        }

        arr = new ArrayList<>(tmpArr);

        Collections.sort(arr);

        dfs(0, arr.get(0));


        System.out.print(sb);
    }

    public static void dfs(int depth, int startNum) {
        if (depth == M) {
            for (int i = 0; i < M - 1; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append(answer[M - 1]).append("\n");
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (startNum <= arr.get(i)) {
                answer[depth] = arr.get(i);
                dfs(depth + 1,arr.get(i));
            }
        }
    }

}
