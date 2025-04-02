import java.util.*;

public class Main {
    public static int N;
    public static int[] friends;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 친구 수
        int M = sc.nextInt(); // 친구 관계 수
        int k = sc.nextInt(); // 가지고 있는 수
        friends = new int[N + 1];
        int[] friendsMoney = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            friendsMoney[i] = sc.nextInt();
        }

        setFriends();

        // 친구 합쳐야함
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int to = sc.nextInt();
            union(start, to);
        }

        // 아직 업데이트 안된거 모두 업데이트
        for (int i = 1; i <= N; i++) {
            findFriends(i);
        }

        // 그룹이 나누어졌음
        Set<Integer> set = new HashSet<>(); // 부모 숫자

        // 위에서 (union)에서 경로압축이 되었다고 생각하고 아래의 코드를 진행함
        // ❌ union에서는 경로 압축이 "자동으로 완전히" 되지 않습니다요!!!!
        for (int i = 1; i <= N; i++) {
            set.add(friends[i]);
        }

//        for (int i = 1; i <= N; i++) {
//            findFriends(i);
//        }

        int[] answerArr = new int[set.size()];
        int money=0;
        for (int c : set) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (friends[i] == c) { // 친한친구가 c일 경우 !
                    a.add(friendsMoney[i]); //i 인덱스의 부모가 c임. 그래서 c를 갖고 있는 애들의 비용을 모두 a에 넣어줄거임
                }
            }
            // 그리고 최솟깂 구해줘야함
            money += Collections.min(a);
        }

        if (money > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(money);
        }

    }

    // 친구 설정
    public static void setFriends(){
        for (int i = 1; i <= N; i++) {
            friends[i] = i;
        }
    }

    // 누구랑 친구인지 세팅
    public static int findFriends(int x) {
        if (friends[x] == x) {
            return x;
        }
        return friends[x] = findFriends(friends[x]);
    }

    // 친구들 합치기
    public static void union(int x, int y) {
        int root_x = findFriends(x);
        int root_y = findFriends(y);
        if (root_x < root_y) {
            friends[root_y] = root_x;
        } else {
            friends[root_x] = root_y;
        }
    }
}


// union find를 이용하여 그룹을 나눈다.
// 나눈 그룹내에서 비용이 가장 작은 것을 answer에 더해줌