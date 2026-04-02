import java.io.*;
import java.util.*;

public class entry_13335288 {
    static int counter;
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            int n1 = sc.nextInt(), n2 = sc.nextInt();
            map.putIfAbsent(n1,new ArrayList<>());
            map.get(n1).add(n2);
            map.putIfAbsent(n2,new ArrayList<>());
            map.get(n2).add(n1);
        }
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        Map<Integer,Integer> mapping = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int index = -1;
        for(int i = 1; i <= n; i++){
            if(mapping.containsKey(i)){
                continue;
            }
            index = recurse(i,0,map,mapping,list);
            if(index != -1){
                break;
            }
        }
        if(index == -1){
            out.write("IMPOSSIBLE".getBytes());
        }
        else{
            int count = list.size() - index + 1;
            out.write((count + "\n").getBytes());
            int temp = list.get(index);
            while (index < list.size()){
                out.write((list.get(index++) + " ").getBytes());
            }
            out.write((temp + " ").getBytes());
        }
        out.flush();
    }

    public static int recurse(int node,int from,Map<Integer,List<Integer>> map,Map<Integer,Integer> mapping,List<Integer> list){
        if(mapping.containsKey(node)){
            return mapping.get(node);
        }
        mapping.put(node,counter++);
        list.add(node);
        for(int adj : map.getOrDefault(node,new ArrayList<>())){
            if(adj == from){
                continue;
            }
            int temp = recurse(adj,node,map,mapping,list);
            if(temp != -1){
                return temp;
            }
        }
        list.remove(list.size() - 1);
        counter--;
        return -1;
    }

    static class FastInput {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}