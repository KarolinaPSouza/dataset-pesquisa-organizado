import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_7164152 {
    static final long INFINITY = (long) Math.pow(10, 18);

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new PrintStream(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int numCities = Integer.parseInt(st.nextToken());
        int numRoads = Integer.parseInt(st.nextToken());
        int numQueries = Integer.parseInt(st.nextToken());

        long[][] minDistance = new long[numCities][numCities];
        for (int i = 0; i < numCities; i++) {
            Arrays.fill(minDistance[i], INFINITY);
        }

        for (int i = 0; i < numRoads; i++) {
            st = new StringTokenizer(in.readLine());
            int cityA = Integer.parseInt(st.nextToken()) - 1;
            int cityB = Integer.parseInt(st.nextToken()) - 1;
            long roadLength = Integer.parseInt(st.nextToken());

            minDistance[cityA][cityB] = minDistance[cityB][cityA]
                = Math.min(minDistance[cityA][cityB], roadLength);
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < numCities; k++) {
            for (int i = 0; i < numCities; i++) {
                for (int j = i + 1; j < numCities; j++) {
                    long newDistance = minDistance[i][k] + minDistance[k][j];
                    if (newDistance < minDistance[i][j]) {
                        minDistance[i][j] = minDistance[j][i] = newDistance;
                    }
                }
            }
        }

        for (int i = 0; i < numQueries; i++) {
            st = new StringTokenizer(in.readLine());
            int cityA = Integer.parseInt(st.nextToken()) - 1;
            int cityB = Integer.parseInt(st.nextToken()) - 1;

            // Check if the two nodes are the same or can't reach each other
            if (cityA == cityB) {
                minDistance[cityA][cityB] = 0;
            } else if (minDistance[cityA][cityB] == INFINITY) {
                minDistance[cityA][cityB] = -1;
            }

            out.println(minDistance[cityA][cityB]);
        }
        in.close();
        out.close();
    }
}