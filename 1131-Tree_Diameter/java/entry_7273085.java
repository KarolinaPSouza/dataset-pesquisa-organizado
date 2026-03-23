import java.io.*;
import java.math.*;
import java.util.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;
public class entry_7273085 {

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 1000010;
    private final int MAX_TREE = (MAX_N << 2);
    private final char SYMBOL = '@';

    private int[] movX = { 0, 0, 1, -1 };
    private int[] movY = { -1, 1, 0, 0 };
    private long[] cards = { 1, 10, 100, 1000, 10000 };
    private long MOD = 1000000007;

    private class Node{
        int m_dist;
        ArrayList<Integer> m_neighbors;
        int m_dfs;

        public Node(){
            m_neighbors =new ArrayList<Integer>();
            m_dfs=0;
            m_dist=0;
        }
    };

    public Node [] graphs;

    public void solve() throws Exception {
        int nnodes =nextInt(),A,B;
        graphs = new Node[nnodes+5];
        for (int i=0;i<=nnodes;i++)  graphs[i] = new Node();
        for(int i=1;i<nnodes;i++){
            A=nextInt();
            B=nextInt();
            graphs[A].m_neighbors.add(B);
            graphs[B].m_neighbors.add(A);
        }
        System.out.printf("%d\n",diameterTree(1));
    }

    entry_7273085() throws Exception {
        /*
         * Esta entrada se debe activar cuando se hace una ejercicio de lectura hasta
         * fin de fichero copiar la entrada en un fichero "Input.txt" y comentar el otro
         * in . A la hor de enviar comentar este y descomentar el otro
         */
        // in = new BufferedReader(new FileReader("Inpu.txt"));
        // out = new PrintWriter(new FileWriter("Output.txt"));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        eat("");
        solve();
        in.close();
        out.close();
    }

    private void eat(String str) {
        st = new StringTokenizer(str);
    }

    String next() throws Exception {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null)
                return null;
            eat(line);
        }
        return st.nextToken();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    double nextDouble() throws Exception {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws Exception {
        new entry_7273085();
    }

    public int diameterTree(int _nodeStart){
        int tDiameter=0;
        int nextNode,currentNode,farthestNode=_nodeStart;
        graphs[_nodeStart].m_dist=0;
        graphs[_nodeStart].m_dfs=1;

        Stack<Integer> visit =new Stack<Integer>();
        visit.push(_nodeStart);

        while(!visit.empty()){
            currentNode=visit.pop();
            if(graphs[currentNode].m_dist>tDiameter){
                tDiameter=graphs[currentNode].m_dist;
                farthestNode=currentNode;
            }

            int tNeighbors=graphs[currentNode].m_neighbors.size();
            for(int i=0;i<tNeighbors;i++){
                nextNode=graphs[currentNode].m_neighbors.get(i);
                if(graphs[nextNode].m_dfs<1){
                    graphs[nextNode].m_dfs=1;
                    graphs[nextNode].m_dist=graphs[currentNode].m_dist+1;
                    if(graphs[nextNode].m_dist>tDiameter){
                        tDiameter=graphs[nextNode].m_dist;
                        farthestNode=nextNode;
                    }
                    visit.push(nextNode);
                }
            }
        }

        graphs[farthestNode].m_dist=0;
        graphs[farthestNode].m_dfs=2;
        tDiameter=0;

        visit.push(farthestNode);

        while(!visit.empty()){
            currentNode=visit.pop();
            if(graphs[currentNode].m_dist>tDiameter){
                tDiameter=graphs[currentNode].m_dist;
                farthestNode=currentNode;
            }

            int tNeighbors=graphs[currentNode].m_neighbors.size();
            for(int i=0;i<tNeighbors;i++){
                nextNode=graphs[currentNode].m_neighbors.get(i);
                if(graphs[nextNode].m_dfs<2){
                    graphs[nextNode].m_dfs=2;
                    graphs[nextNode].m_dist=graphs[currentNode].m_dist+1;
                    if(graphs[nextNode].m_dist>tDiameter){
                        tDiameter=graphs[nextNode].m_dist;
                        farthestNode=nextNode;
                    }
                    visit.push(nextNode);
                }
            }
        }
        return tDiameter;
    }

}