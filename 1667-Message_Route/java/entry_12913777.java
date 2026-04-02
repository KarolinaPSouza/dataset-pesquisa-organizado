import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class entry_12913777 {
    static int m,n;
    static boolean[]visited;
    static ArrayList<Integer>[]arr;
    static int[]parent;
    static int count;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        StringBuilder anssb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        boolean found=false;

        visited=new boolean[n+1];
        arr=new ArrayList[n+1];
        parent=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i]=new ArrayList<>();
        }
        for(int i=1;i<=m;i++)
        {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        ArrayDeque<Integer>queue=new ArrayDeque<>();
        queue.add(1);
        visited[1]=true;
        while(!queue.isEmpty())
        {
            int current=queue.poll();
            for(int everynum:arr[current])
            {
                if(!visited[everynum])
                {
                    if(everynum==n)
                    {
                        found=true;
                        parent[everynum]=current;
                        queue.removeAll(queue);
                        break;
                    }
                    parent[everynum]=current;
                    visited[everynum]=true;
                    queue.add(everynum);
                }                
            }
        }

        if(!found)
        {
            anssb.append("IMPOSSIBLE");
        }
        else
        {
            int current=n;
            ArrayDeque<Integer>temp=new ArrayDeque<>();
            while(current!=1)
            {
                temp.add(current);
                current=parent[current];
            }    
            temp.add(1);        
            anssb.append(temp.size()).append("\n");
            while(!temp.isEmpty())
            {
                anssb.append(temp.pollLast()).append(" ");
            }
        }
        System.out.println(anssb);
        br.close();
    }
}