import java.util.*;
import java.io.*;
class cyclefinding {
    static class Pair{
        int v;
        long w;
        Pair(int v,long w){
            this.v=v;
            this.w=w;
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        String s = next();
        if (s == null) throw new NoSuchElementException();
        return Integer.parseInt(s);
    }
    public static void main(String[] args)throws IOException {
        int n=nextInt();
        int m=nextInt();
        List<List<Pair>>list=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }
        while(m-->0){
            int a=nextInt();
            int b=nextInt();
            int c=nextInt();
            list.get(a).add(new Pair(b,c));
        }
        long dist[]=new long[n+1];
        Arrays.fill(dist,0);
        int parent[]=new int[n+1];
        Arrays.fill(parent,-1);
        int x=-1;
        for(int count=0;count<n;count++){
            x=-1;
            for(int i=1;i<n+1;i++){
                for(Pair p:list.get(i)){
                    if(dist[i]+p.w<dist[p.v]){
                        dist[p.v]=dist[i]+p.w;
                        parent[p.v]=i;
                        x=p.v;
                    }
                }
            }
        }
        if(x==-1){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
            for(int i=0;i<n;i++){
                x=parent[x];
            }
            List<Integer>ans=new ArrayList<>();
            int start=x;
            ans.add(start);
            start=parent[start];
            while(start!=x){
                ans.add(start);
                start=parent[start];

            }
            ans.add(start);


             Collections.reverse(ans);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
        }

    }
}