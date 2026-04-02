import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class entry_9185994 {

}

class Solution {
    int N, M;

    ArrayList<ArrayList<Integer>> adjList;
    ArrayList<Integer> parent;
    ArrayList<Boolean> hasVisit;
    ArrayList<Integer> answer;

    Solution() {}

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solve();
    }

    void scanInput() throws IOException {
        String[] line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        line = reader.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int source, target;
            line = reader.readLine().split(" ");
            source = Integer.parseInt(line[0]) - 1;
            target = Integer.parseInt(line[1]) - 1;
            adjList.get(source).add(target);
            adjList.get(target).add(source);
        }
    }

    void constructAnswer(int startNode) {
        answer = new ArrayList<>();
        answer.add(startNode);

        int node = parent.get(startNode);
        while (node != startNode) {
            answer.add(node);
            node = parent.get(node);
        }

        answer.add(node);
    }

    void dfs(int node, int parentNode) {
        if (hasVisit.get(node)) {
            constructAnswer(node);
            return;
        }

        hasVisit.set(node, true);

        for (int adjNode : adjList.get(node)) {
            if (adjNode == parentNode) {
                continue;
            }
            if (answer != null) {
                return;
            }
            parent.set(adjNode, node);
            dfs(adjNode, node);
        }
    }

    void solve() throws IOException {
        scanInput();

        hasVisit = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            hasVisit.add(false);
        }

        parent = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            parent.add(-1);
        }

        answer = null;

        for (int i = 0; i < N; i++) {
            if (hasVisit.get(i)) {
                continue;
            }
            dfs(i, -1);
        }

        if (answer == null) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer.size());
            for (int node : answer) {
                System.out.print((node + 1) + " ");
            }
            System.out.println();
        }
    }
}
