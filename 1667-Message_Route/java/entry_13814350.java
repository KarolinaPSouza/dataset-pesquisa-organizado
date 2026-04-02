//package cses.graph;

import java.io.*;
import java.util.*;

public class entry_13814350 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        HashMap<Integer, List<Integer>> connections = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            List<Integer> next = connections.getOrDefault(u, new ArrayList<>());
            next.add(v);
            connections.put(u, next);

            next = connections.getOrDefault(v, new ArrayList<>());
            next.add(u);
            connections.put(v, next);
        }

        List<Integer> result = isReachable(connections, 1, n);
        if(result == null) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result.size());
            StringBuilder builder = new StringBuilder();
            for(int p : result) {
                if(builder.length() == 0) {
                    builder.append(p);
                } else {
                    builder.append(" ").append(p);
                }
            }
            System.out.println(builder);
        }
    }

    static class Entry {
        ArrayList<Integer> path;
        int node;

        public Entry(int i, ArrayList<Integer> es) {
            this.node = i;
            path = es;
        }
    }

    private static ArrayList<Integer> isReachable(HashMap<Integer, List<Integer>> connections, int start, int end) {
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);
        parent.put(start, -1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) break;

            for (int next : connections.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, current);
                    queue.offer(next);
                }
            }
        }

        if (!parent.containsKey(end)) return null;

        ArrayList<Integer> path = new ArrayList<>();
        int current = end;
        while (current != -1) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);
        return path;
    }

}