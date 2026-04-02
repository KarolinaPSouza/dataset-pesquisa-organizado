import java.io.*;
import java.util.*;

public class entry_3169002 {
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] nodesVisited;
    public static int dfs(int node) {
        nodesVisited[node] = true;
        int visits = 1;
        for (int nodeEnd : adjacencyList[node]) {
            if (!nodesVisited[nodeEnd]) {
                visits += dfs(nodeEnd);
            }
        }
        return visits;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCities = Integer.parseInt(st.nextToken());
        int numRoads = Integer.parseInt(st.nextToken());
        nodesVisited = new boolean[numCities];
        adjacencyList = new ArrayList[numCities];
        for (int i = 0; i < numCities; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numRoads; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        int numVisited = 0;
        int cityCounter = 0;
        int ret = 0;
        ArrayList<Integer> answerPairs = new ArrayList<>();
        while (numVisited < numCities) {
            if (!nodesVisited[cityCounter]) {
                numVisited += dfs(cityCounter);
                ret++;
                answerPairs.add(cityCounter + 1);
            }
            cityCounter++;
        }

//        for (boolean a : nodesVisited) {
//            pw.println(a);
//        }

        pw.println(ret - 1);
        if (answerPairs.size() > 1) {
            for (int i = 1; i < answerPairs.size(); i++) {
                pw.println(answerPairs.get(i-1) + " " + answerPairs.get(i));
            }
        }
        br.close();
        pw.close();
    }
}