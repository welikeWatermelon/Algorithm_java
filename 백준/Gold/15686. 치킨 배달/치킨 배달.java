import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int minChicken = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static ArrayList<int[]> chickenCombinationList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<int[]> chickenList = new ArrayList<>();
        ArrayList<int[]> homeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = sc.nextInt();
                if (tmp == 2) {
                    chickenList.add(new int[]{i, j});
                } else if (tmp == 1) {
                    homeList.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chickenList.size()];


        combinationChicken(M, 0, 0,chickenList, homeList);

        System.out.println(minChicken);

        // 치킨집 중 M개를 뽑는 조합
        // 각 조합마다 치킨거리를 재는 것

    }

    public static void combinationChicken(int M, int cnt,int start, ArrayList<int[]> chickenList, ArrayList<int[]> homeList) {
        if (M == cnt) {

            int tmpMin = measureChickenDist(visited, homeList, chickenList);

            // 최소 치킨 거리 업데이트
            minChicken = Math.min(minChicken, tmpMin);
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                combinationChicken(M, cnt + 1, i+1, chickenList, homeList);
                visited[i] = false;
            }
        }
    }

    public static int measureChickenDist(boolean[] visited, ArrayList<int[]> homeList, ArrayList<int[]> chickenList){
        int minDist = 0;
        for (int i = 0; i < homeList.size(); i++) {
            int tmpMin = Integer.MAX_VALUE;
            int[] nowHome = homeList.get(i);
            int homeX = nowHome[0];
            int homeY = nowHome[1];
            for (int j = 0; j < visited.length; j++) {
                if (visited[j]) {
                    int[] nowChicken = chickenList.get(j);
                    int chickenX = nowChicken[0];
                    int chickenY = nowChicken[1];

                    tmpMin = Math.min(tmpMin, Math.abs(homeX - chickenX) + Math.abs(homeY - chickenY));
                }
            }
            minDist += tmpMin;
        }

        return minDist;
    }
}
