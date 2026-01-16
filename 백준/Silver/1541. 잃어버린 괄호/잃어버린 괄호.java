import java.util.Enumeration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] minusGroup = str.split("-");

        int total = Integer.MAX_VALUE;

        for (int i = 0; i < minusGroup.length; i++) {
            int tempSum = 0;

            String[] plusGroup = minusGroup[i].split("\\+");

            for (String s : plusGroup) {
                tempSum += Integer.parseInt(s);
            }

            if (total == Integer.MAX_VALUE) {
                total = tempSum;
            } else {
                total -= tempSum;
            }
        }

        System.out.println(total);
    }
}
