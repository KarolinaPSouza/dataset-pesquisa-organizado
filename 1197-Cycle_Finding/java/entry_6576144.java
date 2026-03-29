//package com.rajan.cses.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class entry_6576144 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int[] temp = parseInt(reader.readLine(), 2);
        int n = temp[0], m = temp[1];
        List<int[]> graph[] = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        List<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] edge = parseInt(reader.readLine(), 3);
            int a = edge[0], b = edge[1], w = edge[2];
            graph[a].add(new int[]{b, w});
            edgeList.add(edge);
        }

        long[] initialDistance = new long[n + 1];
        Arrays.fill(initialDistance, Long.MAX_VALUE / 2L);
        initialDistance[1] = 0L;
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            for (int[] e : edgeList) {
                int a = e[0], b = e[1], w = e[2];
                if (initialDistance[b] > initialDistance[a] + w) {
                    initialDistance[b] = initialDistance[a] + w;
                    parent[b] = a;
                }
            }
        }
        int cycleNode = -1;
        for(int[] e: edgeList){
            int a=e[0], b=e[1], w=e[2];
            long newDistance=initialDistance[a]+w;
            if(newDistance<initialDistance[b]){
                cycleNode=b;
                break;
            }
        }
        if (cycleNode > 0) {
            List<Integer> cycle = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (parent[cycleNode] > 0) {
                    cycleNode = parent[cycleNode];
                }
            }
            for (int i = cycleNode; ; i = parent[i]) {
                cycle.add(i);
                if (i == cycleNode && cycle.size() > 1) {
                    break;
                }
            }
            writer.write("YES\n");
            for (int i = cycle.size() - 1; i >= 0; i--) {
                writer.write((i == cycle.size() - 1 ? "" : " ") + cycle.get(i));
            }
            writer.write("\n");
        } else {
            writer.write("NO\n");
        }
        writer.flush();
    }

    private static void printArray(int[] nums) throws java.lang.Exception {
        for (int i = 0; i < nums.length; i++) {
            writer.write((i == 0 ? "" : " ") + nums[i]);
        }
        writer.write("\n");
    }

    private static void printArray(long[] nums) throws java.lang.Exception {
        for (int i = 0; i < nums.length; i++) {
            writer.write((i == 0 ? "" : " ") + nums[i]);
        }
        writer.write("\n");
    }

    private static int[] parseInt(String str) {
        String[] parts = str.split("\\s+");
        int[] ans = new int[parts.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.parseInt(parts[i]);
        }
        return ans;
    }

    private static long[] parseLong(String str) {
        String[] parts = str.split("\\s+");
        long[] ans = new long[parts.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Long.parseLong(parts[i]);
        }
        return ans;
    }

    private static int[] parseInt(String str, int n) {
        int[] ans = new int[n];
        int idx = 0;
        for (int k = 0; k < str.length(); ) {
            int j = k;
            int sum = 0;
            while (j < str.length() && str.charAt(j) != ' ') {
                if (str.charAt(j) == '-') {
                    j++;
                    continue;
                }
                sum = sum * 10 + str.charAt(j) - '0';
                j++;
            }
            ans[idx++] = (str.charAt(k) == '-' ? -1 : 1) * sum;
            k = j + 1;
        }
        return ans;
    }
}