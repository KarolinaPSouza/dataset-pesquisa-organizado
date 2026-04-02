import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = null;
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class FastWriter {
    PrintWriter pw;

    public FastWriter() {
        pw = new PrintWriter(System.out);
    }

    public void print(Object o) {
        pw.print(o);
    }

    public void println(Object o) {
        pw.println(o);
    }

    public void close() {
        pw.close();
    }

    public void flush() {
        pw.flush();
    }
}

public class entry_8519575 {

    static FastReader reader =new FastReader(); 
    static FastWriter writer = new FastWriter(); 

                  // BEST APPROACH TAKE ONLY ONE PARENT ARRAY - BFS with Backtrack
    // public static void main(String[] args) {

    //     int n= reader.nextInt(); 
    //     int m = reader.nextInt(); 

    //     List<List<Integer>> list = new ArrayList<>(); 
    //     for(int i= 0 ;i<= n ;i++ ) list.add(new ArrayList<>()); 

    //     for(int i= 0 ;i < m ;i++ ){
    //         int u = reader.nextInt(), v = reader.nextInt(); 
    //         list.get(u).add(v); 
    //         list.get(v).add(u); 
    //     }

    //     int[] par = new int[n+1]; 

    //     Arrays.fill(par,-1); 

    //     Queue<Integer> q = new LinkedList<>(); 
    //     q.offer(1); 
    //     par[1] = 0; 

    //     while( !q.isEmpty() ){
    //         int curr = q.remove(); 

    //         for(int u : list.get(curr) ){
    //             if( par[u] < 0 ){
    //                 par[u] = curr; 
    //                 q.offer(u);
    //             }
    //         }

    //     }

    //     // System.out.println(Arrays.toString(par));
    //     if( par[n] < 0 ) System.out.println("IMPOSSIBLE");
    //     else{
    //         int curr = n; 
    //         List<Integer> listt = new ArrayList<>(); 
    //         listt.add(n);  
    //         while(par[curr] != 0 ){
    //             listt.add(par[curr]); 
    //              curr = par[curr]; 
    //         }
    //         System.out.println(listt.size());

    //         for(int i = 0; i < listt.size(); i++ ) System.out.print(listt.get(listt.size()-1-i)+" ");
    //     }

    // }

    public static void main(String[] args){

        int n = reader.nextInt(); 
        int m = reader.nextInt(); 

        List<List<Integer>> list =new ArrayList<>(); 

        for(int i= 0; i <= n; i++ ) list.add(new ArrayList<>()); 

        for(int i = 0 ;i < m ;i++ ){
            int u = reader.nextInt(); 
            int v = reader.nextInt(); 

            list.get(u).add(v); 
            list.get(v).add(u); 
        }

        int[] dir = new int[n+1];
        HashSet<Integer> set =new HashSet<>(); 

        Queue<Integer> q =new LinkedList<>(); 

        q.offer(1); 
        set.add(1); 

        while( !q.isEmpty() ){
            int k = q.size(); 

            for(int i= 0; i < k;i++ ){
                int curr = q.remove();

                if( curr == n){
                    show(dir,n); 

                    writer.flush(); 
                    writer.close(); 
                    return;
                }

                for(int j = 0; j < list.get(curr).size(); j++){

                    if( !set.contains(list.get(curr).get(j)) ){
                        set.add(list.get(curr).get(j)); 
                        dir[list.get(curr).get(j)] = curr; 
                        q.offer( list.get(curr).get(j)); 
                    }
                }
            }
        }

        writer.println("IMPOSSIBLE"); 
        writer.flush(); 
        writer.close(); 

    }
    public static void show(int[] dir,int curr){ 
        List<Integer> list  = new ArrayList<>(); 

        while( curr != 1 ){
            list.add(dir[curr]); 
            curr = dir[curr]; 
        }

        writer.println(list.size()+1);
        for(int i = list.size()-1 ;  i >= 0; i-- ){
            writer.print(list.get(i)+ " "); 
        }

        writer.print(dir.length-1); 
    }




}