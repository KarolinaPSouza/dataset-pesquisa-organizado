import java.io.*;
import java.util.*;

public class entry_11588914 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Read inputs
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 

        long[][] time= new long[n][2];

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            time[i][0] = Long.parseLong(st.nextToken());
            time[i][1] = Long.parseLong(st.nextToken());

        }

        List<long[]> al=new ArrayList<>();
        for(int i=0;i<n;i++){
          al.add(new long[]{time[i][0],1});
          al.add(new long[]{time[i][1],-1});
        }
        Collections.sort(al,(a,b)->Long.compare(a[0],b[0]));


        long count = 0;
        long ans=0;
        for(long row[]:al){
          count+=row[1];
          ans=Math.max(count,ans);
        }


        // Output the result
        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.flush();
    }
}