import java.io.*;
import java.util.*;


public class entry_11819622 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            var list = map.getOrDefault(u-1, new ArrayList<>());
            list.add(v-1);
            map.put(u-1, list);
            list = map.getOrDefault(v-1, new ArrayList<>());
            list.add(u-1);
            map.put(v-1, list);
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; ++i)
        {
            if(!vis[i])
            {
                ans.add(i+1);
                ++count;
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                while(!queue.isEmpty())
                {
                    int val = queue.remove();
                    var list = map.get(val);
                    if(list == null) continue;
                    for(int v : map.get(val))
                    {
                        if(!vis[v])
                        {
                            vis[v] = true;
                            queue.add(v);
                        }
                    }
                }
            }
        }
        out.println(count-1);
        for(int i = 0; i < ans.size()-1; ++i)
        {
            out.println(ans.get(i) + " " + ans.get(i+1));
        }
        out.flush();
    }
}