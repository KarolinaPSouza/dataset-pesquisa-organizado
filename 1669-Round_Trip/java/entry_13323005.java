import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_13323005 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Solution2 sol = new Solution2();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a);

        }
        sol.solve(adjList);

    }

}


class Solution2 {
    int cycleStart = -1;
    int cycleEnd = -1;

    public void solve(List<List<Integer>> adjList) {
        int n = adjList.size() - 1;
        int[] color = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);

        for(int i = 1; i <= n; i++) {
            if(color[i] == 0 && !adjList.get(i).isEmpty()) {
                boolean isCycle = isCycle(adjList, i, color, parent);
                if(isCycle) {
                    List<Integer> cycle = new ArrayList<>();
                    int cycleStartOriginal = cycleStart;
                    while(cycleStart != cycleEnd) {
                        cycle.add(cycleStart);
                        cycleStart = parent[cycleStart];
                    }
                    cycle.add(cycleEnd);
                    cycle.add(cycleStartOriginal);

                    System.out.println(cycle.size());
                    StringBuilder answer = new StringBuilder();
                    for(int val: cycle) {
                        answer.append(val);
                        answer.append(' ');
                    }
                    System.out.println(answer);
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");

    }

    //we will use bfs to detect cycle
    //every time we push a node, we also push the parent
    //and when we see a visited node which is not the parent, we have the cycle
    //we can trace the path from both these nodes to the source
    //then we can find the LCA and make the path
    private List<Integer> cycle(List<List<Integer>> adjList, int source, boolean[] visited) {
        int n = adjList.size() - 1;
        List<Integer> cycle = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        int[] parent = new int[n+1];
        parent[source] = -1;

        visited[source] = true;

        while(!queue.isEmpty()) {
            int node = queue.remove();
            int currentParent = parent[node];

            for(int neighbour: adjList.get(node)) {
                if(visited[neighbour] && neighbour != currentParent) {
                    //trace path from node to junction, and neighbour to junction
                    cycle = makeCyclePath(parent, node, neighbour);
                    return cycle;
                }
                if(!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                    parent[neighbour] = node;
                }
            }
        }

        return cycle;

    }

    //color 0 means unvisited, color 1 means currently visiting, color 2 means completed
    private boolean isCycle(List<List<Integer>> adjList, int current, int[] color, int[] parent) {
        color[current] = 1;
        for(int node: adjList.get(current)) {
            if(color[node] == 0) {
                parent[node] = current;
                if(isCycle(adjList, node, color, parent)) {
                    return true;
                }
            }
            //we get the node again in the same path
            else if(color[node] == 1 && node != parent[current]) {
                cycleStart = current;
                cycleEnd = node;
                return true;
            }
        }

        return false;

    }

    private List<Integer> makeCyclePath(int[] parent, int u, int v) {
        //path from u to source
        int uOriginal = u;
        List<Integer> path1 = new ArrayList<>();
        while(u != -1) {
            path1.add(u);
            u = parent[u];
        }

        //path from v to source
        List<Integer> path2 = new ArrayList<>();
        while(v != -1) {
            path2.add(v);
            v = parent[v];
        }

        //find LCA of u and v using paths
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while(i >= 0 && j >= 0) {
            if(!path1.get(i).equals(path2.get(j))) {
                break;
            }
            i--;
            j--;
        }

        int lca = path1.get(i+1);
        List<Integer> backpath1 = path1.subList(0, i+1);
        List<Integer> backpath2 = path2.subList(0, j+1);

        backpath1.add(lca);
        Collections.reverse(backpath2);

        backpath1.addAll(backpath2);
        backpath1.add(uOriginal);

        return backpath1;

    }

}