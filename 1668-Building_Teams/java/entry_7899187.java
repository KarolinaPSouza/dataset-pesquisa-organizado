import java.io.*;
import java.util.*;

public class entry_7899187 {
    static ArrayList<ArrayList<Integer>> connections;
    static int[] coloring;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        connections = new ArrayList<ArrayList<Integer>>(n);
        for(int i = 0; i < n; i++){
            connections.add(new ArrayList<Integer>());
        }
        coloring = new int[n];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            connections.get(a).add(b);
            connections.get(b).add(a);
        }
        boolean possible = true;
        for(int i = 0; i < n && possible; i++){
            if(coloring[i] == 0){
                possible = color(i, 1);
            }else{
                continue;
            }
        }
        if(!possible){
            pw.println("IMPOSSIBLE");
            pw.close();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(coloring[i]).append(" ");
        }
        pw.println(sb.toString());
        pw.close();
    }

    public static boolean color(int i, int color){
        if(coloring[i] != 0 && coloring[i] != color) return false;
        else if(coloring[i] != 0) return true;
        boolean possible = true;
        coloring[i] = color;
        for(int j : connections.get(i)){
            possible = color(j, color % 2 + 1);
            if(!possible) break;
        }
        return possible;
    }
}