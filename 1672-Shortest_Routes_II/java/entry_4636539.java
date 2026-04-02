import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_4636539 {
    public static void main(String[] args) throws IOException {
        long time_1 = System.nanoTime();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        // reader = new BufferedReader(new FileReader("test_input.txt"));
        StringTokenizer st = new StringTokenizer(reader.readLine());


        int numCities = Integer.parseInt(st.nextToken());
        int numRoads = Integer.parseInt(st.nextToken());
        int numQueries = Integer.parseInt(st.nextToken());

        long[][] distances = new long[numCities][numCities];
        for(int i = 0; i<distances.length; i++){
            for(int j = 0; j<distances.length; j++){
                if(i == j) distances[i][j] = 0;
                else distances[i][j] = Long.MAX_VALUE;
            }
        }
        for(int i = 0; i<numRoads; i++){
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            distances[from-1][to-1] = Math.min(distances[from-1][to-1], weight);
            distances[to-1][from-1] =  Math.min(distances[to-1][from-1], weight);
        }

        for(int v = 0; v<distances.length; v++){
            for(int i = 0; i<distances.length; i++){
                for(int j = 0; j<distances.length; j++){
                    if(distances[i][v] == Long.MAX_VALUE || distances[v][j] == Long.MAX_VALUE) continue;
                    if(distances[i][j] > distances[i][v]+distances[v][j]){
                        distances[i][j] = distances[i][v]+distances[v][j];
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<numQueries; i++){
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            res.append(distances[from-1][to-1] == Long.MAX_VALUE ? -1 : distances[from-1][to-1]);
            if(i != numQueries-1) res.append('\n');
        }
        System.out.println(res.toString());
        long time_2 = System.nanoTime();
        // System.out.println("\nTime: ");
        // System.out.println(String.valueOf((time_2-time_1)/1000000));
    }
}