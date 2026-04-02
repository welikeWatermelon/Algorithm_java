import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static Map<String, String> network;
    public static Map<String, Integer> size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            // Key-Value 로 하면 될듯 Key-이름 / Value - 주인
            network = new HashMap<>();
            size = new HashMap<>();

            for (int f = 0; f < F; f++) {
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();

                if (!network.containsKey(first)) {
                    network.put(first, first);
                    size.put(first, 1);
                }

                if (!network.containsKey(second)) {
                    network.put(second, second);
                    size.put(second, 1);
                }

                union(first, second);
                String parent = find(first);
                String mom = network.get(parent);
                System.out.println(size.get(mom));
            }
        }
    }

    public static String find(String name) {
        if (name.equals(network.get(name))) {
            return name;
        }
        String root = find(network.get(name));
        network.put(name,root);
        return root;
    }

    public static void union(String name1, String name2) {
        name1 = find(name1);
        name2 = find(name2);

        if (!name1.equals(name2)) {
            network.put(name2,name1);
            size.put(name1, size.get(name1) + size.get(name2));
        }
    }
}
