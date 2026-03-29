import java.io.*;
import java.util.*;
class projects {
    static class jobs{
        int s;
        int e;
        long p;
        jobs(int s,int e,long p){
            this.s=s;
            this.e=e;
            this.p=p;
        }

    }
    static long dp[];
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<jobs>list=new ArrayList<>();
       int n = 0;
        while (true) {
            String line = br.readLine();
            if (line == null) continue;
            line = line.trim();
            if (!line.isEmpty()) {
                n = Integer.parseInt(line);
                break;
            }
        }

        dp = new long[n + 1];
        int end[] = new int[n];

        // Read n job lines
        for (int i = 0; i < n; ) {
            String line = br.readLine();
            if (line == null) continue;
            line = line.trim();
            if (line.isEmpty()) continue; // skip blank lines

            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new jobs(a, b, p));
            i++; // only increment when a valid line is read
        }

        Collections.sort(list,(a,b)->Long.compare(a.e,b.e));
        for(int i=0;i<list.size();i++){
            end[i]=list.get(i).e;
        }
        System.out.println(Solve(end,list));


    }
    public static long Solve(int end[],List<jobs>list){
        dp[0]=list.get(0).p;
        for(int i=1;i<end.length;i++){
            int j=search(end,list.get(i).s);

            dp[i]=Math.max(dp[i-1],list.get(i).p+((j<0)?0:dp[j]));

        }
        long ans=0;
        for(int i=0;i<dp.length;i++){
            ans=Math.max(ans,dp[i]);
        }
        return ans;

    }
    public static int search(int end[],int x){
        int l=0;
        int r=end.length-1;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(end[mid]<x){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }

        }
        return ans;
    }
}