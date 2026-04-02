//package csProblems;

import java.io.*;
import java.util.*;

public class entry_15966077 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cityA = Integer.parseInt(st.nextToken());
            int cityB = Integer.parseInt(st.nextToken());
            list.get(cityA).add(cityB);
            list.get(cityB).add(cityA);
        }

        br.close();
        helper(n, list);
    }

    private static void helper(int n, List<List<Integer>> list) {
        boolean[] visited = new boolean[n + 1];
        List<Integer> componentsStarting = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                componentsStarting.add(i);
                dfs(i, visited, list);
            }
        }

        System.out.println(componentsStarting.size() - 1);
        for (int i = 0; i < componentsStarting.size() - 1; i++) {
            System.out.println(componentsStarting.get(i) + " " + componentsStarting.get(i + 1));
        }
    }

    private static void dfs(int i, boolean[] visited, List<List<Integer>> list) {
        visited[i] = true;
        for (int n : list.get(i)) {
            if (!visited[n]) {
                dfs(n, visited, list);
            }
        }
    }
}
