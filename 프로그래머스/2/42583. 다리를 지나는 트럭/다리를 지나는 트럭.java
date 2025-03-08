import java.util.*;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>(); // 다리 위 트럭 상태 (큐)
        Queue<Integer> waiting = new LinkedList<>(); // 대기 중인 트럭

        for (int truck : truck_weights) {
            waiting.add(truck);
        }

        int time = 0; // 경과 시간
        int currentWeight = 0; // 다리 위 총 무게

        // 다리 길이만큼 0을 채워놓음 (트럭이 없는 상태)
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (!waiting.isEmpty() || currentWeight > 0) {
            time++;

            // 다리에서 트럭이 나감
            currentWeight -= bridge.poll();

            // 새로운 트럭이 다리에 올라갈 수 있는지 확인
            if (!waiting.isEmpty() && currentWeight + waiting.peek() <= weight) {
                int newTruck = waiting.poll();
                bridge.add(newTruck);
                currentWeight += newTruck;
            } else {
                bridge.add(0); // 다리가 비어 있는 공간 유지
            }
        }

        return time;
    }
}