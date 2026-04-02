import java.util.*;
import java.io.*;
public class entry_15704989 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int a=Integer.parseInt(br.readLine());
        int graph[]=new int[a];
        int children[]=new int[a];
        int count[]=new int[a];
        boolean visited[]=new boolean[a];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i=0; i<a-1; i++){
            int t=Integer.parseInt(st.nextToken())-1;
            graph[i+1]=t;
            children[t]++;
        }
        Deque<Integer> list=new LinkedList<>();
        for (int i=0; i<a; i++){
            if (children[i]==0){list.add(i);}
        }
        while (!list.isEmpty()){
            int t=list.pollFirst();
            if (children[t]!=0){list.add(t); continue;}
            if (visited[t]){continue;}
            if (t==0){break;}
            count[graph[t]]+=count[t]+1;
            visited[t]=true;
            children[graph[t]]--;
            list.add(graph[t]);
        }
        for (int i=0; i<a; i++){pw.print(count[i] + " ");}
        pw.flush();
    }
}