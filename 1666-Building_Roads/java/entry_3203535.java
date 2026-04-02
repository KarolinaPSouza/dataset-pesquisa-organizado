import java.util.*;
import java.io.*;
public class entry_3203535 {
    public static void main(String[] args) throws Exception {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(s.readLine());
        int v = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
        int[] components = new int[v];
        boolean[] visited = new boolean[v];


        for (int i = 0; i < v; i++) {
            components[i] = -1;
        }


        for (int i = 0; i < v; i++) {
            nodes.add(new ArrayList<Integer>());
        }



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(s.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;

            nodes.get(src).add(dest);
            nodes.get(dest).add(src);

        }

        for (int i = 0; i < v; i++) {

            if (components[i] == -1) {
                int fC = i;
                dfs(nodes, i, visited, fC, components);

            }

        }
        HashSet<Integer> cities = new HashSet<Integer>();

        for (int i = 0; i < v; i++) {

            if (!cities.contains(components[i] + 1)) {

                cities.add((i + 1));
            }
        }

        int index = 0;
        int roads = cities.size() - 1;
        w.println(roads);

        int[] citiesArr = new int[cities.size()];
        for (int x: cities) {
            citiesArr[index] = x;
            index++;
        }

        for (int i = 0; i < citiesArr.length - 1; i++) {
            int c1 = citiesArr[i];
            int c2 = citiesArr[i + 1];
            w.println(c1 + " " + c2);
        }


        w.close();





    }

    public static void dfs(ArrayList<ArrayList<Integer>> nodes, int vertex, boolean[] visited, int fC, int[] components) {
        components[vertex] = fC; 
        visited[vertex] = true;


        for (int x: nodes.get(vertex)) {
            if (!visited[x]) {
                dfs(nodes, x, visited, fC, components);
            }
        }


    }


}

