import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String num = sc.next();
            if (Integer.parseInt(num) == 0) break;
            int left = 0;
            int right = num.length() - 1;
            int flag = 0;

            while (left <= right) {
                if (num.charAt(left) == num.charAt(right)) {
                    left++;
                    right--;
                    flag = 1;
                }else{
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
