import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_5060446 {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<Integer> citiesInArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] roads = new int[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken());
            roads[i][1] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            int city1 = roads[i][0] - 1;
            int city2 = roads[i][1] - 1;

            adj.get(city1).add(city2);
            adj.get(city2).add(city1);
        }

        visited = new boolean[N];
        ArrayList<ArrayList<Integer>> cityGroups = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                citiesInArea = new ArrayList<>();
                calculate(i);
                cityGroups.add(citiesInArea);
            }
        }

        System.out.println(cityGroups.size() - 1);
        for(int i = 0; i + 1 < cityGroups.size(); i++) {
            System.out.println((cityGroups.get(i).get(0) + 1) + " " + (cityGroups.get(i + 1).get(0) + 1));
        }

        out.close();
    }

    public static void calculate(int city) {
        visited[city] = true;
        citiesInArea.add(city);
        for(int i = 0; i < adj.get(city).size(); i++) {
            int nextCity = adj.get(city).get(i);
            if(!visited[nextCity]) {
                calculate(nextCity);
            }
        }
    }
}