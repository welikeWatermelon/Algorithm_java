import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 벨트 위에는 같은 종류의 초밥이 둘 이상 있을 수 있다.
// 행사 1. 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
// 행사 2. 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행하고, 1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공 (만약 없을 경우 요리사가 새로 만들어 제공)
// 손님이 먹을 수 있는 초밥 가짓수의 최댓값을 구하라

// 음식 종류 배열을 만들자. menus
// k크기의 창을 만들자
// 창 안에 들어오는 애들을 바탕으로 menus 배열을 증가시키자
// 거기에 쿠폰 번호 음식을 넣어놓자
// 모든 경우를 돌며 (새로운 접시 갈 때 해당 메뉴 +1, 접시 하나 뺄 때 해당 메뉴 -1)
// N(3,000,000) * 2(맨뒤칸 삭제, 맨 앞칸 추가) + 3,000. 절대 10^8(1초)은 나올 수 없음. 그냥 진행해
// 문제는 끝가지 돌고 다시 처음 부분을 봐야할 때임. 그건 구현하면서 생각해보자.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 접시 수 3,000,000
        int d = Integer.parseInt(st.nextToken()); // 초밥 가지 수 3,000
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 개수 3,000
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 3,000 (d보다 작거나 같음)

        // 접시
        int[] dishes = new int[N];

        int[] menus = new int[d + 1];

        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        // k가 N보다 클 수 있으니까 이건 따로 처리해줘야함
        if (k > N) {
            for (int i = 0; i < N; i++) {
                menus[dishes[i]]++;
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (menus[i] != 0) {
                    cnt++;
                }
            }
            System.out.println(cnt);
            return;
        }

        // 현재 나와있는 메뉴들 개수 등록
        for (int i = 0; i < k; i++) {
            menus[dishes[i]]++;
        }

        // 처음 나와있는 것(k개만) 개수 등록
        int cnt = 0;
        for (int i = 0; i <= d; i++) {
            if (menus[i] != 0) {
                cnt++;
            }
        }

        // 쿠폰 등록
        if (menus[c] == 0) {
            cnt++;
        }
        menus[c]++;


        // 현재 최대 메뉴 개수
        int maxMenus = cnt;

        // 순회 할 것
//        int left = 0; // l은 0부터 N-1 까지 가야지 전체 다 도는 것
//        int right = k; // r는 k부터 N까지 갔다가 다시 0으로 가고 K까지 가야지 끝나
        for (int left = 0; left < N; left++) {
            int right = (left + k)%N;
            menus[dishes[left]]--;
            if (menus[dishes[left]] == 0) {
                cnt--;
            }


            if (menus[dishes[right]] == 0) {
                cnt++;
            }
            menus[dishes[right]]++;

            maxMenus = Math.max(maxMenus, cnt);
        }

        System.out.println(maxMenus);

    }
}
