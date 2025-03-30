import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Member implements Comparable<Member> {
        int age;
        String name;
        int order; // 가입 순서

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        @Override
        public int compareTo(Member other) {
            if (this.age != other.age) {
                return this.age - other.age; // 나이 오름차순
            } else {
                return this.order - other.order; // 가입 순서 오름차순
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Member[] members = new Member[N];
        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members[i] = new Member(age, name, i);
        }

        Arrays.sort(members);

        for (int i = 0; i < N; i++) {
            System.out.println(members[i].age + " " + members[i].name);
        }
    }
}
