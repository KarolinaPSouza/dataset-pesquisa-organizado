import java.util.*;
import java.io.*;
public class entry_1848124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // read all times, put into array and set to see if alrdy exists
        // sort array at end to find corresponding index. 
        // get a prefix array of that arraylist size + 1. int[] prefix = new int[size];
        // put all the x and y into prefix, compute. find max. 
        int[] come = new int[N];
        int[] leave = new int[N];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            come[i] = Integer.parseInt(st.nextToken());
            leave[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(come);
        Arrays.sort(leave);
        int comeIndex = 0; 
        int leaveIndex = 0; 
        int count = 0;
        int max = 0;
        for (int i = 0; i < 2*N; i++) {
            if (come[comeIndex] < leave[leaveIndex]) {
                count++;
                max = Math.max(max, count);
                comeIndex++;
            } else {
                count--;
                leaveIndex++;
            }
            if (comeIndex >= N) {
                i = 2*N;
            }
        }
        System.out.println(max);
    }
}