import java.util.*;
import java.io.*;
public class entry_6941502 {
    static int finalDistance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        finalDistance = 0;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            list[first].add(second);
            list[second].add(first);
        }
        int current = findLongestDist(0, list);
        findLongestDist(current, list);
        System.out.println(finalDistance);
    }

    public static int findLongestDist(int vertex, ArrayList<Integer>[] list) {
        boolean[] visited = new boolean[list.length];
        Stack<Dist> stack = new Stack<>();
        stack.add(new Dist(0, vertex));
        int finVal = 0;
        int finDist = Integer.MIN_VALUE;
        while (stack.size() != 0) {
            Dist cur = stack.pop();
            int curVal = cur.val;
            int dist = cur.dist;
            if (visited[curVal]) {
                continue;
            }
            visited[curVal] = true;
            if (dist > finDist) {
                finVal = curVal;
                finDist = dist;
            }
            for (int value : list[curVal]) {
                stack.add(new Dist(dist + 1, value));
            }
        }
        finalDistance = finDist;
        return finVal;
    }

    static class Dist {
        int dist;
        int val;
        public Dist(int dist, int val) {
            this.dist = dist;
            this.val = val;
        }
    }
}