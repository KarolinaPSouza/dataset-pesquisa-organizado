import java.util.*;
import java.io.*;

public class entry_11271570 {

}

class BeingZero {
    int[] vis;
    int till;
    List<Integer> v;
    List<List<Integer>> graph;

    public List<Integer> solve(int n, int m, int[][] edgeList){
        vis = new int[n + 1];
        graph = new ArrayList<>();
        v = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            vis[i] = -1;
        }
        for (int[] ele : edgeList) {
            int u = ele[0];
            int v = ele[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean cycleFound = false;
        for (int i = 1; i <= n; i++) {
            if (vis[i] == -1) {
                v.clear();
                int result = dfs(i, -1);
                if (!v.isEmpty()) {
                    cycleFound = true;
                    Collections.reverse(v);
                    return v;
                }
            }
        }
        v.clear();
        return v;
    }

    public int dfs(int p, int c) {
        if (vis[p] != -1) {
            till = p;
            v.add(p);
            return 1;
        }

        vis[p] = 1;

        for (int neighbor : graph.get(p)) {
            if (neighbor == c) continue;
            int result = dfs(neighbor, p);
            if (result == 1) {
                v.add(p);
                if (till == p) {
                    return 2;
                } else {
                    return 1;
                }
            } else if (result == 2) {
                return 2;
            }
        }
        return 0;
    }
}

class BZLib {
    public List<List<Integer> > readAndGetListOfList(int r, int c, BufferedReader br) throws IOException {
        List<List<Integer> > m = new ArrayList<>();
        for(int i = 0; i < r; i++){
            m.add(readAndGetList(c, br));
        }
        return m;
    }
    public int[][] readAndGetMatrix(int r, int c, BufferedReader br) throws IOException {
        int[][] mat = new int[r][c];
        for(int i = 0; i < r; i++){
            int[] row = readAndGetArray(c, br);    
            for(int j = 0; j < c; j++)
                mat[i][j] = row[j];
        }
        return mat;
    }
    public int[] readAndGetArray(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        return a;
    }
    public List<Integer> readAndGetList(int n, BufferedReader br) throws IOException {
     StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            l.add(Integer.parseInt(st.nextToken()));
        }
        return l;
    }
    public void printArray(int a[], PrintWriter pw){
        for(int i = 0; i < a.length; i++){
            if(i == 0)
                pw.print(a[i]);
            else
                pw.print(" " + a[i]);
        }
        pw.println();
    }
    public void printList(List<Integer> a, PrintWriter pw){
        for(int i = 0; i < a.size(); i++){
            if(i == 0)
                pw.print(a.get(i));
            else
                pw.print(" " + a.get(i));
        }
        pw.println();
    }
    public void printListOfList(List< List<Integer> > m, PrintWriter pw){
        for(int i = 0; i < m.size(); i++){
            for(int j = 0; j < m.get(i).size(); j++){
                if(j == 0)
                    pw.print(m.get(i).get(j));                    
                else
                    pw.print(" " + m.get(i).get(j));
            }
        }
        pw.println();
    }
    public void printMatrix(int m[][], PrintWriter pw){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                if(j == 0)
                    pw.print(m[i][j]);
                else
                    pw.print(" " +m[i][j]);
            }
        }
        pw.println();
    }
}

class Main {

    public static boolean ValidPath(List<Integer> path, int[][] edgeList,int n){
        Map<Integer,Set<Integer>> AdjL = new HashMap<>();
        for(int i=0;i<=n;i++){
            AdjL.put(i,new HashSet<>());
        }
        for(int[] ele : edgeList){
            int u=ele[0];
            int v=ele[1];
            AdjL.get(u).add(v);
            AdjL.get(v).add(u);
        }

        if(!path.get(0).equals(path.get(path.size()-1))) return false;
        for(int i=0;i<path.size()-1;i++){
            int curr=path.get(i);
            int next=path.get(i+1);
            if(!AdjL.get(curr).contains(next)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream(new File("input.txt")));
        // System.setOut(new PrintStream(new File("output.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, false);
        // int t=Integer.parseInt(br.readLine());
        BeingZero bz = new BeingZero();
        // while (t-- != 0) {
            BZLib bzLib = new BZLib();
            int[] nk = bzLib.readAndGetArray(2, br);
            int n = nk[0];
            int m = nk[1];
            int[][] edgeList = bzLib.readAndGetMatrix(m,2,br);
            List<Integer> ans = bz.solve(n , m,  edgeList);
            if(ans.size()==0) pw.println("IMPOSSIBLE");
            else{
                pw.println(ans.size());
                for(int e : ans) pw.print(e+" ");
                pw.println();
            }
            // else if(ValidPath(ans,edgeList,n)) pw.println("Valid Path");
            // else pw.println("Invalid Path");
            // pw.println();
        // }
        br.close();
        pw.close();
    }
}
