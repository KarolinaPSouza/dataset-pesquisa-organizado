import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_11586026 {
    static boolean bfs(List<List<Integer>> adjList,int index,int[] team,int code){
        if(team[index] != 0){
            if(team[index] != code){
                return false;
            }else return true;
        }
        team[index] = code;
        for(int i:adjList.get(index)){
            if(!bfs(adjList, i, team, (code == 1 ? 2 : 1))) return false;
        }
        return true;

    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        //int[][] friendShips = new int[m][2];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int p = fs.nextInt() - 1;
            int q = fs.nextInt() - 1;
            adjList.get(p).add(q);
            adjList.get(q).add(p);
        }

        int[] team = new int[n];
        for(int i=0;i<n;i++){
            if(team[i] == 0){
                if(!bfs(adjList, i, team, 1)){
                    System.out.println("IMPOSSIBLE");
                    return ;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i:team){
            sb.append(" " + i);
        }
        System.out.println(sb.toString().substring(1));

    }


    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}