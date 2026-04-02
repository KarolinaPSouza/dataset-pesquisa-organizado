//package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class entry_13814647 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        HashMap<Integer, List<Integer>> friends = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            List<Integer> next = friends.getOrDefault(u, new ArrayList<>());
            next.add(v);
            friends.put(u, next);

            next = friends.getOrDefault(v, new ArrayList<>());
            next.add(u);
            friends.put(v, next);
        }

        int[] colors = new int[n + 1];
        boolean possible = true;
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                colors[i] = 1;
                possible &= startColoring(colors, i, friends, 1);
            }
        }
        if(possible) {
           StringBuilder builder = new StringBuilder();
           for(int i = 1; i < colors.length; i++) {
               if(i > 1) builder.append(" ");
               builder.append(colors[i]);
           }
           System.out.println(builder);
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }

    private static boolean startColoring(int[] colors, int node,
                                         HashMap<Integer, List<Integer>> friends, int color) {

        boolean result = true;

        for(int next : friends.getOrDefault(node, new ArrayList<>())) {
            if(colors[next] == color) {
                return false;
            }

            if(colors[next] == 0) {
                colors[next] = color == 1 ? 2 : 1;
                result = result && startColoring(colors, next, friends, color == 1 ? 2 : 1);
            }
        }

        return result;
    }
}