// Imports
import java.util.*;
import java.io.*;

public class entry_592899 {

    /**
     * @param args the command line arguments
     * @throws IOException, FileNotFoundException 
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {

        // TODO UNCOMMENT WHEN ALGORITHM CORRECT
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));


        // TODO code application logic here
        int N = Integer.parseInt(f.readLine());

        int[] enter = new int[N];
        int[] exit = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());

            enter[i] = Integer.parseInt(st.nextToken());
            exit[i] = Integer.parseInt(st.nextToken());
        }

        Random rand = new Random();

        for (int i = 0; i < enter.length; i++) {
                int randomIndexToSwap = rand.nextInt(enter.length);
                int temp = enter[randomIndexToSwap];
                enter[randomIndexToSwap] = enter[i];
                enter[i] = temp;
        }

        Arrays.sort(enter);

        for (int i = 0; i < exit.length; i++) {
                int randomIndexToSwap = rand.nextInt(exit.length);
                int temp = exit[randomIndexToSwap];
                exit[randomIndexToSwap] = exit[i];
                exit[i] = temp;
        }

        Arrays.sort(exit);

        int start = 0;
        int start2 = 0;
        int running = 0;
        int max = 0;

        while(start < N || start2 < N) {
            // System.out.println(running);
            max = Math.max(running, max);
            if(start >= N) {
                running--;
                start2++;
            }
            else if(start2 >= N) {
                running++;
                start++;
            }
            else if(enter[start] > exit[start2]) {
                running--;
                start2++;
            }
            else if(enter[start] < exit[start2]) {
                running++;
                start++;
            }
            else {
                // shouldnt happen
                start++;
                start2++;
            }
        }
        max = Math.max(running, max);

        System.out.println(max);
    }

}