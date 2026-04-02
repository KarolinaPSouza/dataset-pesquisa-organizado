//package cses.graph;


import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_11142065 {
    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer s1
                = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(s1.nextToken());
        int m = Integer.parseInt(s1.nextToken());
        ArrayList<Integer>[] list=new ArrayList[n];
        for(int i=0;i<n;i++) list[i]=new ArrayList<>();
        for(int i=0;i<m;i++) {
            StringTokenizer s2
                    = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(s2.nextToken())-1;
            int b = Integer.parseInt(s2.nextToken())-1;
            list[a].add(b);
            list[b].add(a);
        }
        solve(list, n, m);
    }

    static void solve(ArrayList<Integer>[] list, int n, int m) {
        int[] v=new int[n];
        Arrays.fill(v,-1);
        for(int i=0;i<n;i++) {
            if(v[i]!=-1) continue;
            boolean x=bfs(list,v,i);
            if(x) return;
        }
        System.out.println("IMPOSSIBLE");
    }
    static boolean bfs(ArrayList<Integer>[] list,int[] v,int s) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(s,-1));
        while(!q.isEmpty()) {
            Pair p=q.remove();
            int curr=p.a,prev=p.b;
            ArrayList<Integer> internal=list[curr];
            for(int i=0;i<internal.size();i++) {
                int next=internal.get(i);
                if(next==prev) continue;
                if(v[next]!=-1) {
                    ArrayList<Integer> res=new ArrayList<>();
                    func2(v,res,curr,next);
                    return true;
                }
                v[next]=curr;
                q.add(new Pair(next,curr));
            }
        }
        return false;
    }
    static void func2(int[] v,ArrayList<Integer> res,int a,int b) {
        ArrayList<Integer> res1=new ArrayList<>();
        ArrayList<Integer> res2=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        int temp=a;
        while(temp!=-1) {
            set.add(temp);
            temp=v[temp];
        }
        temp=b;
        while(temp!=-1) {
            if(set.contains(temp)) break;
            temp=v[temp];
        }
        while(a!=temp) {
            res1.add(a);
            a=v[a];
        }
        while(b!=temp) {
            res2.add(b);
            b=v[b];
        }
        res1.add(a);
        res2.add(b);
        Collections.reverse(res1);
        res1.addAll(res2);
        print(res1);
    }
    static void print(ArrayList<Integer> list) {
        PrintWriter out=new PrintWriter(System.out);
        out.print(list.size()+"\n");
        for(int i=0;i<list.size();i++) out.print(list.get(i)+1+" ");
        out.print("\n");
        out.flush();

    }
}
class Pair{
    int a,b;
    Pair(int a,int b) {
        this.a=a;
        this.b=b;
    }
}