package src.string;


import java.util.Scanner;

public class str1_3 {
    public String solution(String str){
        String answer = "";
        int max = 0;
        String[] words = str.split(" ");
        for (String word : words) {
            if (word.length() > max) {
                max = word.length();
                answer = word;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        str1_3 main = new str1_3();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(main.solution(str));
    }
}
