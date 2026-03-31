import java.util.*;
import java.io.*;
public class entry_580145 {

 static class Reader{ 
        BufferedReader br; 
        StringTokenizer st; 

        public Reader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 

        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e){ 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt(){ 
            return Integer.parseInt(next()); 
        } 

        long nextLong(){ 
            return Long.parseLong(next()); 
        } 

        double nextDouble(){ 
            return Double.parseDouble(next()); 
        } 

        String nextLine(){ 
            String str = ""; 
            try{ 
                str = br.readLine(); 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 

    public static void main(final String [] args)throws IOException{
       Reader sc=new Reader();
       int n=sc.nextInt();
       List<int []> list=new ArrayList<>();
       for(int i=0;i<n;i++){
           int a=sc.nextInt();
           int entry_580145=sc.nextInt();
           list.add(new int[]{a,1});
           list.add(new int[]{entry_580145,-1});
       }

       list.sort((x,y)->x[0]-y[0]);

       int max=0;
       int curr=0;
       for(int i=0;i<list.size();i++){
           int [] p=list.get(i);
           curr+=p[1];
           max=Math.max(max,curr);
       }
       System.out.println(max);


    }

}

