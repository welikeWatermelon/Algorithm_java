import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] parent;
    public static void main(String[] args) {
        // 거짓으로 알려 지지 않는게 목표
        // 과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구하는게 목표
        // 거짓이 되는 조건
        // 1. 맨 처음 진실을 아는 사람들에게 거짓말을 쳤을 때
        // 2. 1번을 피해 구라를 쳤더라도 다른 파티에서 구라를 치고, 그 다음 파티에서 구라를 칠 때, 전의 파티에 있었던 사람이 있으면 걸림

        // 어떤 파티에, 1번(진실을 아는 사람들)이 있어서 진실을 말했을 때, 그 사람들은 모두 진실을 아는 사람에 추가해야함
        // 어떤 파티에, 1번 사람들이 없다면, 구라를 쳐도됨. <A>
        // 근데 구라를 안치고 진실을 말하고, 다른 파티에서 구라를 쳐도 됨.

        // 이건 그래프로 풀어야함
        // 그래프가 얼마나 끊어져 있는지에 따라 구라를 칠 수 있는 상황이 주어짐

        // 그래프로 진실을 아는 사람들을 모두 연관 지은 뒤, 각 파티에서 해당(진실을 아는) 사람이 있는지 없는지에 대한 내용을 체크해서, 최대 수를 구한다.
        
        // 그룹을 나눌 때, A-B 가 같은 파티이고 B-A도 같은 파티라면 이건 유니온파인드로 + 순서가 중요하지 않음 + 전염성
        // 


            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt(); // 사람 수
            int M = sc.nextInt(); // 파티 수

            // 1. 유니온 파인드 초기화
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) parent[i] = i;

            // 2. 진실을 아는 사람 정보 입력
            int numTruth = sc.nextInt();
            if (numTruth == 0) {
                System.out.println(M); // 진실을 아는 사람이 없으면 모든 파티에서 구라 가능
                return;
            }

            int[] truthPeople = new int[numTruth];
            for (int i = 0; i < numTruth; i++) {
                truthPeople[i] = sc.nextInt();
            }

            // 3. 파티 정보 입력 및 사람들을 같은 집합으로 묶기 (Union)
            List<Integer>[] parties = new ArrayList[M];
            for (int i = 0; i < M; i++) {
                parties[i] = new ArrayList<>();
                int partySize = sc.nextInt();

                int firstPerson = sc.nextInt();
                parties[i].add(firstPerson);

                for (int j = 1; j < partySize; j++) {
                    int nextPerson = sc.nextInt();
                    parties[i].add(nextPerson);
                    union(firstPerson, nextPerson); // 같은 파티 사람들끼리 연관지음
                }
            }

            // 4. 각 파티를 돌며 "진실을 아는 사람"과 같은 그룹인지 체크
            int count = 0;
            for (int i = 0; i < M; i++) {
                boolean canLie = true;
                for (int person : parties[i]) {
                    if (isRelatedToTruth(person, truthPeople)) {
                        canLie = false;
                        break;
                    }
                }
                if (canLie) count++;
            }

            System.out.println(count);
        }

        // 부모를 찾는 find 함수 (경로 압축)
        public static int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        // 두 집합을 합치는 union 함수
        public static void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
            }
        }

        // 특정 사람이 진실 그룹과 연결되어 있는지 확인
        public static boolean isRelatedToTruth(int person, int[] truthPeople) {
            int rootPerson = find(person);
            for (int truth : truthPeople) {
                if (rootPerson == find(truth)) return true;
            }
            return false;
        }
    }
