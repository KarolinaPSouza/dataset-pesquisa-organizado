import java.util.*;
import java.io.*;

public class entry_8833321 {
    // static boolean[] left;
    // static class Cust implements Comparable<Cust>{
    //     int a,b;
    //     public Cust(int a_,int b_){
    //         a = a_;
    //         b = b_;
    //     }
    //     public int compareTo(Cust cust){
    //         return Integer.compare(a, cust.a);
    //     }
    // }
    // static int leave(Cust[] custs,int last, int cur){
    //     int counter = 0;
    //     for(int i=last;i<cur;i++){
    //         if(!left[i] && custs[i].b<custs[cur].a){
    //             counter++;
    //             left[i]=true;
    //         }
    //     }
    //     return counter;
    // }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        TreeMap<Integer,Integer> custs = new TreeMap<>();

        for(int i=0;i<n;i++){
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            custs.put(a,1);
            custs.put(b,-1);
        }

        int max = 0;
        int curr = 0;

        for(int a:custs.keySet()){
            curr+=custs.get(a);
            if(curr>max){
                max = curr;
            }
        }

        System.out.println(max);
    }
}