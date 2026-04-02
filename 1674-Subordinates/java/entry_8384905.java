import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class entry_8384905 {

    static List<List<Integer>> graph;
    static int[] subordinatesCount;
    static boolean[] counted;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        graph = new ArrayList<>();
        subordinatesCount = new int[n + 1];
        counted = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(tokenizer.nextToken());
            graph.get(boss).add(i);
        }

        calculateSubordinatesCount(1);

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(subordinatesCount[i]).append(" ");
        }

        System.out.println(result);
    }

    static void calculateSubordinatesCount(int startEmployee) {
        List<Integer> stack = new ArrayList<>();
        stack.add(startEmployee);

        while (!stack.isEmpty()) {
            int currentEmployee = stack.get(stack.size() - 1);

            if (!counted[currentEmployee]) {
                counted[currentEmployee] = true;

                for (int subordinate : graph.get(currentEmployee)) {
                    stack.add(subordinate);
                }
            } else {
                stack.remove(stack.size() - 1);

                for (int subordinate : graph.get(currentEmployee)) {
                    subordinatesCount[currentEmployee] += (1 + subordinatesCount[subordinate]);
                }
            }
        }
    }
}


