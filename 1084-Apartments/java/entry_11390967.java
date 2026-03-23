import java.io.*;
import java.util.Arrays;

public class entry_11390967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] entry_11390967 = br.readLine().split(" ");
        int n = Integer.parseInt(entry_11390967[0]);
        int m  = Integer.parseInt(entry_11390967[1]);
        int k  = Integer.parseInt(entry_11390967[2]);
        if(m==1 && k==1) {
            System.out.println(1);
            return;
        }
        entry_11390967 = br.readLine().split(" ");
        int[] preferred_size = new int[n];
        for(int i=0; i<n; i++)
            preferred_size[i] = Integer.parseInt(entry_11390967[i]);
        entry_11390967 = br.readLine().split(" ");
        int[] available_sizes = new int[m];
        for(int i=0; i<m; i++)
            available_sizes[i] = Integer.parseInt(entry_11390967[i]);
        Arrays.sort(preferred_size);
        Arrays.sort(available_sizes);
        int count = 0;
        int ptr_A=0, ptr_B = 0;
        while(ptr_A<n && ptr_B < m){
            if(Math.abs(preferred_size[ptr_A] - available_sizes[ptr_B])<=k){
                count++;
                ptr_B++;
                ptr_A++;
            }
            else if(preferred_size[ptr_A] > available_sizes[ptr_B]){
                ptr_B++;
            }
            else
                ptr_A++;
        }
        bw.write(String.valueOf(count));
        bw.write("\n");
        bw.flush();
    }
}