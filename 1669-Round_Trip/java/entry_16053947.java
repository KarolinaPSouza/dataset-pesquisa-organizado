//package csProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class entry_16053947 {
    public static void  main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i =0; i<=n ; i++){
            list.add(new ArrayList<>());
        }
        for(int i =0; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int cityA = Integer.parseInt(st.nextToken());
            int cityB = Integer.parseInt(st.nextToken());
            list.get(cityA).add(cityB);
            list.get(cityB).add(cityA);
        }
        br.close();
        boolean [] visited = new boolean[n+1];
        int [] parents = new int[n+1];
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                int start = dfs(i,visited,parents,list);
                if(start!=-1){
                    List<Integer> loopList = new ArrayList<>();
                    int it = start;
                    do{
                        loopList.add(it);
                        it = parents[it];
                    }while(it!=start);
                    loopList.add(start);
                    StringBuilder sbr = new StringBuilder();
                    for(int nxt: loopList){
                        sbr.append(nxt + " ");
                    }
                    System.out.println(loopList.size());
                    System.out.println(sbr.toString());
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    public static int  dfs(int node, boolean[] visited, int[] parents,List<List<Integer>> list) {
            visited[node] = true;
            List<Integer> children = list.get(node);
            for(int i : children){
                if(!visited[i]){
                    parents[i] =node;
                    int loop = dfs(i,visited,parents,list);
                    if(loop != -1){
                        return loop;
                    }
                }
                else if(parents[node] != i){
                    parents[i] = node;
                    return i;
                }
            }
            return -1;
    }
}





//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class entry_16053947 {
//    public static void  main(String [] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        List<List<Integer>> list = new ArrayList<>();
//        for(int i =0; i<=n ; i++){
//            list.add(new ArrayList<>());
//        }
//        for(int i =0; i<m ; i++) {
//            st = new StringTokenizer(br.readLine());
//            int cityA = Integer.parseInt(st.nextToken());
//            int cityB = Integer.parseInt(st.nextToken());
//            list.get(cityA).add(cityB);
//            list.get(cityB).add(cityA);
//        }
//        br.close();
//        boolean [] visited = new boolean[n+1];
//        int [] parents = new int[n+1];
//        for(int i=1; i<=n; i++){
//            if(!visited[i]){
//                int start = dfs(i,visited,parents,list);
//
//                if(start == -1)
//                    continue;
//
//                int it = start;
//
//                List<Integer> ans = new ArrayList<>();
//
//                do {
//                    ans.add(it);
//                    it = parents[it];
//                } while (it != start);
//
//                ans.add(start);
//
//                System.out.println(ans.size());
//                StringBuilder sb = new StringBuilder();
//                for (int x :ans) {
//                    sb.append(x).append(' ');
//                }
//                System.out.print(sb.toString());
//                return;
//            }
//        }
//        System.out.println("IMPOSSIBLE");
//    }
//    public static int  dfs(int node, boolean[] visited, int[] parents,List<List<Integer>> list) {
//        visited[node] = true;
//        List<Integer> children = list.get(node);
//
//        for(int next: children) {
//            if(!visited[next]) {
//                parents[next] = node;
//                int res = dfs(next, visited, parents, list);
//                if(res!=-1) {
//                    return res;
//                }
//            } else if(next != parents[node]) {
//                // cycle
//                parents[next] = node;
//                return node;
//            }
//
//        }
//        return -1;
//    }
//
//
//}