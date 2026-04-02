import java.io.*;
import java.util.*;
public class entry_1919646 {

    public static void main (String [] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        PrintWriter out = new PrintWriter(System.out);

        int N = Integer.parseInt(st.nextToken());    
        //variables
        long prefix[] = new long[N+1];
        long sum = 0;
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            sum += a; prefix[i+1] = sum;
        }
        //System.out.println(Arrays.toString(prefix));
        long min = prefix[0], max = Integer.MIN_VALUE;
        for(int i = 1; i < N+1; i++){
            max = Math.max(max, prefix[i] - min);
            min = Math.min(min, prefix[i]);
        }
        out.println(max);
        out.close();
    }

}
