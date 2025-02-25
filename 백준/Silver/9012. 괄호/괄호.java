import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split("");
            List<String> strArr = new ArrayList<>(Arrays.asList(str));

            String answer;

            // 만약 ( 개수와 ) 개수가 다르다면 NO 출력후 break
            int left = 0;
            int right = 0;
            for (String s : str) {
                if (s.equals("(")) left++;
                else right++;
            }
            if (left != right) {
                System.out.println("NO");
                continue;
            } else {
                for (int j = 0; j < strArr.size() - 1; j++) {
                    if (strArr.get(j).equals("(") && strArr.get(j + 1).equals(")")) {
                        strArr.remove(j + 1);
                        strArr.remove(j);
                        if (j != 0) {
                            j -= 2;
                            continue;
                        }
                        j -= 1;
                    }
                }
            }

            if (strArr.size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}