import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[] str;
    public static String[] answer;
    public static int L,C;
    public static int moem, jaem;
    public static ArrayList<String> ans;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        answer = new String[L];
        str = new String[C];
        String s = sc.nextLine();
        str = s.split(" ");
        Arrays.sort(str);
        moem = 0;
        jaem = 0;
        ans = new ArrayList<>();
        comb(0, 0);
        for (int i = 0; i < ans.size()-1; i++) {
            System.out.println(ans.get(i));
        }
        System.out.print(ans.get(ans.size()-1));
    }

    // idx : 원래 배열의 인덱스값
    // sidx : 정답 배열의 인덱스 값

    public static void comb(int idx, int sidx) {
        if (sidx == L) {
            if (moem >= 1 && jaem >= 2) {
                String tmpAns = "";
                for (String c : answer) {
                    tmpAns+=c;
                }
                ans.add(tmpAns);
                return;
            }
            return;
        }

        if (idx == C) {
            return;
        }

        answer[sidx] = str[idx];
        if (str[idx].equals("a") ||
                str[idx].equals("e") ||
                str[idx].equals("i") ||
                str[idx].equals("o") ||
                str[idx].equals("u")) {
            moem++;
        } else {
            jaem++;
        }
        comb(idx + 1, sidx + 1);
        if (str[idx].equals("a") ||
                str[idx].equals("e") ||
                str[idx].equals("i") ||
                str[idx].equals("o") ||
                str[idx].equals("u")) {
            moem--;
        } else {
            jaem--;
        }
        comb(idx + 1, sidx);
    }
}
