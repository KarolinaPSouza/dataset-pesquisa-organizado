import java.util.*;
import java.io.*;
public class entry_5716306 {

     public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("./input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) { 
        }
        Scanner sc = new Scanner(System.in);
        int te = sc.nextInt();
        StringBuilder sb = new StringBuilder("");
        while (te-- >0) {
            int r =sc.nextInt();
            int c =sc.nextInt();
            long max=Math.max(r,c);
            long diag =max*(max-1);
            diag++;
            long ans=diag-Math.min(r,c);
            if(r==c){
                sb.append(diag);
                sb.append("\n");
                continue;
            }
            if(max%2==0){
                if(r>c){
                    diag+=r-c;
                }else if(r<c){
                    diag-=c-r;
                }
            }else{
                if(r>c){
                    diag-=r-c;
                }else if(r<c){
                    diag+=c-r;
                }
            }

            sb.append(diag);
            sb.append("\n");
        }
        System.out.println(sb);
    }
     public static String sortString(String inputString)
    { 
        char tempArray[] = inputString.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray);
    }
    public static void dfs(List<List<Integer>>graph, List<Integer>li, int src, boolean []vis){

     for(int val : graph.get(src)){
            if(vis[val])continue;
            vis[val]=true;
            li.add(val);
            dfs(graph,li,src,vis);
        }
    }

}
