import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] des = {8, 7, 6, 5, 4, 3, 2, 1};

        int flag1 = 0;
        int flag2 = 0;

        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 8; i++) {
            if (arr[i] != asc[i]) {
                flag1 = 1;
                break;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (arr[i] != des[i]) {
                flag2 = 1;
                break;
            }
        }

        if (flag1 == 0) {
            System.out.println("ascending");
        } else if (flag2 == 0) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }




    }
}
