import java.util.*;
import java.io.*;

public class entry_12176926 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        StringTokenizer stringTokenizer = new StringTokenizer(bufferReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        DSU dsu = new DSU(n);

        for(int i=0;i<m;i++){
            stringTokenizer = new StringTokenizer(bufferReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            dsu.merge(x,y);
        }
        List<Integer> list = dsu.sets();
        printWriter.println(list.size() - 1);
        for(int i=1;i<list.size();i++){
            printWriter.println(list.get(i-1) + " " + list.get(i));
        }
        printWriter.flush();
        printWriter.close();
    }

}

class DSU{
    private int nodes;
    private int[] parents;
    private int[] ranks;

    DSU(int n){
        this.nodes = n;
        this.parents = new int[n];
        this.ranks = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int findPar(int node){
        if(parents[node]==node){
            return node;
        }
        return parents[node] = findPar(parents[node]);
    }

    public void merge(int x, int y){
        int parX = findPar(x);
        int parY = findPar(y);
        if(parX == parY){
            return;
        }
        if(ranks[parX] > ranks[parY]){
            parents[parY] = parX;
            ranks[parX] += ranks[parY];
        } else {
            parents[parX] = parY;
            ranks[parY] += ranks[parX];
        }
    }

    public List<Integer> sets(){
        List<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<nodes;i++){
            if(parents[i]==i){
                arrayList.add(i+1);
            }
        }
        return arrayList;
    }
}