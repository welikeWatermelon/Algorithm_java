import java.util.*;

public class Main {
    public static class HomeWork implements Comparable<HomeWork> {
        int day;
        int score;

        public HomeWork(int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(HomeWork o) {
            // 점수 높은 순 정렬
            return o.score - this.score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<HomeWork> list = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            int d = sc.nextInt();
            int s = sc.nextInt();
            list.add(new HomeWork(d, s));
            maxDay = Math.max(maxDay, d);
        }

        // 점수 높은 순 정렬
        Collections.sort(list);

        boolean[] days = new boolean[maxDay + 1]; // 날짜 사용 여부
        int result = 0;

        for (HomeWork hw : list) {
            for (int d = hw.day; d >= 1; d--) {
                if (!days[d]) {
                    days[d] = true;
                    result += hw.score;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
