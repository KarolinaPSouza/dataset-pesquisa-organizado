import java.util.*;
import java.io.*;

public class entry_12213156 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n =sc.nextInt();
        int x = sc.nextInt();

        HashMap<Integer,Integer>s1  = new HashMap<>();

        HashMap<Integer,int[]>s2  = new HashMap<>();

PriorityQueue<Integer>mf = new PriorityQueue<>();

        for(int e=0;e<n;e++){
            int el = sc.nextInt();
            if(s1.containsKey(el)){
                s1.put(el,s1.get(el)+1);
               int[]ee =  s2.get(el);
               if(ee[1]==-1)
                {
                 ee[1]=e+1;
                 s2.put(el,ee);
                }
            }
            else{
                mf.offer(el);
                s1.put(el,1);
                int[]rt = new int[2];
                Arrays.fill(rt,-1);
                 rt[0]=e+1;
                s2.put(el,rt);
             }
        }
int cc=0;
StringBuilder sb = new StringBuilder();
        while(!mf.isEmpty()){
        int em  =mf.poll();
        int dif = x-em;
        if(dif<0){
         break;
        }
        if(s1.containsKey(dif) && s2.containsKey(dif)){
            int gm = s1.get(dif);
            if(dif!=em){
             int[] yu = s2.get(em);
             int[] yz = s2.get(dif);
                  int yy = yu[0];
                  int zz = yz[0];
             sb.append(yy);
             sb.append(" ");
             sb.append(zz);
                cc=1;
                break;
            }
            else if(dif==em && gm>1){
             int[] yu = s2.get(em);
                  int yy = yu[0];
                  int zz = yu[1];
                  cc=1;
                  sb.append(yy);
             sb.append(" ");
             sb.append(zz);
                break;
            }
        }

    }

if(cc==0){
 System.out.println("IMPOSSIBLE");
}else{
    System.out.println(sb.toString());
}



    }

    // FastReader class for optimized input reading
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}