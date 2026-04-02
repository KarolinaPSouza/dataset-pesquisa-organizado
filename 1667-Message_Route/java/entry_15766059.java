import java.io.IOException;
import java.io.InputStream;
import java.util.*;



public class entry_15766059 {
    static class FS {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
    public static void main(String[]args)throws Exception
    {
        FS fs=new FS();
        int comp,route;
        comp=fs.nextInt();
        route=fs.nextInt();

        List<Integer>[]edges=new List[comp];
        for(int i=0;i<comp;i++)
        {
            edges[i]=new ArrayList<>();
        }

        for(int i=0;i<route;i++)
        {
            int from,to;
            from=fs.nextInt();
            to=fs.nextInt();
            edges[from-1].add(to-1);
            edges[to-1].add(from-1);
        }

        boolean[]visited=new boolean[comp];
        int[]parent=new int[comp];
        int[]dist=new int[comp];
        Queue<Integer>queue=new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        boolean found=false;

        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            for(int i=0;i<edges[curr].size();i++)
            {
                int next=edges[curr].get(i);
                if(!visited[next])
                {
                    parent[next]=curr;
                    queue.add(next);
                    visited[next]=true;
                    dist[next]=dist[curr]+1;
                    if(next==comp-1)
                    {
                        found=true;
                        break;
                    }
                }
            }

            if(found)
            {
                break;
            }
        }

        if(!found)
        {
           System.out.println("IMPOSSIBLE");
        }
        else
        {
            System.out.println(dist[comp-1]+1);
            Stack<Integer>stack=new Stack<>();
            int curr=comp-1;
            while(curr!=0)
            {
                int c=curr+1;
                stack.push(c);
                curr=parent[curr];
            }
            curr+=1;
            stack.push(curr);
            while(!stack.isEmpty())
            {
                System.out.print(stack.pop()+" ");
            }

        }
    }
}