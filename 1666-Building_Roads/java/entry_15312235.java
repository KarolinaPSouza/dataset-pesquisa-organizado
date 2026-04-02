import java.util.*;
import java.io.*;
public class entry_15312235 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        for(int i =0;i<m;i++){
            String[] roads = br.readLine().split(" ");
            int a = Integer.parseInt(roads[0]);
            int b = Integer.parseInt(roads[1]);
            union(a,b,parent);
        }
        Set<Integer> components = new HashSet<>();
        for(int i =1;i<=n;i++){
            components.add(find(parent,i));
        }
        ArrayList<Integer> list = new ArrayList<>(components);
        int k = list.size();
        System.out.println(k-1);
        for(int i=1;i<k;i++){
            System.out.println(list.get(i-1) + " "+list.get(i));
        }

        // public static void union(int x , int y, int[] parent){

        // }
    }
    public static void union(int x , int y, int[] parent){
        int parent_x = find(parent,x);
        int parent_y = find(parent,y);
        if(parent_x != parent_y){
            parent[parent_y] = parent_x;
        }
    }
    public static int find(int[] parent,int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent,parent[parent[x]]);
    }

}