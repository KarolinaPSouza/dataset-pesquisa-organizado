/*
ID: epicpla1
LANG: JAVA
TASK: buildingroads
*/

import java.util.*;
import java.io.*;

public class entry_11321700 {
    public void run() throws Exception {
//        FastScannerbuildingRoads f = new FastScannerbuildingRoads("entry_11321700".toLowerCase() + ".in");
        FastScannerbuildingRoads f = new FastScannerbuildingRoads();

//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("entry_11321700".toLowerCase() + ".out")));
        PrintWriter out = new PrintWriter(System.out);

        ArrayList<Integer> individualClumps = new ArrayList<>();

        int numCities = f.nextInt();
        int numRoads = f.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCities; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i < numRoads; i++){
            int city1 = f.nextInt()-1;
            int city2 = f.nextInt()-1;
            adjList.get(city1).add(city2);
            adjList.get(city2).add(city1);
        }

        boolean[] visited = new boolean[numCities];


        for (int i = 0; i < numCities; i++){
            if (!visited[i]){
                visited[i] = true;
                individualClumps.add(i);

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);

                while (!q.isEmpty()){
                    int cur = q.poll();
                    for (int each:adjList.get(cur)){
                        if (!visited[each]){
                            visited[each] = true;
                            q.offer(each);
                        }
                    }
                }
            }
        }
        out.println(individualClumps.size()-1);
        for (int i = 0; i < individualClumps.size()-1; i++){
            out.println((individualClumps.get(i)+1)+" "+(individualClumps.get(i+1)+1));
        }

        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new entry_11321700().run();
    }
}

class FastScannerbuildingRoads {
    BufferedReader br;
    StringTokenizer st;

    public FastScannerbuildingRoads() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastScannerbuildingRoads(String fileName) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(fileName));
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return (Integer.parseInt(next()));
    }

    long nextLong() {
        return (Long.parseLong(next()));
    }

    double nextDouble() {
        return (Double.parseDouble(next()));
    }

    String nextLine() {
        String str = "";
        try {
            if (st != null && st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
//Property of the One and Only KoKoa_Bean