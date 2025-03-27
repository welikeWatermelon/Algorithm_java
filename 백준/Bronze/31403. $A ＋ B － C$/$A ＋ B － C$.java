import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String C = sc.next();
        String answer = "";
        answer += A;
        answer += B;
        String answer2 = "";
        answer2 += C;
        int a = Integer.parseInt(answer) - Integer.parseInt(answer2);
        System.out.println(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C));
        System.out.println(a);
    }
}
