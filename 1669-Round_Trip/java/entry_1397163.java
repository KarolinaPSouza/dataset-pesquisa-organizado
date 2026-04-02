// Imports
import java.util.*;
import java.io.*;

public class entry_1397163 {

    static class Triple {
        public int first;
        public int second;
        public int third;

        public Triple(int f, int s, int t) {
            first = f;
            second = s;
            third = t;
        }
    }

    /**
     * @param args the command line arguments
     * @throws IOException, FileNotFoundException 
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {

        // TODO UNCOMMENT WHEN ALGORITHM CORRECT
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));


        // TODO code application logic here
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // int[] parent = new int[N];
        List<Integer>[] graph = new ArrayList[N];
        int[] dist = new int[N];
        int[] parent = new int[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = -1;
            parent[i] = -1;
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(line.nextToken()) - 1;
            int b = Integer.parseInt(line.nextToken()) - 1;

            graph[a].add(b);
            graph[b].add(a);
        }

        Stack<Triple> dfs = new Stack<>();
        boolean[] visited = new boolean[N];
        int last = 0;

        while(last < N) {
            dfs.add(new Triple(last, -1, -1));
            visited[last] = true;
            dist[last] = 0;
            last++;

            while(!dfs.isEmpty()) {
                Triple curr = dfs.pop();
                int pos = curr.first;
                int par = curr.second;
                int third = curr.third;

                for(int i : graph[pos]) {
                    if(visited[i] && i != par && i != third) {
                        Stack<Integer> left = new Stack<>();
                        Stack<Integer> right = new Stack<>();

                        left.push(i);
                        right.push(pos);

                        while(dist[left.peek()] > dist[right.peek()]) {
                            left.push(parent[left.peek()]);
                        }

                        while(dist[left.peek()] < dist[right.peek()]) {
                            right.push(parent[right.peek()]);
                        }

                        while(!Objects.equals(left.peek(), right.peek())) {
                            // System.out.println("!" + left.peek() + " " + right.peek());
                            left.push(parent[left.peek()]);
                            right.push(parent[right.peek()]);
                        }

                        int[] arr = new int[left.size()];
                        int[] arr2 = new int[right.size()];

                        for(int j = 0; j < arr.length; j++) {
                            arr[j] = left.pop();
                        }

                        for(int k = arr2.length - 1; k >= 0; k--) {
                            arr2[k] = right.pop();
                        }

                        StringBuilder sb = new StringBuilder();
                        for(int l = 0; l < arr.length; l++) {
                            sb.append(arr[l] + 1);
                            sb.append(" ");
                        }

                        for(int l = 0; l < arr2.length; l++) {
                            sb.append(arr2[l] + 1);
                            sb.append(" ");
                        }

                        System.out.println(arr.length + arr2.length);
                        System.out.println(sb);
                        System.exit(0);
                    }
                    else if(!visited[i]) {
                        dfs.add(new Triple(i, pos, par));
                        dist[i] = dist[pos] + 1;
                        parent[i] = pos;
                        visited[i] = true;
                    }
                }

                while(last < N && visited[last]) {
                    last++;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

}