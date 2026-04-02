//package basics;
import java.io.*;
import java.util.*;

public class entry_13999032 {
    static class Reader{
        BufferedReader br;
        StringTokenizer st;

        Reader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        public String next(){
            if (st==null || !st.hasMoreElements()){

                try {
                    st=new StringTokenizer(br.readLine());
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
            return st.nextToken();
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }

    }


    public static void main(String[] args) {

        Reader reader=new Reader();
        PrintWriter out=new PrintWriter(System.out);
        int n=reader.nextInt(),x=reader.nextInt();
        int[][] A=new int[n][2];
        Map<Integer,int[]> map=new HashMap<>();
        for (int i=0;i<n;i++){
            A[i][0]=reader.nextInt();
            A[i][1]=i+1;
        }
        for (int i=2;i<n;i++){
            for (int j=i-2;j>=0;j--){
                map.put(A[i-1][0]+A[j][0],new int[]{j+1,i});
            }
            for (int j=i+1;j<n;j++){
                int sum=A[i][0]+A[j][0];
                if (map.containsKey(x-sum)){
                    int[] get=map.get(x-sum);
                    i++;
                    j++;
                    out.print(get[0]+" "+get[1]+" "+i+" "+j);
                    out.close();
                    return;
                }
            }
        }
        out.print("IMPOSSIBLE");
        out.flush();
        out.close();
    }

}